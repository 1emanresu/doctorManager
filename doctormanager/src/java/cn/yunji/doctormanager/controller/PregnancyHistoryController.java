package cn.yunji.doctormanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.PregnancyHistory;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.PregnancyHistoryService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/pregnancyHistory")
public class PregnancyHistoryController {

	@Resource
	private PregnancyHistoryService service;
	@Resource
	private GravidaInfoService gravidaInfo;
	@Resource
	private AbnormityinfoService abnormityinfoService;
	Long SEVEN_DAY=7*24*60*60*1000L;
	@ResponseBody
	@RequestMapping("/findByMid.do")
	public JsonResult findByMid(String mid){
		PregnancyHistory PregnancyHistory=service.queryByMid(mid);
		return new JsonResult(PregnancyHistory);
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public int add(PregnancyHistory PregnancyHistory){
		return service.addPregnancyHistory(PregnancyHistory);
	}
	
	@ResponseBody
	@RequestMapping("/update.do")
	public int updateByMid(PregnancyHistory PregnancyHistory){
		return service.updateByMid(PregnancyHistory);
	}
	
	@ResponseBody
	@RequestMapping("/selectHistoryGradeInfo.do")
	public JsonResult selectHistoryGradeInfo(String mid){
		List<PregnancyHistory> pregnancyHistoryAll=service.selectHistoryGradeInfo(mid);
		return   new JsonResult(pregnancyHistoryAll);
	}
	/**
	 * @author wangwz
	 * @param mid
	 * @return 既往史的信息
	 */
	@ResponseBody
	@RequestMapping("/selectHistory.do")
	public JsonResult selectHistory(String mid){
		String history=null;		 
		List<PregnancyHistory> pregnancyHistoryAll=service.selectHistoryGradeInfo(mid);
		for (PregnancyHistory pregnancyHistory : pregnancyHistoryAll) {
			if(pregnancyHistory.getStillbirth()==1 
					||pregnancyHistory.getOaf()==1
					||pregnancyHistory.getMature()==1
					||pregnancyHistory.getPrematurebirth()==1
					||pregnancyHistory.getAbortion()==1 
					||pregnancyHistory.getHeart()==1
					||pregnancyHistory.getLung()==1
					||pregnancyHistory.getVagina()==1
					||pregnancyHistory.getVulva()==1
					||pregnancyHistory.getCervixUteri()==1){
				history="有";
			}else{
				history="无";
			}
		}
		Map<String, String> map=new HashMap<String,String>();
		map.put("history", history);
		return  new JsonResult(map);
	}
	/**
	 * @author wangwz
	 * @param mid
	 * @return 查询男方血型
	 */
	@ResponseBody
	@RequestMapping("/queryManBlood.do")
	public JsonResult queryManBlood(String mid){
		 Map<String,Object>  map= gravidaInfo.queryManBlood(mid);
		return  new JsonResult(map);
	}
	/**
	 * @author wangwz
	 * @param mid
	 * @return 查询个人史
	 */
	@ResponseBody
	@RequestMapping("/queryPersonage.do")
	public JsonResult queryPersonage(int relationId,String mid){
		 Map<String,Object>  map= gravidaInfo.queryPersonage(relationId, mid);
		return  new JsonResult(map);
	}
	
	/**
	 * @author wangwz
	 * @param mid
	 * @return 查询孕妇的症状
	 */
	@ResponseBody
	@RequestMapping("/querySymptom.do")
	public JsonResult querySymptom(String mid,Integer eWeeks,Integer sWeeks){
		GravidaInfo gravida=gravidaInfo.find(mid);
		Date expectedconfinement=gravida.getExpectedconfinement();
		Long expected=expectedconfinement.getTime();
		Date end=new Date(expected-SEVEN_DAY*(40-eWeeks));
		Date begin=new Date(expected-SEVEN_DAY*(40-sWeeks));
		List<Map<String,Object>> map= gravidaInfo.querySymptom(mid,begin,end);
		return  new JsonResult(map);
	}
	
	/**
	 * @author wangwz
	 * @param mid
	 * @return 查询血压(mmhg)
	 */
	@ResponseBody
	@RequestMapping("/shou.do")
	public JsonResult shou(String mid){
			List<Map<String, Object>> shou=abnormityinfoService.findShouAll(43,mid); 
 		 	List<Map<String, Object>> shu=abnormityinfoService.findShouAll(44,mid);
 		 	 Map<String, Object> map=new HashMap<String,Object>();
 		 	if(shou!=null && shu!=null){
 		 		map.put("shou", shou.get(0).get("abnormity"));
 		 		map.put("shu", shu.get(0).get("abnormity"));
 		 	}
		return  new JsonResult(map);
	}
	
}
