package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.SymptomProblem;

public interface SymptomProblemMapper {
    int deleteByPrimaryKey(Integer spid);

    int insert(SymptomProblem record);

    int insertSelective(SymptomProblem record);

    SymptomProblem selectByPrimaryKey(Integer spid);

    int updateByPrimaryKeySelective(SymptomProblem record);

    int updateByPrimaryKey(SymptomProblem record);
}