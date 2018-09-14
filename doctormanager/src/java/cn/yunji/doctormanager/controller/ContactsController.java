package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.ContactsService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
	@Resource
	private ContactsService contactsService;
	@RequestMapping("/queryByMid.do")
	@ResponseBody
	public JsonResult queryByMid(String mid){
		return new JsonResult(contactsService.queryByMid(mid));
	}

}
