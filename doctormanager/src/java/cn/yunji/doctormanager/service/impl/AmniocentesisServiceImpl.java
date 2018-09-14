package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.AmniocentesisMapper;
import cn.yunji.doctormanager.entity.Amniocentesis;
import cn.yunji.doctormanager.service.AmniocentesisService;

@Service("amniocentesisService")
public class AmniocentesisServiceImpl implements AmniocentesisService{

	@Resource
	private AmniocentesisMapper dao;
	public Amniocentesis findByMid(String mid,String checkDate) {
		// TODO Auto-generated method stub
		return dao.findByMid(mid,checkDate);
	}

	public int addAmniocentesis(Amniocentesis Amniocentesis) {
		// TODO Auto-generated method stub
		return dao.insertSelective(Amniocentesis);
	}

	public int update(Amniocentesis Amniocentesis) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(Amniocentesis);
	}

	public void updateByMid(Amniocentesis Amniocentesis) {
		// TODO Auto-generated method stub
		dao.updateByMid(Amniocentesis);
	}
	

}
