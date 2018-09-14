package cn.yunji.doctormanager.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.FansService;
import cn.yunji.doctormanager.util.JsonResult;
/**
 * @author wangzw
 *  粉丝
 */
@Controller
@RequestMapping("/fans")
public class FansController {
	  @Resource
	  public FansService fansService;
	  /**
	   * @author wangzw
	   * @param did
	   * @return 粉丝信息
	   */
	    @ResponseBody
		@RequestMapping("/findByFansdid.do") 
		public JsonResult findByFansdid(int did){
			 List<Map<String, Object>> fans =fansService.selectByFins(did); 
			return new JsonResult(fans);
		}
}
