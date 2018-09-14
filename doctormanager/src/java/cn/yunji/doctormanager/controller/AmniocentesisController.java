package cn.yunji.doctormanager.controller;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Amniocentesis;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.service.AmniocentesisService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/Amniocentesis")
public class AmniocentesisController {

	@Resource
	private AmniocentesisService service;
	@Resource
	private GravidaInfoService gravidaInfoService;
	
	@ResponseBody
	@RequestMapping("/findByMid.do")
	public JsonResult findByMid(String mid,String checkDate){
		Amniocentesis Amniocentesis = service.findByMid(mid,checkDate);
		return new JsonResult(Amniocentesis);
	}
	
	//查孕妇信息
	@ResponseBody
	@RequestMapping("/gravidaInfo.do")
	public JsonResult add(String mid){
		return new JsonResult(gravidaInfoService.find(mid)); 
	}
	/*@ResponseBody
	@RequestMapping("/updateByMid.do")
	public JsonResult update(Amniocentesis Amniocentesis){
		
		System.out.println(Amniocentesis);
		
		service.updateByMid(Amniocentesis);
		
		return  new JsonResult("");
	}*/
	
	@RequestMapping("/checkReportftl.do")
	public String checkReport(Model model) {
//		System.out.println(11111);
		Amniocentesis amniocentesis = service.findByMid("dg000001", null);
//		System.out.println(22222);
		GravidaInfo gravidaInfo = gravidaInfoService.find("dg000001");
//		System.out.println(33333);
		if(gravidaInfo != null && amniocentesis != null){
///			System.out.println(44444);
			model.addAttribute("hospital","羊水穿刺检测结果");
			model.addAttribute("name",gravidaInfo.getGname());
			//model.addAttribute("age",gravidaInfo.getMage());
			model.addAttribute("CI",amniocentesis.getCi());
			model.addAttribute("sMaterials",amniocentesis.getSmaterials());
			model.addAttribute("sItems",amniocentesis.getSitems());
			model.addAttribute("result",amniocentesis.getResult());
			model.addAttribute("reportTime",amniocentesis.getReporttime());
			model.addAttribute("checkDate",amniocentesis.getCheckDate());
			model.addAttribute("examiner",amniocentesis.getExaminer());
			model.addAttribute("auditor",amniocentesis.getAuditor());
//			System.out.println(55555);
			return "AmniocentesisCheckReport.ftl";
		}
//		System.out.println(66666);
		return null;
	}
	
}
