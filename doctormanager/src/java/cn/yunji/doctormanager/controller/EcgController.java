package cn.yunji.doctormanager.controller;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.MyEcg;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.MyEcgService;
import cn.yunji.doctormanager.util.JsonResult;
@Controller
@RequestMapping("/myEcg")
public class EcgController{
	@Resource
	private MyEcgService myEcgService;
	@Resource
	private GravidaInfoService gravidaInfoService;
	Long SEVEN_DAY=7*24*60*60*1000L;
	Date end =new Date();
	Date begin=new Date(end.getTime()-SEVEN_DAY);
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult find(String mid){
		try {
			List<MyEcg> list=myEcgService.find(mid);
			return new JsonResult(list);
		}catch (Exception e) {
			return new JsonResult(e);
		}	
	}
	

	@RequestMapping("/findByWeekly.do")
	@ResponseBody
	public JsonResult findByWeekly(String mid,Integer eWeeks,Integer sWeeks){
		GravidaInfo gravidaInfo=gravidaInfoService.find(mid);
		Date expectedconfinement=gravidaInfo.getExpectedconfinement();
		Long expected=expectedconfinement.getTime();
		Date end=new Date(expected-SEVEN_DAY*(40-eWeeks));
		Date begin=new Date(expected-SEVEN_DAY*(40-sWeeks));
		try {
			List<MyEcg> list=myEcgService.findByDateRange(mid, begin, end);
			return new JsonResult(list);
		}catch (Exception e) {
			return new JsonResult(e);
		}	
	}
	@RequestMapping("/findByDateRange.do")
	@ResponseBody
	public JsonResult findByDateRange(String mid){
		List<MyEcg> list=myEcgService.findByDateRange(mid, begin, end);
		return new JsonResult(list);	
	}
}
