package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.HighRiskRtandard;
import cn.yunji.doctormanager.service.HighRiskRtandardService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/highRiskRtandard")
public class HighRiskRtandardController {
	@Resource
	private HighRiskRtandardService highRiskRtandardService;
	@RequestMapping("/queryById.do")
	@ResponseBody
	//查询高危分数
	public JsonResult queryById(String hid,int cid){
		return new JsonResult(highRiskRtandardService.queryById(hid, cid));
	}
	//根据检查信息编号获取高危参数--wuwj
	@ResponseBody
	@RequestMapping("/getHighRiskStandard")
	public HighRiskRtandard getHighRiskStandard(int cid) {
		HighRiskRtandard highRiskRtandard = highRiskRtandardService.getHisgRiskStandardbycid(cid);
		return highRiskRtandard;
	}
	 
}
