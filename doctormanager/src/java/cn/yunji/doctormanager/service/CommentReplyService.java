package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.CommentReply;

public interface CommentReplyService {
	//添加回复
	public int insert(CommentReply commentReply);
	
	//查看回复
	public List<CommentReply> queryByPid(int pid);
	
}
