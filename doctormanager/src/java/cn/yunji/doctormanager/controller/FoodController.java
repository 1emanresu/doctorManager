package cn.yunji.doctormanager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Food;
import cn.yunji.doctormanager.service.FoodService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/food")
public class FoodController {

	@Resource
	private FoodService foodService;
	
	/**
	 * 查询高糖、高淀粉、高脂肪、高寒、辛辣、纤维类食物
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findfoodlist.do")
	public JsonResult findfoodlist(){
		
		Map<String, Object> map=new HashMap<>();
		List<Food> sugar = foodService.findByAttribute("糖");
		List<Food> fat = foodService.findByAttribute("脂肪");
		List<Food> cold = foodService.findByAttribute("寒凉");
		List<Food> fibre = foodService.findByAttribute("纤维");
		List<Food> spicy = foodService.findByAttribute("辛辣");
		List<Food>starch = foodService.findByAttribute("淀粉");
		if (sugar.size()>0) {
			map.put("sugar", sugar);
		}
		if (fat.size()>0) {
			map.put("fat", fat);
		}
		if (cold.size()>0) {
			map.put("cold", cold);
		}
		if (fibre.size()>0) {
			map.put("fibre", fibre);
		}
		if (spicy.size()>0) {
			map.put("spicy", spicy);
		}
		if (starch.size()>0) {
			map.put("starch", starch);
		}
		return new JsonResult(map);
	}
}
