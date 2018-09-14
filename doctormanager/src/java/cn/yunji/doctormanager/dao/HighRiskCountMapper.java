package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.HighRiskCount;

public interface HighRiskCountMapper {
    int deleteByPrimaryKey(Integer highriskcountid);

    int insert(HighRiskCount record);

    int insertSelective(HighRiskCount record);

    HighRiskCount selectByPrimaryKey(Integer highriskcountid);

    int updateByPrimaryKeySelective(HighRiskCount record);

    int updateByPrimaryKey(HighRiskCount record);
}