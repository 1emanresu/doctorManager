package cn.yunji.doctormanager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Antenatalcaretime;
import cn.yunji.doctormanager.service.AntenatalcaretimeService;
import cn.yunji.doctormanager.util.JsonResult;
@Controller
@RequestMapping("/antenatalcaretime")
public class AntenatalcaretimeController {
	@Resource
	private AntenatalcaretimeService antenatalcaretimeService;
	/**
	 * 通用产检信息
	 * @author wangzw
	 * @param mid 孕妇ID		
	 * @return
	 */
	@RequestMapping("/queryAntenatalcaretime.do")
	@ResponseBody
	public JsonResult queryAntenatalcaretime(String mid)  {
		List<Antenatalcaretime> list=antenatalcaretimeService.queryAntenatalcaretime(mid);
		return new JsonResult(list);
	}
}
