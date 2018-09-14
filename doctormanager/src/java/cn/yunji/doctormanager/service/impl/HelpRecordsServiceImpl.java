package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.HelpRecordsMapper;
import cn.yunji.doctormanager.entity.HelpRecords;
import cn.yunji.doctormanager.service.HelpRecordsService;
@Service("helpRecordsService")
public class HelpRecordsServiceImpl implements HelpRecordsService {
	@Resource
	private HelpRecordsMapper helpRecordsDao;
	@Override
	public int insert(HelpRecords HelpRecords) {
		return helpRecordsDao.insert(HelpRecords);
	}
	@Override
	public List<HelpRecords> queryById(String senderid, String receiverid) {
		// TODO Auto-generated method stub
		return helpRecordsDao.queryById(senderid,receiverid);
	}
	
	
	@Override
	public List<HelpRecords> queryByStatu(String senderid, String receiverid) {
		// TODO Auto-generated method stub
		return helpRecordsDao.queryByStatu(senderid,receiverid);
	}
	@Override
	public int updateStatu(String senderid, String receiverid) {
		// TODO Auto-generated method stub
		return helpRecordsDao.updateStatu(senderid,receiverid);
	}

}
