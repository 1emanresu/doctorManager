package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FolicAcidMapper;
import cn.yunji.doctormanager.entity.FolicAcid;
import cn.yunji.doctormanager.service.FolicAcidService;

@Service("folicAcidService")
public class FolicAcidServiceImpl implements FolicAcidService{

	@Resource
	private FolicAcidMapper dao;

	public FolicAcid findByMid(String Mid) {
		// TODO Auto-generated method stub
		return dao.findByMid(Mid);
	}

	public int addFolicAcid(FolicAcid FolicAcid) {
		// TODO Auto-generated method stub
		return dao.insertSelective(FolicAcid);
	}

	public int update(FolicAcid FolicAcid) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(FolicAcid);
	}
	

	public void updateByMid(FolicAcid folicAcid) {
		// TODO Auto-generated method stub
		dao.updateByMid(folicAcid);
	}

	@Override
	public List<FolicAcid> queryByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.queryByMid(mid);
	}
	
	
}
