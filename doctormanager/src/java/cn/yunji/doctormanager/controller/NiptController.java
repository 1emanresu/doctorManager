package cn.yunji.doctormanager.controller;

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

import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.Nipt;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.NiptService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/Nipt")
public class NiptController {
	@Resource
	private NiptService niptService;
	@Resource
	private GravidaInfoService gravidaInfoService;
	@Resource
	private AbnormityinfoService abnormityinfoService;


	/**
	 * NIPT根据孕妇ID及检查时间查询
	 * 
	 * @param mid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findByMid.do")
	public JsonResult findByMid(String mid) {
		Nipt Nipt = niptService.findByMid(mid, null);
		return new JsonResult(Nipt);
	}

	@ResponseBody
	@RequestMapping("getNipt")
	public Nipt getNipt(String mid) {
		return niptService.queryBymid(mid);
	}

	@ResponseBody
	@RequestMapping("getWeekNipt")
	public List<Map<String, Object>> getWeekNipt(String mid) {
		return niptService.queryByDate(mid);
	}

	@RequestMapping("/checkReportftl.do")
	public String checkReport(Model model, String mid, @DateTimeFormat(pattern = "yyyy/MM/dd") Date checkDate) {
		Nipt nipt = niptService.findByMid(mid, checkDate);
		GravidaInfo gravidaInfo = gravidaInfoService.find("dg000001");
		if (gravidaInfo != null && nipt != null) {
			model.addAttribute("hospital", "nipt检测结果");
			model.addAttribute("name", gravidaInfo.getGname());
			model.addAttribute("sampleTime", nipt.getSampletime());
			model.addAttribute("receivedTime", nipt.getReporttime());
			model.addAttribute("endDate", nipt.getEnddate());
			model.addAttribute("history", nipt.getHistory());
			model.addAttribute("fetusNumber", nipt.getFetusnumber());
			model.addAttribute("IVF_ET", nipt.getIvfEt());
			model.addAttribute("T21", nipt.getT21());
			model.addAttribute("T18", nipt.getT18());
			model.addAttribute("T13", nipt.getT13());
			model.addAttribute("reportTime", nipt.getReporttime());
			model.addAttribute("checkDate", nipt.getCheckdate());
			model.addAttribute("examiner", nipt.getExaminer());
			model.addAttribute("auditor", nipt.getAuditor());
			return "NiptCheckReport.ftl";
		}
		return null;
	}

	/**
	 * 按项目查询： 根据检查项目id、mid、检查结果id 查询检查明细及指标 @yinzx
	 * @param count 第几次产检
	 * @param checkProjectId 检查项目id
	 * @param mId  孕妇id
	 * @return 查询检查明细及指标
	 */
	@RequestMapping("/queryResultByProject.do")
	@ResponseBody
	public JsonResult queryResultByProject(Integer count, Integer checkProjectId, String mId) {
		List<Nipt> niptlist = niptService.findByMidAndProject(checkProjectId, mId);
		Date checkDate;
		Nipt nipt;
        Map<String, Object> map = new HashMap<>();
		if(count!=0){
    		if (niptlist.size() >= count) {
    			nipt = niptlist.get(count - 1);
    			checkDate = nipt.getCheckdate();
    		} else {
    			nipt = niptlist.get(count - 1);
    			checkDate = nipt.getCheckdate();
    		}
    		map.put("nipt", nipt);
    		List<Map<String, Object>> list = abnormityinfoService.queryByCheckProjectId(mId,checkDate,checkProjectId);
    		if(list!=null){
    			map.put("abnormityinfo", list);//异常信息
    		}
		}
		return new JsonResult(map);
	}
	/**
	 * 按孕周查询： 根据检查项目id、mid、孕周 查询检查明细及指标 @yinzx
	 * @param weeks 孕周
	 * @param checkProjectId 检查项目id
	 * @param mId  孕妇id
	 * @return 查询检查明细及指标
	 */
	@RequestMapping("/queryResultByWeek.do")
	@ResponseBody
	public JsonResult queryResultByWeek(Integer weeks, Integer checkProjectId, String mId) {
		List<Nipt> niptlist = niptService.findByMidAndWeek(checkProjectId, mId,weeks);
		Map<String, Object> map = new HashMap<>();
		Nipt nipt = niptlist.get(0);
		map.put("nipt", nipt);
		return new JsonResult(map);
	
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
			List<Nipt> niptlist = niptService.findByMidAndWeek(checkProjectId, mId,i);
			if (niptlist.size()>0) {
				Nipt nipt = niptlist.get(0);
				list.add(nipt);
			}
			
		}
		return new JsonResult(list);
	 }
}