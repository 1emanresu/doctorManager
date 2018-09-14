package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.HighRiskResultType;

public interface HighRiskResultTypeMapper {
    int deleteByPrimaryKey(Integer highriskresulttypeid);

    int insert(HighRiskResultType record);

    int insertSelective(HighRiskResultType record);

    HighRiskResultType selectByPrimaryKey(Integer highriskresulttypeid);

    int updateByPrimaryKeySelective(HighRiskResultType record);

    int updateByPrimaryKey(HighRiskResultType record);
    
    HighRiskResultType queryByType(int score);

    HighRiskResultType selectByScore(Integer score);

    List< HighRiskResultType> findAll();

    List<HighRiskResultType> queryAll();
}