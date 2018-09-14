package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.CommentReplyMapper;
import cn.yunji.doctormanager.entity.CommentReply;
import cn.yunji.doctormanager.service.CommentReplyService;
@Service("commentReplyService")
public class CommentReplyServiceImpl implements CommentReplyService {
	@Resource
	private CommentReplyMapper commentReplyDao;
	@Override
	public int insert(CommentReply commentReply) {
		return commentReplyDao.insert(commentReply);
	}

	@Override
	public List<CommentReply> queryByPid(int pid) {
		return commentReplyDao.queryByPid(pid);
	}

}
