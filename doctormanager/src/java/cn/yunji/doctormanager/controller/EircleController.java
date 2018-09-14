package cn.yunji.doctormanager.controller;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.yunji.doctormanager.service.EircleService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/eircle")
public class EircleController {
	@Resource
	private  EircleService  eircleService;
	
	
	@RequestMapping("/findAll.do")
	@ResponseBody
	public  JsonResult    findB(Integer userId) {
		List<Map<String, Object>> list=eircleService.findByUserId(userId);
		return  new  JsonResult(list);
		
	}
	//删除帖子
	@RequestMapping("/del.do")
	@ResponseBody
	public   void    delete(Integer userId, Integer eid) {
           eircleService.deleteById(userId, eid);
	}
	//更行标题内容赞等
	@RequestMapping("/update.do")
	@ResponseBody
	public   JsonResult  update(Integer userId, Integer eid,  String praise) {
		 eircleService.update(userId,eid,praise);
		 return new JsonResult("ok");
	}
	//取消赞
	@RequestMapping("/updatepraise.do")
	@ResponseBody
	public   JsonResult   updatePraise1(Integer userId, Integer eid,String praise) {
		 eircleService.updatePraise(userId,eid,praise);
		 return new JsonResult("ok");
	}
	
	//发帖
	@RequestMapping("/insert.do")
	@ResponseBody
	public     JsonResult  insert(Integer userId, String title, String content) {
		 eircleService.insert(userId, title, content);
		 return   new JsonResult("ok");
	}

	

}
