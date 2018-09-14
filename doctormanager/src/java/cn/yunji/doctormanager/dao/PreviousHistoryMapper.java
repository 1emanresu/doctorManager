package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.PreviousHistory;

public interface PreviousHistoryMapper {
    int deleteByPrimaryKey(Integer previousid);

    int insert(PreviousHistory record);

    int insertSelective(PreviousHistory record);

    PreviousHistory selectByPrimaryKey(Integer previousid);

    int updateByPrimaryKeySelective(PreviousHistory record);

    int updateByPrimaryKey(PreviousHistory record);
    
    PreviousHistory findByMid(String mid);
}