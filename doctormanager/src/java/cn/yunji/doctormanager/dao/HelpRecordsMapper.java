package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.HelpRecords;

public interface HelpRecordsMapper {
    int deleteByPrimaryKey(Integer logid);

    int insert(HelpRecords record);

    int insertSelective(HelpRecords record);

    HelpRecords selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(HelpRecords record);

    int updateByPrimaryKey(HelpRecords record);

	List<HelpRecords> queryById(String senderid, String receiverid);

	List<HelpRecords> queryByStatu(String senderid, String receiverid);

	int updateStatu(String senderid, String receiverid);
}