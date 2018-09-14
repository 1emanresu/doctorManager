package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.TangScreenMapper;
import cn.yunji.doctormanager.entity.TangScreen;
import cn.yunji.doctormanager.service.TangScreenService;

@Service("tangScreenService")
public class TangScreenServiceImpl implements TangScreenService{

	@Resource
	private TangScreenMapper dao;

	public TangScreen findByMid(String Mid, Date checkDate) {
		// TODO Auto-generated method stub
		return dao.findByMid(Mid, checkDate);
	}

	public int addTangScreen(TangScreen TangScreen) {
		// TODO Auto-generated method stub
		return dao.insertSelective(TangScreen);
	}

	public int update(TangScreen TangScreen) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(TangScreen);
	}

	public void updateByMid(TangScreen TangScreen) {
		// TODO Auto-generated method stub
		dao.updateByMid(TangScreen);
	}

	@Override
	public List<TangScreen> findByMidAndProject(Integer checkProjectId, String mId) {
		// TODO Auto-generated method stub
		return dao.findByMidAndProject(checkProjectId, mId);
	}

	@Override
	public List<TangScreen> findByMidAndWeek(Integer checkProjectId, String mId, Integer weeks) {
		// TODO Auto-generated method stub
		return dao.findByMidAndWeek(checkProjectId,mId,weeks);
	}


	
}
