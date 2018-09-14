package cn.yunji.doctormanager.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.MyIntegralService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 
 * @author wangzw
 * 我的积分信息
 */
@Controller
@RequestMapping("/myIntegral")
public class MyIntegralController {
	@Resource
	MyIntegralService myIntegralService;
	/**
	 * @author wangzw
	 * @param did
	 * @return 所有积分内容
	 */
	@ResponseBody
	@RequestMapping("/queryMyIntegral.do") 
	public JsonResult queryMyIntegral(int did){
    List<Map<String, Object>> myIntegral =myIntegralService.queryMyIntegral(did); 
	return new JsonResult(myIntegral);
  }
	/**
	 * @author wangzw 
	 * @param did 医生编号
	 * @return 统计积分
	 */
	@ResponseBody
	@RequestMapping("/countIntegral.do") 
	public JsonResult countIntegral(int did) {
	 int ret=myIntegralService.countIntegral(did);
		return new JsonResult(ret);
	}
	 /**
	 * @author wangzw 
	 * @param did 医生编号
	 * @return 统计兑换积分
	 */
	@ResponseBody
	@RequestMapping("/countConversionIntegral.do") 
	public JsonResult countConversionIntegral(int did) {
		 int ret=myIntegralService.countConversionIntegral(did);
		 return new JsonResult(ret);
	} 
}
