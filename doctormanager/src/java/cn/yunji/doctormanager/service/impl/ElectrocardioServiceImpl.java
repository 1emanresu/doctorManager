package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.ElectrocardioMapper;
import cn.yunji.doctormanager.entity.Electrocardio;
import cn.yunji.doctormanager.service.ElectrocardioService;
@Service("electrocardioService")
public class ElectrocardioServiceImpl implements ElectrocardioService {
	@Resource
	private ElectrocardioMapper electrocardioMapper;

	@Override
	public Electrocardio queryByMid(String mid, Date checkDate) {
		return electrocardioMapper.queryByMid(mid,checkDate);
	}

	@Override
	public int addEcg(Electrocardio e) {
		// TODO Auto-generated method stub
		return electrocardioMapper.insert(e);
	}

	@Override
	public List<Map<String, Object>> queryElectrocardioTip(Integer weeks) {
		return electrocardioMapper.queryElectrocardioTip(weeks);
	}

	@Override
	public Electrocardio findByMid(String mid, Date checkDate) {
		return electrocardioMapper.queryByMid(mid, checkDate);
	}

	@Override
	public Electrocardio findByMidAndWeeks(Integer weeks, Integer checkProjectId, String mId) {
		// TODO Auto-generated method stub
		return electrocardioMapper.findByMidAndWeeks(weeks, checkProjectId, mId);
	}

	@Override
	public List<Electrocardio> findByMidAndProject(Integer checkProjectId, String mId) {
		// TODO Auto-generated method stub
		return electrocardioMapper.findByMidAndProject(checkProjectId, mId);
	}	
}
