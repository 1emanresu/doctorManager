/**@Title:FoodrecordController.java
 * @description
 * @author king_smm
 * @date 2017年12月1日下午2:46:57
 * @copyright(c) 2017 云济健康管理(深圳)有限公司 AllRight Reserved.
 */
package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Foodrecord;
import cn.yunji.doctormanager.service.FoodrecordService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/foodrecord")
public class FoodrecordController {

	@Resource
	private FoodrecordService foodrecordService;
	
	@ResponseBody
	@RequestMapping("/insertSelective.do")
	public JsonResult insertSelective(Foodrecord foodrecord){
		int n = foodrecordService.insertSelective(foodrecord);
		return new JsonResult(n);
	}
}
