package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.PregnancyHistoryMapper;
import cn.yunji.doctormanager.entity.PregnancyHistory;
import cn.yunji.doctormanager.service.PregnancyHistoryService;
@Service("pregnancyHistoryService")
public class PregnancyHistoryServiceImpl implements PregnancyHistoryService{
 
	@Resource
	private PregnancyHistoryMapper dao;
	public PregnancyHistory queryByMid(String Mid) {
		// TODO Auto-generated method stub
		return dao.queryByMid(Mid);
	}

	public int update(PregnancyHistory PregnancyHistory) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(PregnancyHistory);
	}

	public int updateByMid(PregnancyHistory pregnancyHistory) {
		// TODO Auto-generated method stub
		return dao.updateByMid(pregnancyHistory);
	}

	public int addPregnancyHistory(PregnancyHistory pregnancyHistory) {
		// TODO Auto-generated method stub
		return dao.insertSelective(pregnancyHistory);
	}

	@Override
	public List<PregnancyHistory> selectHistoryGradeInfo(String mid) {
		return dao.selectHistoryGradeInfo(mid);
	}

}
