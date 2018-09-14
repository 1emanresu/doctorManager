package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.OrderDetailsService;

/**
 * vip套餐明细
 * @author zhangqt
 * @CreateDate 2017年11月17日 上午10:00:41
 */
@Controller
@RequestMapping("/orderDetails")
public class OrderDetailsController {
	@Resource
	private OrderDetailsService orderDetailsService;
	/*
	 * 修改处理状态
	 * @author  zhangqt
	 */
	@RequestMapping("/updateState.do")
	@ResponseBody
	public int updateState(Integer odid){
		orderDetailsService.updateState(odid);
		return 1;
	}
}
