package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.DietaryHabit;
import cn.yunji.doctormanager.service.DietaryHabitService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("DietaryHabit")
public class DietaryHabitController {
	
	@Resource
	private DietaryHabitService dietaryHabitService;
	
	@RequestMapping("/insertSelective.do")
	@ResponseBody
	public int insertSelective(DietaryHabit record){
		return dietaryHabitService.insertSelective(record);
	}
	
	/**
	 * 根据mid查出所有
	 * zhongjl
	 * @param mid
	 * @return
	 */
	@RequestMapping("/findByMid.do")
	@ResponseBody
	public JsonResult findByMid(String mid){
		DietaryHabit dietaryHabit = dietaryHabitService.findByMid(mid);
		return new JsonResult(dietaryHabit);
	}
}
