package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.CommentReply;

public interface CommentReplyMapper {
    int deleteByPrimaryKey(Integer crid);

    int insert(CommentReply record);

    int insertSelective(CommentReply record);

    CommentReply selectByPrimaryKey(Integer crid);

    int updateByPrimaryKeySelective(CommentReply record);

    int updateByPrimaryKey(CommentReply record);

	List<CommentReply> queryByPid(int pid);
}