package cn.yunji.doctormanager.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.CountQuickening;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.service.CountQuickeningService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.util.JsonResult;
@Controller
@RequestMapping("/countQuickening")
public class CountQuickeningController{
	@Resource
	private CountQuickeningService countQuickeningService;
	@Resource
	private GravidaInfoService gravidaInfoService;
	Long SEVEN_DAY=7*24*60*60*1000L;
	Date end =new Date();
	Date begin=new Date(end.getTime()-SEVEN_DAY);
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult find(String mid){
		try {
			List<CountQuickening> list=countQuickeningService.find(mid);
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
			List<CountQuickening> list=countQuickeningService.findByDateRange(mid, begin, end);
			return new JsonResult(list);
		} catch (Exception e) {
			return new JsonResult(e);
		}	
	}
	@RequestMapping("/findByDateRange.do")
	@ResponseBody
	public JsonResult findByDateRange(String mid){
		List<CountQuickening> list=countQuickeningService.findByDateRange(mid, begin, end);
		return new JsonResult(list);	
	}
	@RequestMapping("/findByDateRange2.do")
    @ResponseBody
    public JsonResult findByDateRange2(String mid,String endDate) throws ParseException{
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    Date endDate1=sdf.parse(endDate);
	    Date begin=new Date(endDate1.getTime()-SEVEN_DAY);
        List<CountQuickening> list=countQuickeningService.findByDateRange(mid, begin, endDate1);
        return new JsonResult(list);    
    }
}
