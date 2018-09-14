package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.HighrisktestResult;
import cn.yunji.doctormanager.service.HighrisktestResultService;

@Controller
@RequestMapping("/highrisktestResult")
public class HighrisktestResultController {
	@Resource
	private HighrisktestResultService highrisktestResultService;

	@RequestMapping("/insert.do")
	@ResponseBody
	public int insert(HighrisktestResult highrisktestResult) {
//		System.out.println(highrisktestResult);
		highrisktestResultService.insert(highrisktestResult);
		return highrisktestResult.getHighrisktestresultid();
	} 
}
