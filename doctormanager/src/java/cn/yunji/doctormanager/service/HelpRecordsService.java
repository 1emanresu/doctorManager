package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.HelpRecords;

public interface HelpRecordsService {
	public int insert(HelpRecords HelpRecords);

	public List<HelpRecords> queryById(String senderid, String receiverid);

	public List<HelpRecords> queryByStatu(String senderid, String receiverid);

	public int updateStatu(String senderid, String receiverid);
}
