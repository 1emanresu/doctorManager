package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.PositionService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 职位控制器
 * @author zhangqt
 * @CreateDate 2017年10月31日 下午3:20:57
 */
@Controller
@RequestMapping("/position")
public class PositionController {
	@Resource
	private PositionService positionService;
	/**
	 *查询所有的职位
	 * @return list
	 * @author zhangqt
	 * @createDate 2017年10月31日 下午3:23:21
	 */
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult find(){
		return new JsonResult(positionService.find());
	}
}
