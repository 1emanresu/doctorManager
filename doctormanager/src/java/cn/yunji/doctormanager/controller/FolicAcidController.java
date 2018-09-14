package cn.yunji.doctormanager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.FolicAcid;
import cn.yunji.doctormanager.service.FolicAcidService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/folicAcid")
public class FolicAcidController {

	@Resource
	private FolicAcidService service;
	
	@ResponseBody
	@RequestMapping("/findByMid.do")
	public JsonResult findByMid(String mid){
		FolicAcid folicAcid = service.findByMid(mid);
		return new JsonResult(folicAcid);
	}
	
	@ResponseBody
	@RequestMapping("/queryByMid.do")
	public JsonResult queryByMid(String mid){
		List<FolicAcid> folicAcid = service.queryByMid(mid);
		return new JsonResult(folicAcid);
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public JsonResult add(FolicAcid FolicAcid){
		
//		System.out.println(FolicAcid);
		
		service.addFolicAcid(FolicAcid);
		return new JsonResult("");
	}
	@ResponseBody
	@RequestMapping("/updateByMid.do")
	public JsonResult update(FolicAcid FolicAcid,String mid){
//		System.out.println(mid);
		FolicAcid.setMid(mid);
//		System.out.println(FolicAcid);
		
		service.updateByMid(FolicAcid);
		
		return  new JsonResult("");
	}
	
}
