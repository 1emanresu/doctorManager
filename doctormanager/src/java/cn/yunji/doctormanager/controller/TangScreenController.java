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

import cn.yunji.doctormanager.entity.Checkindex;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.TangScreen;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.CheckindexService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.TangScreenService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/TangScreen")
public class TangScreenController {

	@Resource
	private TangScreenService service;
	@Resource
	private GravidaInfoService gravidaInfoService;
	
	@Resource
	private CheckindexService checkindexService;
	@Resource
	private AbnormityinfoService abnormityinfoService;

	@ResponseBody
	@RequestMapping("/findByMid.do")
	public JsonResult findByMid(String mid){
		TangScreen TangScreen = service.findByMid(mid, null);
		return new JsonResult(TangScreen);
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public int add(TangScreen TangScreen){
		
		return service.addTangScreen(TangScreen);
		 
	}
	@ResponseBody
	@RequestMapping("/updateByMid.do")
	public JsonResult update(TangScreen TangScreen){
		
		service.updateByMid(TangScreen);
		
		return  new JsonResult("");
	}
	
	@RequestMapping("/checkReportftl.do")
	public String checkReport(Model model, String mid, @DateTimeFormat(pattern="yyyy/MM/dd") Date checkDate) {
		TangScreen tangScreen = service.findByMid(mid, checkDate);
		GravidaInfo gravidaInfo = gravidaInfoService.find("dg000001");
		if(gravidaInfo != null && tangScreen != null){
			model.addAttribute("hospital","唐氏筛查结果");
			model.addAttribute("name",gravidaInfo.getGname());
//			model.addAttribute("age",gravidaInfo.getMage());//年龄已改，从其他地方获取
			model.addAttribute("numeration",tangScreen.getNumeration());
			model.addAttribute("sampleTime",tangScreen.getSampletime());
			model.addAttribute("sMaterials",tangScreen.getSmaterials());
			model.addAttribute("sMethod",tangScreen.getSmethod());
			model.addAttribute("hAFq",tangScreen.getHafp());
			model.addAttribute("hAFq_MOM",tangScreen.getHafqMom());
			model.addAttribute("free_hcg",tangScreen.getFreeHcg());
			model.addAttribute("free_hcg_MOM",tangScreen.getFreeHcgMom());
			model.addAttribute("NTD",tangScreen.getNtd());
			model.addAttribute("T21",tangScreen.getT21());
			model.addAttribute("T18",tangScreen.getT18());
			model.addAttribute("reportTime",tangScreen.getReporttime());
			model.addAttribute("checkTime",tangScreen.getCheckdate());
			model.addAttribute("examiner",tangScreen.getExaminer());
			model.addAttribute("auditor",tangScreen.getAuditor());
			return "TangScreenCheckReport.ftl";
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/findByProjectId.do")
	public JsonResult findByProjectId(Integer ProjectId){
		List<Checkindex> Checkindex = checkindexService.queryByProjectId(ProjectId);
		return new JsonResult(Checkindex);
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
		List<TangScreen> tlist = service.findByMidAndProject(checkProjectId, mId);
		Date checkDate;
		TangScreen tangScreen ;
		Map<String, Object> map = new HashMap<>();
		if(count!=0){		
    		if (tlist.size() >= count) {
    			tangScreen = tlist.get(count - 1);
    			checkDate = tangScreen.getCheckdate();
    		} else {
    			tangScreen = tlist.get(0);
    			checkDate = tangScreen.getCheckdate();
    		}
    		GravidaInfo gravidainfo=gravidaInfoService.find(mId);
    		map.put("tangScreen", tangScreen);
    		map.put("gravidainfo", gravidainfo);
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
		List<TangScreen> tlist = service.findByMidAndWeek(checkProjectId, mId,weeks);
		TangScreen tangScreen=tlist.get(0);
		Map<String, Object> map = new HashMap<>();
		map.put("tangScreen", tangScreen);
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
			List<TangScreen> tlist = service.findByMidAndWeek(checkProjectId, mId,i);
			if(tlist.size()>0){
				TangScreen tangScreen=tlist.get(0);
				list.add(tangScreen);
			}
			
		}
		return new JsonResult(list);
	 }
}
