package cn.yunji.doctormanager.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Electrocardio;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.Templatetitle;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.ElectrocardioService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.TemplatetitleService;
import cn.yunji.doctormanager.util.JsonResult;
//心电
@Controller
@RequestMapping("/electrocardio")
public class ElectrocardioController {
	@Resource
	private ElectrocardioService electrocardioService;
	@Resource
	private GravidaInfoService gravidaInfoService;
	@Resource
    private TemplatetitleService TemplatetitleService;
	@Resource
	private AbnormityinfoService abnormityinfoService;

	
	@RequestMapping("/queryByMid.do")
	@ResponseBody
	//以孕妇id 与检查的时间查询心电检查的结果
	public JsonResult queryByMid(String mid,String checkDate) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Electrocardio e=electrocardioService.queryByMid(mid, sdf.parse(checkDate));
		return new JsonResult(e);
	}
	//添加心电信息
	@RequestMapping("/add.do")
	@ResponseBody
	public int add(Electrocardio e ,String checkDate) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		e.setCheckdate(sdf.parse(checkDate));
		int i=electrocardioService.addEcg(e);
		return i;
	}
	
	@RequestMapping("/checkReportftl.do")
	public String checkReport(Model model, String mid, @DateTimeFormat(pattern="yyyy/MM/dd") Date checkDate) {
		Electrocardio Electrocardio = electrocardioService.findByMid(mid,checkDate);
		GravidaInfo gravidaInfo = gravidaInfoService.find(mid);
		if(gravidaInfo != null && Electrocardio != null){
			model.addAttribute("hospital","心电结果");
			model.addAttribute("name",gravidaInfo.getGname());
			model.addAttribute("checkDate",Electrocardio.getCheckdate());
			model.addAttribute("HeartRate",Electrocardio.getHeartrate());
			model.addAttribute("RoomRate1",Electrocardio.getRoomrate1());
			model.addAttribute("RoomRate2",Electrocardio.getRoomrate2());
			model.addAttribute("QRS_Ea",Electrocardio.getQrsEa());
			model.addAttribute("QTc",Electrocardio.getQtc());
			model.addAttribute("p",Electrocardio.getP());
			model.addAttribute("p_R",Electrocardio.getpR());
			model.addAttribute("QRS",Electrocardio.getQrs());
			model.addAttribute("RV5_SV1",Electrocardio.getRv5Sv1());
			model.addAttribute("RScount",Electrocardio.getRscount());
			return "ElectrocardioCheckReport.ftl";
		}
		return null;
	}
	/**
	 * 给定孕周范围、mid、 检查项目id查询检查明细数据   
	 * @param startWeek 起始孕周
	 * @param endWeek 结束孕周
	 * @param checkProjectId 检查项目id
	 * @param mId 孕妇id
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/findResultByWeeks.do")
	 public JsonResult findResultByWeeks(Integer startWeek, Integer endWeek, Integer checkProjectId,String mId){
		 List<Object> list=new ArrayList<>();
			for (int i = endWeek; i >= startWeek; i--) {
			
				Electrocardio ecg= electrocardioService.findByMidAndWeeks(i, checkProjectId, mId);
				if(ecg!=null){
					list.add(ecg);
				}
			}
		  return new JsonResult(list);
	 }
	/**
	  * 按孕周查询：根据孕周、mid、 检查项目id查看B超报告  yinzx
	  * @param mid
	  * @param weeks
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/findByMidAndWeeks.do")
	 public JsonResult findByMidAndWeeks(Integer weeks, Integer checkProjectId,String mId){
		  Electrocardio ecg= electrocardioService.findByMidAndWeeks(weeks, checkProjectId, mId);
		   Map<String, Object> map=new HashMap<>();
		    map.put("ecg", ecg);
	        Templatetitle templatetitle = TemplatetitleService.queryCheckDetail(weeks, checkProjectId, mId);
	        if(templatetitle!=null){
	        	map.put("templatetitle", templatetitle);
	        }
	        return new JsonResult(map);
	 }
	 /**
		 * 按项目查询： 根据检查项目id、mid、检查结果id 查询检查明细及指标  @yinzx
		 * @param count 第几次产检
		 * @param checkProjectId 检查项目id
		 * @param mId 孕妇id
		 * @return 查询检查明细及指标  
		 */
	 @RequestMapping("/queryResultByProject.do")
	 @ResponseBody
	public JsonResult queryResultByProject(Integer count, Integer checkProjectId, String mId) {
		List<Electrocardio> ecglist = electrocardioService.findByMidAndProject(checkProjectId, mId);
		Date checkDate;
		Electrocardio ecg;
		Map<String, Object> map = new HashMap<>();
		if(count!=null){
		    if (ecglist.size() >= count) {
	            ecg=ecglist.get(count - 1);
	            checkDate =ecg.getCheckdate();
	        } else {
	            ecg=ecglist.get(0);
	            checkDate =  ecg.getCheckdate();
	        }	        
	        map.put("ecg", ecg);
	        //Templatetitle templatetitle = TemplatetitleService.queryCheckDetailByDate(checkDate, checkProjectId, mId);
	        List<Map<String, Object>> list = abnormityinfoService.queryByCheckProjectId(mId,checkDate,checkProjectId);
//	      if (templatetitle != null) {
//	          map.put("templatetitle", templatetitle);
//	      }
	        if(list.size()>0){
	            map.put("abnormityinfo", list);//异常信息
	        }  
		}
		return new JsonResult(map);
	}
}