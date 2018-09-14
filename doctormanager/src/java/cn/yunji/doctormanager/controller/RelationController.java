package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.RelationService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/relation")
public class RelationController {
	@Resource
	private RelationService relationService;
	@ResponseBody
	@RequestMapping("/find.do")
	public JsonResult find(){
		return new JsonResult(relationService.find());
	}
	
}
