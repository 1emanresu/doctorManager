package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.HighriskProblem;

public interface HighriskProblemMapper {
    int deleteByPrimaryKey(Integer highriskproblemid);

    int insert(HighriskProblem record);

    int insertSelective(HighriskProblem record);

    HighriskProblem selectByPrimaryKey(Integer highriskproblemid);

    int updateByPrimaryKeySelective(HighriskProblem record);

    int updateByPrimaryKey(HighriskProblem record);

	List<HighriskProblem> find();
}