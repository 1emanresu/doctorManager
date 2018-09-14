package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Hospital;
import cn.yunji.doctormanager.service.HospitalService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
	@Resource
	private HospitalService hospitalService;
	
	@ResponseBody
	@RequestMapping("/find.do")
	public JsonResult find(){
		return new JsonResult(hospitalService.find());
	}
	
	@RequestMapping("/selectbykey.do")
	@ResponseBody
	public JsonResult selectByPrimaryKey(String hospitalid){
		Hospital hospital = hospitalService.selectByPrimaryKey(hospitalid);
		return new JsonResult(hospital);
	}
}
