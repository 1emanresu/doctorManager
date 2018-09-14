package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.OfficeService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/office")
public class OfficeController {
	@Resource
	private OfficeService officeService;
	@ResponseBody
	@RequestMapping("findOffice")
	public JsonResult findOffice(){
		return new JsonResult(officeService.findOffice());
	}
}
