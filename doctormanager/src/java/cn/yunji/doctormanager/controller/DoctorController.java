package cn.yunji.doctormanager.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Decoder.BASE64Decoder;
import cn.yunji.doctormanager.entity.Doctor;
import cn.yunji.doctormanager.entity.UserTb;
import cn.yunji.doctormanager.service.DoctorService;
import cn.yunji.doctormanager.service.UserTbService;
import cn.yunji.doctormanager.util.JsonResult;
import cn.yunji.doctormanager.util.SimpleResult;

/**
 * 
 * @author Wangzw 医生
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Resource
	public DoctorService doctorService;
	@Resource
	private UserTbService userTbService;
	private List<String> list = new ArrayList<String>();

	/**
	 * @author Wangzw
	 * @param did
	 * @return 医生的个人信息列表
	 */
	@ResponseBody
	@RequestMapping("/findByDoctordid.do")
	public JsonResult findByMid(int did) {
		List<Map<String, Object>> doctor = doctorService.queryByDoctortId(did);
		return new JsonResult(doctor);
	}

	/**
	 * 创建医生账号
	 * 
	 * @author zhangqt
	 * @param did
	 * @return int
	 */
	@ResponseBody
	@RequestMapping("/addDoctorAccount.do")
	public JsonResult addDoctorAccount(Doctor doctor, UserTb user) {
		user.setLoginstatus("E");
		int u = userTbService.addUser(user);
		if (u > 0) {
			doctor.setDphone(user.getUsername());
			doctor.setUserid(user.getUserid());
			doctorService.addDoctorAccount(doctor);
		}
		return new JsonResult(u);
	}

	/**
	 * 跟新医生头像
	 * 
	 * @author Wangzw
	 * @param did
	 * @return 1
	 */
	@ResponseBody
	@RequestMapping("/updateDoctorAvatar.do")
	public JsonResult updateDoctorAvatar(String avatar, int doctorId) {
		try {
			Doctor doctor = doctorService.findDoctor(doctorId);
			UserTb userTb = new UserTb();
			userTb.setUserid(doctor.getUserid());
			userTb.setImage(avatar);
			int ret = userTbService.updateByPrimaryKeySelective(userTb);
			return new JsonResult(ret);
		} catch (Exception e) {
			return new JsonResult(-1);
		}

	}

	/**
	 * 图片上传
	 * 
	 * @author Wangzw
	 * @param imgdata
	 * @param request
	 * @return Object
	 */
	@SuppressWarnings("resource")
	@ResponseBody
	@RequestMapping("/PicUpload.do")
	public Object pictureUpload(String imgdata, HttpServletRequest request) {
		BASE64Decoder decoder = new BASE64Decoder();
		FileOutputStream outputstream;
		try {
			String basepath = request.getServletContext().getRealPath("/");
			File folder = new File(basepath + "/doctor/pics/avator/");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			String filename = basepath + "/doctor/pics/avator/" + picId() + ".jpg";
			File imgfile = new File(filename);
			outputstream = new FileOutputStream(imgfile);
			byte[] result = decoder.decodeBuffer(imgdata.split(",")[1]);
			for (int i = 0; i < result.length; i++) {
				if (result[i] < 0) {
					result[i] += 256;
				}
			}
			outputstream.write(result);
			String name = filename.substring(filename.lastIndexOf('/') + 1);
			list.add(name);
			outputstream.flush();
			outputstream.close();

			return new SimpleResult(true, filename);
		} catch (IOException e) {
			e.printStackTrace();
			return new SimpleResult(false, "上传文件失败");
		}
	}

	/**
	 * 图片上传
	 * 
	 * @author Wangzw
	 * @param request
	 * @return List
	 */
	@ResponseBody
	@RequestMapping("/getImg.do")
	public List<String> imgList(HttpServletRequest request) {
		return list;
	}

	/**
	 * 图片上传
	 * 
	 * @author Wangzw
	 */
	public String picId() {
		UUID uuid = UUID.randomUUID();
		String suuid = uuid.toString();
		suuid = suuid.replace("-", "");
		return suuid;
	}

	/**
	 * 医生app工作站的基本信息
	 * 
	 * @author mcally.ly
	 * @return Map
	 */
	@RequestMapping("/basicInfo.do")
	@ResponseBody
	// 医生基本信息
	public JsonResult doctorbasic(Integer did) {
		Map<String, Object> map = doctorService.doctorBasicAndfansAndIntegral(did);
		return new JsonResult(map);
	}

	/**
	 * 医生app工作站的患者的基本信息
	 * 
	 * @author mcally.ly
	 */

	// 风险预警信息
	@RequestMapping("/prewarning.do")
	@ResponseBody
	public JsonResult risk(Integer doctorid) {
		List<Map<String, Object>> map = doctorService.riskprewarning(doctorid);
		return new JsonResult(map);
	}
	/**
	 * 查询所有医生的账户信息，包括所属医院、科室
	 * @param hid （医院id）、dname(医生名称) 都是可选参数
	 * @author zhangqt
	 * @return List
	 * @createDate 2017年10月31日 上午10:05:25
	 */
	@RequestMapping("/queryInfo.do")
	@ResponseBody
	public Map queryInfo(String hid,String dname,Integer pageIndex,Integer pageSize) {
		List<Map<String, Object>> list = doctorService.queryInfo(hid,dname,pageIndex,pageSize);
		Map s = new HashMap();
		s.put("total", doctorService.queryInfoCount(hid,dname));
		s.put("rows", list);
		return  s;
	}
	 /**
     *  查询所有的产科的医生
     * @Description: TODO(用一句话描述该方法做什么) 
     * @param officeId
     * @return
     * @author wangzw
     */
    @RequestMapping("/findByofficeId.do")
    @ResponseBody
    public JsonResult findByofficeId(int offItemId) {
        return new JsonResult(doctorService.findByofficeId(offItemId));
    }
}
