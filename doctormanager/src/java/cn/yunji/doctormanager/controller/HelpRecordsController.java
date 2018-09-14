package cn.yunji.doctormanager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.HelpRecords;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.HelpRecordsService;
import cn.yunji.doctormanager.service.RemoteReservationService;
import cn.yunji.doctormanager.service.impl.GravidaInfoServiceImpl;
import cn.yunji.doctormanager.service.impl.HelpRecordsServiceImpl;
import cn.yunji.doctormanager.service.impl.RemoteReservationServiceImpl;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/helpRecord")
public class HelpRecordsController {
	@Resource
	private HelpRecordsService helpRecordsService;

	@Resource
	private RemoteReservationService remoteReservationService;

	// 将信息录入数据库
	@RequestMapping("/insert.do")
	@ResponseBody
	public void insert(HelpRecords helpRecords) {
		helpRecordsService.insert(helpRecords);
	}

	@RequestMapping("/queryById.do")
	@ResponseBody
	public JsonResult queryById(String senderid, String receiverid) {
		return new JsonResult(helpRecordsService.queryById(senderid, receiverid));
	}

	// 查询本人未读状态的信息的信息
	@RequestMapping("/queryByStatu.do")
	@ResponseBody
	public JsonResult queryByStatu(String senderid, String receiverid) {
		return new JsonResult(helpRecordsService.queryByStatu(senderid, receiverid));
	}

	// 改变为已读状态
	@RequestMapping("/updateStatu.do")
	@ResponseBody
	public int updateStatu(String senderid, String receiverid) {
		return helpRecordsService.updateStatu(senderid, receiverid);
	}

	// 改变上线状态
	@RequestMapping("/changeState.do")
	@ResponseBody
	public int changeState(int state, String username) {
		System.err.println(state);
		System.err.println(username);
		int i=remoteReservationService.changeState(state, username);
		return i;
	}
}
