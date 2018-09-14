package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.NiptMapper;
import cn.yunji.doctormanager.entity.Nipt;
import cn.yunji.doctormanager.service.NiptService;

@Service("niptService")
public class NiptServiceImpl implements NiptService {
	@Resource
	private NiptMapper dao;
	@Override
	public Nipt queryBymid(String mid) {
		// TODO Auto-generated method stub
		return dao.selectByMid(mid);
	}
	@Override
	public List<Map<String, Object>> queryByDate(String mid) {
		// TODO Auto-generated method stub
		return dao.queryByDate(mid);
	}
	@Override
	public List<Map<String, Object>> queryByNewDate(String mid) {
		// TODO Auto-generated method stub
		return dao.queryByNewDate(mid);
	}
	@Override
	public Nipt findByMid(String mid, Date checkDate) {
		return dao.queryByMid(mid, checkDate);
	}
	@Override
	public List<Nipt> findByMidAndProject(Integer checkProjectId, String mId) {
		// TODO Auto-generated method stub
		return dao.findByMidAndProject(checkProjectId,mId);
	}
	@Override
	public List<Nipt> findByMidAndWeek(Integer checkProjectId, String mId, Integer weeks) {
		// TODO Auto-generated method stub
		return dao.findByMidAndWeek(checkProjectId,mId,weeks);
	}
	
}
