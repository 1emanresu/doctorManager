package cn.yunji.doctormanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.util.SendSMS;

@Controller
@RequestMapping("/SMSverification")
public class SMSverification {
	/**
	 * 用户开通服务后的信息提醒
	 * @author zhongjl
	 * @param phoneNumber 联系电话
	 * @param state 服务类型的状态码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/opening.do")
	public String serviceOpening(String phoneNumber,String state){
		String code = null;
//		System.out.println(Integer.parseInt(state)==100);
		if(Integer.parseInt(state) == 100){//state是服务类型的状态码
			code = "您已成功开通健康管理微报告服务";
		}else if(Integer.parseInt(state) == 101){
			code = "您已成功开通医嘱远程问诊服务";
		}
		String strs=SendSMS.sendNoticeSms(phoneNumber, "服务提醒", code);
		return SendSMS.getStatusVal(strs);//状态码，"0"为成功
	}
	
}
