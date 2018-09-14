package cn.yunji.doctormanager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Abnormityinfo;
import cn.yunji.doctormanager.entity.Advice;
import cn.yunji.doctormanager.service.AdviceService;

/**
 * 
 * @author wangwz
 * 反馈信息
 */
@Controller
@RequestMapping("/advice")
public class AdviceController {
	@Resource
	AdviceService adviceService;
	
	/**
	 * 添加反馈信息
	 * @author wangwz
	 * @param advice
	 * @return 1 or 0
	 */
	@RequestMapping("/addAdvice.do")
	@ResponseBody
	public int addAdvice(Advice advice) {
//		System.out.println(adviceService.insertSelective(advice));
	 return adviceService.insertSelective(advice);
	}
}
