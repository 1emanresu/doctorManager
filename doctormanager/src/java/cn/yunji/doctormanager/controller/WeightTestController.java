package cn.yunji.doctormanager.controller;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.Temperature;
import cn.yunji.doctormanager.entity.WeightTest;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.TemperatureService;
import cn.yunji.doctormanager.service.WeightTestService;
import cn.yunji.doctormanager.util.JsonResult;
import net.sf.json.processors.JsDateJsonBeanProcessor;
@Controller
@RequestMapping("/weightTest")
public class WeightTestController {
	@Resource
	private WeightTestService weightTestService;
	Long SEVEN_DAY=7*24*60*60*1000L;
	Date end =new Date();
	Date begin=new Date(end.getTime()-SEVEN_DAY);
	
	
	@RequestMapping("/findByDateRange.do")
	@ResponseBody
	public JsonResult findByDateRange(String mid){
		List<WeightTest> list=weightTestService.findByDateRange(mid, begin, end);
		return new JsonResult(list);	
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult selectByPrimaryKey(Integer wid){
		WeightTest weightTest = weightTestService.selectByPrimaryKey(wid);
		return new JsonResult(weightTest);
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult updateByPrimaryKey(Integer wid){
		WeightTest weightTest = weightTestService.updateByPrimaryKey(wid);
		return new JsonResult(weightTest);
	}
	
	@RequestMapping("/selectByMid.do")
	@ResponseBody
	public JsonResult selectByMid(String mid){
		List<WeightTest> weightText = weightTestService.selectByMid(mid);
		return new JsonResult(weightText);
	}
}
