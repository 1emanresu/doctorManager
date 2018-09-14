package cn.yunji.doctormanager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.yunji.doctormanager.entity.HighRiskResultType;
import cn.yunji.doctormanager.service.HighRiskResultTypeService;
import cn.yunji.doctormanager.util.JsonResult;
@Controller
@RequestMapping("/highRiskResultType")
public class HighRiskResultTypeController {
	@Resource
	private HighRiskResultTypeService highRiskResultTypeService;
	@RequestMapping("/queryByType.do")
	@ResponseBody
	//查询所有的高危类型
	public JsonResult queryByType(int score){
		HighRiskResultType e=highRiskResultTypeService.queryByType(score);
		return new JsonResult(e);
    }

	//获取高危类型
	@ResponseBody
	@RequestMapping("getHRRT")
	public HighRiskResultType getHighRiskResultType(int score) {
		return highRiskResultTypeService.queryByScore(score);
	}
    
    @ResponseBody
    @RequestMapping("/queryAll.do")
    public JsonResult queryAll() {
        List<HighRiskResultType> HighRiskResultType = highRiskResultTypeService.queryAll();
        return new JsonResult(HighRiskResultType);
    }
}
