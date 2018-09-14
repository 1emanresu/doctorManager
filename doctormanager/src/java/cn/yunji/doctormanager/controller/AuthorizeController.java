package cn.yunji.doctormanager.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.UserInfo;
import cn.yunji.doctormanager.util.JsonResult;
import cn.yunji.doctormanager.util.ReflectEntity;
import cn.yunji.doctormanager.util.Request;



@Controller
@RequestMapping("/authorize")
public class AuthorizeController {

	
	@ResponseBody
	@RequestMapping("/userCreate.do")
	public JsonResult createNeteaseCloudId(UserInfo userInfo){
		//筛选有效的参数
		Map<String,String> param=ReflectEntity.reflect(userInfo);
		//发送post请求
		String JSONString= Request.request("https://api.netease.im/nimserver/user/create.action", param);
		//输出检查
		//System.out.println(JSONString);
		return new JsonResult(JSONString);
	}
}
