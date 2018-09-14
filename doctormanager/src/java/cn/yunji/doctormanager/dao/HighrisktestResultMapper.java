package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.HighrisktestResult;

public interface HighrisktestResultMapper {
    int deleteByPrimaryKey(Integer highrisktestresultid);

    int insert(HighrisktestResult record);

    int insertSelective(HighrisktestResult record);

    HighrisktestResult selectByPrimaryKey(Integer highrisktestresultid);

    int updateByPrimaryKeySelective(HighrisktestResult record);

    int updateByPrimaryKey(HighrisktestResult record);
}