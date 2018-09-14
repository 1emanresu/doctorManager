package cn.yunji.doctormanager.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.yunji.doctormanager.service.SubscribeService;
import cn.yunji.doctormanager.util.JsonResult;
/**
 * 
 * @author Wangzw
 * 预约
 */
@Controller
@RequestMapping("/subscribe")
public class SubscribeControl {
	@Resource
	private SubscribeService service;
	/**
	 * @author Wangzw
	 * @return 1
	 * 预约数量
	 */
	@ResponseBody
	@RequestMapping("/queryCount.do")
	public JsonResult queryCount(){
	    int ret=service.queryCount();
		return new JsonResult(ret);
	}
	/**
	 * 产检预约
	 * @author Wangzw
	 * @param did
	 * @return 1
	 */
	@ResponseBody
	@RequestMapping("/queryBySubid.do")
	public JsonResult queryBySubid(int did){
	  List<Map<String, Object>>  ret=service.queryBySubId(did);
		return new JsonResult(ret); 
	}
} 
