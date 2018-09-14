package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Knowledge;
import cn.yunji.doctormanager.service.KnowledgeService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/knowledge")
public class KnowledgeController {
	@Resource
	private KnowledgeService knowledgeService;
	@RequestMapping("/queryById.do")
	@ResponseBody
	//查询高危分数
	public JsonResult queryById(int highRiskResultTypeId,int cid){
		return new JsonResult(knowledgeService.queryById(highRiskResultTypeId, cid));
	}

	//高危指标编号和检查指标编号获取知识库对应的医嘱
	@ResponseBody
	@RequestMapping("getKnowledge")
	public Knowledge getKnowledge(int hid, int cid) {
		Knowledge knowledge = knowledgeService.querybyhidcid(hid, cid);
		return knowledge;
	}
	@RequestMapping("/find.do")
	@ResponseBody
	/**
	 * @methodName queryBycid
	 * @description:查询知识库功能
	 * @param cid
	 * @return JsonResult
	 * @throws
	 */
	public JsonResult queryBycid(int cid){
		return new JsonResult(knowledgeService.queryByListId(cid));
	} 
	@ResponseBody
	@RequestMapping("/queryByKeyword")
	public JsonResult queryByKeyword(String keyword) {
		keyword="%"+keyword+"%";
		return new JsonResult(knowledgeService.queryByKeyword(keyword));
	}
}
