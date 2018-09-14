package cn.yunji.doctormanager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Expertsayarticle;
import cn.yunji.doctormanager.service.ExpertsayarticleService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 专家说文章 孕妇课堂
 * @author yinzx
 *
 */
@Controller
@RequestMapping("/Expertsayarticle")
public class ExpertsayarticleController {
	
	@Resource
	private ExpertsayarticleService expertsayarticleService;

	@ResponseBody
	@RequestMapping("/findPregnancy.do")
	public JsonResult findPregnancy() {
		Map<String, Object> map=new HashMap<>();
		List<Expertsayarticle> hlist = expertsayarticleService.findHealthArticle();
		List<Expertsayarticle> dlist = expertsayarticleService.findDiseaseArticle();
		List<Expertsayarticle> hvideo = expertsayarticleService.findHealthVideo();
		List<Expertsayarticle> dvideo = expertsayarticleService.findDiseaseVideo();
		if (hlist.size()>0) {
			map.put("hlist", hlist);
		}
		if (dlist.size()>0) {
			map.put("dlist", dlist);
		}
		if (hvideo.size()>0) {
			map.put("hvideo", hvideo);
		}
		if (dvideo.size()>0) {
			map.put("dvideo", dvideo);
		}
		return new JsonResult(map);
	}
	

}
