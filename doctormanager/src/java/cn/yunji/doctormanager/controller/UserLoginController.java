
package cn.yunji.doctormanager.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.yunji.doctormanager.entity.Doctor;
import cn.yunji.doctormanager.entity.NeteasyIm;
import cn.yunji.doctormanager.entity.UserTb;
import cn.yunji.doctormanager.service.LoginAllException;
import cn.yunji.doctormanager.service.NeteasyImService;
import cn.yunji.doctormanager.service.UserLoginService;
import cn.yunji.doctormanager.util.JsonResult;
import cn.yunji.doctormanager.entity.UserInfo;
import cn.yunji.doctormanager.util.ReflectEntity;
import cn.yunji.doctormanager.util.Request;

@Controller
@RequestMapping("/user")
public class UserLoginController extends BaseController {
	@Resource
	private UserLoginService userLoginService;
	@Resource
    private NeteasyImService IMService;

	// 医生
	@RequestMapping("/doctor.do")
	@ResponseBody
	public JsonResult login(String userName, String password, String rType) {
		Map<String, Object> ids = userLoginService.login(userName, password, rType);
		return new JsonResult(ids);
	}

	// 孕妇
	@RequestMapping("/yfwoman.do")
	@ResponseBody
	public JsonResult login2(String userName, String password, String rType) {
		Map<String, Object> ids = userLoginService.login(userName, password, rType);
		// System.out.println(userName+","+password+","+rType);
		return new JsonResult(ids);
	}

	// 护士
	@RequestMapping("/nuser.do")
	@ResponseBody
	public JsonResult login3(String userName, String password, String rType) {
		Map<String, Object> ids = userLoginService.login(userName, password, rType);
		// System.out.println(userName+","+password+","+rType);
		return new JsonResult(ids);
	}

	// 注册
	@RequestMapping("/register.do")
	@ResponseBody
	public int register(UserTb user) {
		// 设置为未登录
		user.setLoginstatus("E");
		int ret=userLoginService.register(user);
		int yjuuserid=userLoginService.queryByUserName(user.getUsername());// 云济userID
	        //System.out.println("yjuuserid=="+yjuuserid);
	        if (ret > 0 && yjuuserid > 0) {
	            UserInfo userInfo = new UserInfo();
	            userInfo.setAccid(user.getUsername());
	            userInfo.setMobile(user.getUsername());
	            userInfo.setToken(user.getPassword());
	            userInfo.setName(user.getNickname());
	            userInfo.setIcon(user.getAvatar());
	            // 筛选有效的参数
	            Map<String, String> param = ReflectEntity.reflect(userInfo);
	            // 发送post请求
	            String JSONString = Request.request("https://api.netease.im/nimserver/user/create.action", param);
	            //解析JSON字符串
	            String resultJson=JSONObject.parseObject(JSONString).getString("code");       
	            if(resultJson.equals("200")){
	                NeteasyIm neteasyIM = new NeteasyIm();
	                neteasyIM.setYjuuserid(yjuuserid);
	                neteasyIM.setImpassword(user.getPassword());
	                neteasyIM.setImnickname(user.getNickname());
	                neteasyIM.setImid(user.getUsername());
	                IMService.insertSelective(neteasyIM);
	            }else{
	                //如果网易账号已注册或不返回200，则给一个默认的网易账号（一般用作测试）
	                NeteasyIm neteasyIM = new NeteasyIm();
	                neteasyIM.setYjuuserid(yjuuserid);
	                neteasyIM.setImpassword("123456");
	                neteasyIM.setImnickname("医生");
	                neteasyIM.setImid("15999809017");
	                IMService.insertSelective(neteasyIM);
	            }        
	        }
		return yjuuserid;
	}
	
	/**
	 * 创建医生账号,初始密码为123456
	 * @param user 用户对象
	 * @param doctor 医生对象
	 * @return int
	 * @author zhangqt
	 * @createDate 2017年10月31日 下午2:47:38
	 */
	@RequestMapping("/createAccount.do")
	@ResponseBody
	public int createAccount(UserTb user,Doctor doctor) {
		//System.out.println(user.toString());
		//System.out.println(doctor.toString());
		// 设置为未登录
		user.setLoginstatus("E");
		int i=userLoginService.register(user);
		return i;
	}
	
	

	// web信息系统登录
	@RequestMapping("/webLogin.do")
	@ResponseBody
	public JsonResult webLogin(String userName, String password,HttpSession session) {
	   // System.out.println("userName:"+userName+"  password:"+password);
		Map<String, Object> ids = userLoginService.webLogin(userName, password);
		//System.out.println("ids:"+ids.toString());
		if (ids != null) {
		    NeteasyIm IMAccount = IMService.findByUserid((Integer)ids.get("userId"));// 获取网易云账号信息
		    ids.put("IMAccount", IMAccount);
		    //System.out.println("userID："+ids.get("userId")+"sessionID:"+session.getId()+"     address:"+session.getLastAccessedTime());
			session.setAttribute("userid", ids.get("userId").toString());
			String user = (String) session.getAttribute("userid");
		    //System.out.println("getUser:"+user);
			return new JsonResult(ids);
		}
		return null;
	}
	// 根据mid查询网易账号信息 yinzx
    @RequestMapping("/findIMByMid.do")
    @ResponseBody
    public JsonResult findIMByMid(String mid) {
        //System.out.println("mid:"+mid);
        NeteasyIm IMAccount = IMService.findIMByMid(mid);// 获取网易云账号信息
         
        return new JsonResult(IMAccount);
    }
	
	
	@ExceptionHandler(LoginAllException.class)
	@ResponseBody
	public JsonResult handlePwdOrAccountExp(LoginAllException e) {
		e.printStackTrace();
		return new JsonResult(2, e);
	}
	
	@RequestMapping("/getUserID.do")
    @ResponseBody
    public JsonResult getUserID(HttpSession session){
        //System.out.println("开始,sessionID:"+session.getId()+"     address:"+session.getLastAccessedTime());
        String user = (String) session.getAttribute("userid");
        //System.out.println("getUser:"+user);
        return new JsonResult(user);
    }

}
