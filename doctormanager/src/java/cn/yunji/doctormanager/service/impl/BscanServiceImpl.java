package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.BscanMapper;
import cn.yunji.doctormanager.entity.Bscan;
import cn.yunji.doctormanager.service.BscanService;

@Service("bscanService")
public class BscanServiceImpl implements BscanService{
	@Resource
	private BscanMapper dao;
	
	@Override
	public Bscan getNewReport(String mid) {
		// TODO Auto-generated method stub
		return dao.selectNewReport(mid);
	}

	@Override
	public Bscan selectByBid(int bid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(bid);
	}

	@Override
	public void insert(Bscan record) {
		// TODO Auto-generated method stub
		dao.insert(record);
	}

	@Override
	public List<Map<String, Object>> queryBscanTip(Integer weeks) {
		return dao.queryBscanTip(weeks);
	}
	
	public Bscan findByMid(String Mid) {
		// TODO Auto-generated method stub
		return dao.findByMid(Mid);
	}

	@Override
	public Bscan selectTipByMidandWeek(String mid, int week) {
		// TODO Auto-generated method stub
		return dao.selectTipByMidandWeek(mid, week);
	}

	@Override
	public Bscan findByMidAndWeeks(Integer weeks, Integer checkProjectId, String mId) {
		// TODO Auto-generated method stub
		return dao.findByMidAndWeeks(weeks, checkProjectId, mId);
	}

	@Override
	public List<Bscan> findByMidAndProject(Integer checkProjectId, String mId) {
		// TODO Auto-generated method stub
		return dao.findByMidAndProject(checkProjectId,mId);
	}
	
}
