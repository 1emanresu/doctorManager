package cn.yunji.doctormanager.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.HighriskTest;
import cn.yunji.doctormanager.service.HighriskTestService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/highriskTest")
public class HighriskTestController {
	@Resource
	private HighriskTestService highriskTestService;
	@ResponseBody
	@RequestMapping("/findByMid.do")
	public JsonResult findByMid(String mid){
		List<Map<String,Object>> list=highriskTestService.findByMid(mid);
		return new JsonResult(list);
	}
	
	@ResponseBody
	@RequestMapping("/insertLoop.do")
	public JsonResult insertLoop(@RequestBody List<HighriskTest>  highriskTestList){
//		System.out.println("长度"+highriskTestList.size());
		highriskTestService.insertLoop(highriskTestList); 
		return new JsonResult(1);
	}
	@RequestMapping("/findByMidandweeks.do")
	@ResponseBody
	public JsonResult findByMidandweeks(String mid, String begintime, String endtime){
		List<Map<String, Object>> list = highriskTestService.findByMidandweeks(mid, begintime, endtime);
		return new JsonResult(list);
	}
}
 