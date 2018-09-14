/**@Title:FoodproblemController.java
 * @description
 * @author king_smm
 * @date 2017年12月1日下午2:21:51
 * @copyright(c) 2017 云济健康管理(深圳)有限公司 AllRight Reserved.
 */
package cn.yunji.doctormanager.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Foodproblem;
import cn.yunji.doctormanager.service.FoodproblemService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/foodproblem")
public class FoodproblemController {
	@Resource
	private FoodproblemService foodproblemService;
	
	@ResponseBody
	@RequestMapping("/selectByPrimaryKey.do")
	public JsonResult selectByPrimaryKey(Integer fpid){
		Foodproblem foodproblem = foodproblemService.selectByPrimaryKey(fpid);
		return new JsonResult(foodproblem);
	}
	@ResponseBody
	@RequestMapping("/selectAll.do")
	public JsonResult selectAll(){
		List<Map<String, Object>> list = foodproblemService.selectAll();
		return new JsonResult(list);
	}
}
