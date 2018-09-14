package cn.yunji.doctormanager.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.ReturnCardService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/Return")
public class ReturnCardController {
	@Resource
	private ReturnCardService returnCardService;
	
	
	@RequestMapping("/findAll.do")
	@ResponseBody
	public JsonResult findById(Integer userId, Integer eId) {
		List<Map<String, Object>> list  =returnCardService.findById(userId, eId);
		return  new  JsonResult(list);
	}

	@RequestMapping("/del.do")
	@ResponseBody
	public void delete(Integer userId, Integer eId) {
		returnCardService.delete(userId, eId);
		
	}
	@RequestMapping("/insert.do")
	@ResponseBody
	public  JsonResult  insertrcontent(Integer userId, Integer eId,String rcontent) {
		returnCardService.insertreturncard(userId, eId, rcontent);
		 return  new JsonResult("ok");
	}
	
	
}
