package cn.yunji.doctormanager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.DoctorAdvice;
import cn.yunji.doctormanager.service.DoctorAdviceService;
import cn.yunji.doctormanager.util.JsonResult;


@Controller
@RequestMapping("/doctorAdvice")
public class DoctorAdviceController {
	@Resource
	private DoctorAdviceService doctorAdviceService;

	@RequestMapping("/addDoctorAdvice.do")
	@ResponseBody
	public int addDoctorAdvices(DoctorAdvice doctorAdvice) {
		return doctorAdviceService.addDoctorAdvice(doctorAdvice);
	}
	/**
	 * @author luoyc
	 * @param mid
	 * @return
	 */
	@RequestMapping("/queryByMid.do")
	@ResponseBody
	public JsonResult findDoctorAdvices(String mid) {
		return new JsonResult(doctorAdviceService.queryByMid(mid));
	}
	
	/**
	 * @author luoyc
	 * @param mid,
	 * @return
	 */
	@RequestMapping("/findByMid.do")
	@ResponseBody
	public Map findDoctorAdvices(String mid,String keyword,String sdate,String edate,Integer pageIndex,Integer pageSize) {
		List<DoctorAdvice> list=doctorAdviceService.findByMid(mid,keyword,sdate,edate,pageIndex,pageSize);
		Map map=new HashMap();
		map.put("total", 10);
		map.put("rows", list);
		return map;
	}
	/**
	 * 查询出当月所有记录
	 * @author luoyc
	 * @param mid
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/findMonthlyAllRecord.do")
	@ResponseBody
	public JsonResult findAllRecord(String mid) throws ParseException{
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Calendar now =Calendar.getInstance();
		int month=now.get(2)+1;
		String mon=month+"";
		if(month<10){
			mon="0"+mon;
		}
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=now.get(1)+"-"+mon+"-"+"01";
		Date start=sdf.parse(dateStr);
		Date end=now.getTime();
		List<DoctorAdvice> doctorAdviceList=doctorAdviceService.findByDateRange(mid, start, end);
		List<Date> dateList=new ArrayList();
		for(DoctorAdvice doctorAdvice:doctorAdviceList){
			dateList.add(doctorAdvice.getAdvicedate());
		}
		return new JsonResult(dateList);	
	}
	/**
	 * 查询出点击的记录
	 * @author luoyc
	 * @param mid
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/findTheRecord.do")
	@ResponseBody
	public JsonResult findAllRecord(String mid,Integer i) throws ParseException{
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Calendar now =Calendar.getInstance();
		int month=now.get(2)+1;
		String mon=month+"";
		if(month<10){
			mon="0"+mon;
		}
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=now.get(1)+"-"+mon+"-"+"01";
		Date start=sdf.parse(dateStr);
		Date end=now.getTime();
		List<DoctorAdvice> doctorAdviceList=doctorAdviceService.findByDateRange(mid, start, end);
		return new JsonResult(doctorAdviceList.get(i));	
	}
}
