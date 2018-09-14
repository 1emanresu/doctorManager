package cn.yunji.doctormanager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.HighriskProblem;
import cn.yunji.doctormanager.service.HighriskProblemService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/highriskProblem")
public class HighriskProblemController {
	@Resource
	private HighriskProblemService highriskProblemService;

	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult find() {
		List<HighriskProblem> list = highriskProblemService.find();
		return new JsonResult(list);
	}
}
