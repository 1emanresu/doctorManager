package cn.yunji.doctormanager.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.BscanService;
import cn.yunji.doctormanager.service.CheckResultService;
import cn.yunji.doctormanager.service.ElectrocardioService;
import cn.yunji.doctormanager.service.FetalHeartService;
import cn.yunji.doctormanager.util.JsonResult;
/**
 * 产前访问Controller
 * @author ZPL
 * 2017年7月13日 16:24:31
 */
@Controller
@RequestMapping("/antenatalVisit")
public class antenatalVisitController {

	@Resource
	private CheckResultService checkResultService;
	@Resource
	private BscanService bscanService;
	@Resource
	private FetalHeartService fetalHeartService;
	@Resource
	private ElectrocardioService electrocardioService;
	
	/**
	 * 孕周产程图数据
	 * @param weeks 孕周
	 * @param checkProjectId 检查项目id
	 * @return
	 */
	@RequestMapping("/queryCheckRequest.do")
	@ResponseBody
	public JsonResult queryCheckDetail(Integer weeks) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> routineBlood = checkResultService.queryCheckDetail(weeks, 1);
		List<Map<String, Object>> routineUrine = checkResultService.queryCheckDetail(weeks, 2);
		List<Map<String, Object>> bscanTip = bscanService.queryBscanTip(weeks);
		List<Map<String, Object>> fhDescription = fetalHeartService.queryDescription(weeks);
		List<Map<String, Object>> electrocardioTip = electrocardioService.queryElectrocardioTip(weeks);
		map.put("routineBlood", routineBlood);
		map.put("routineUrine", routineUrine);
		map.put("bscanTip", bscanTip);
		map.put("fhDescription", fhDescription);
		map.put("electrocardioTip", electrocardioTip);
		return new JsonResult(map);
	}

}