package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.CommentReply;
import cn.yunji.doctormanager.service.CommentReplyService;
import cn.yunji.doctormanager.util.JsonResult;

//异常信息
@Controller
@RequestMapping("/commentReply")
public class CommentReplyController {
	@Resource
	private CommentReplyService commentReplyService;

	@RequestMapping("/insert.do")
	@ResponseBody
	public int insert(CommentReply commentReply) {
		return commentReplyService.insert(commentReply);
	}
	
	@RequestMapping("/queryByPid.do")
	@ResponseBody
	public JsonResult queryByPid(int pid) {
		return new JsonResult(commentReplyService.queryByPid(pid));
	}
}
