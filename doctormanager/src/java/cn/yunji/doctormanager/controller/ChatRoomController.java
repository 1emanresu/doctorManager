package cn.yunji.doctormanager.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.yunji.doctormanager.util.JsonResult;
import cn.yunji.doctormanager.util.Request;


@Controller
@RequestMapping("/chatRoom")
public class ChatRoomController {
	
	@ResponseBody
	@RequestMapping (value="/create.do", method = RequestMethod.POST)
	public JsonResult chatroomCreate(String userName,String roomName){
	    //System.out.println("userName="+userName);
		Map<String,String> param=new HashMap<String,String>();
		param.put("creator", userName);
		param.put("name", roomName);
		String JSONString=Request.request("https://api.netease.im/nimserver/chatroom/create.action", param);
		//System.out.println(JSONString);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 查询聊天室的信息
	 * @return
	 */
	@RequestMapping("/get.do")
	@ResponseBody
	public JsonResult chatroomGet(String roomid){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		String JSONString=Request.request("https://api.netease.im/nimserver/chatroom/get.action", param);
		//System.out.println(JSONString);
		return new JsonResult(JSONString);		
	}
	
	/**
	 * 更新聊天室的信息
	 * @return
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult chatroomUpdate(String roomid){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		String JSONString=Request.request("https://api.netease.im/nimserver/chatroom/update.action", param);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 修改聊天室开/关闭状态
	 * @return
	 */
	@RequestMapping("/toggleCloseStat.do")
	@ResponseBody
	public JsonResult toggleCloseStat(String roomid,String userName,String valid){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		param.put("operator",userName);	//要求必须是群主,要求验证
		param.put("valid", valid);			//开/关		
		String JSONString= Request.request("https://api.netease.im/nimserver/chatroom/toggleCloseStat.action", param);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 设置角色
	 * @return
	 */
	@RequestMapping("/setMemberRole.do")
	@ResponseBody
	public JsonResult setMemberRole(String roomid,
									String userId,
									String target,
									String opt,
									String optvalue){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		param.put("operator", userId);		//主人
		param.put("target", target);			//客人
		param.put("opt", opt);					//群主or管理员		
		param.put("optvalue", optvalue);		
		String JSONString= Request.request("https://api.netease.im/nimserver/chatroom/setMemberRole.action", param);
		//System.out.println(JSONString);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 请求地址
	 * @return
	 */
	@RequestMapping("/requestAddr.do")
	@ResponseBody
	public JsonResult requestAddr(String roomid,String userid){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		param.put("accid", userid);
		String JSONString= Request.request("https://api.netease.im/nimserver/chatroom/requestAddr.action", param);
		//System.out.println(JSONString);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 发送信息
	 * @return
	 */
	@RequestMapping("/sendMsg.do")
	@ResponseBody
	public JsonResult sendMsg(	String roomid,
								String msgId,
								String fromAccid,
								String attach,
								String msgType){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		param.put("msgId", msgId);		//msgID
		param.put("fromAccid", fromAccid);	//userID
		param.put("msgType", msgType);		
		param.put("attach", attach);
		String JSONString= Request.request("https://api.netease.im/nimserver/chatroom/sendMsg.action", param);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 设置临时禁言状态
	 * @return
	 */
	@RequestMapping("/temporaryMute.do")
	@ResponseBody
	public JsonResult temporaryMute(String roomid,
									String operator,
									String target,
									String muteDuration){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		param.put("operator", operator);	//主人
		param.put("target", target);		//客人
		param.put("muteDuration", muteDuration);
		String JSONString= Request.request("https://api.netease.im/nimserver/chatroom/temporaryMute.action", param);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 初始化队列
	 * @return
	 */
	@RequestMapping("/queueInit.do")
	@ResponseBody
	public JsonResult queueInit(String roomid,String sizeLimit){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		param.put("sizeLimit", sizeLimit);
		String JSONString= Request.request("https://api.netease.im/nimserver/chatroom/queueInit.action", param);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 全体禁言
	 * @return
	 */
	@RequestMapping("/muteRoom.do")
	@ResponseBody
	public JsonResult muteRoom(	String roomid,
								String operator,
								String mute){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);
		param.put("operator", operator);
		param.put("mute", mute);
		String JSONString= Request.request("https://api.netease.im/nimserver/chatroom/muteRoom.action", param);
		return new JsonResult(JSONString);
	}
	
	/**
	 * 查询信息历史记录
	 * @return
	 */
	@RequestMapping("/queryChatroomMsg.do")
	@ResponseBody
	public JsonResult queryChatroomMsg(	String roomid,
										String accid,
										String timetag,
										String limit){
		Map<String,String> param=new HashMap<String,String>();
		param.put("roomid", roomid);	
		param.put("accid", accid);			
		param.put("timetag", timetag);		//查询的时间戳
		param.put("limit", limit);			//查多少条
		String JSONString= Request.request("https://api.netease.im/nimserver/chatroom/queryChatroomMsg.action", param);
		return new JsonResult(JSONString);
	}
}
