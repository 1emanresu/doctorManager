package cn.yunji.doctormanager.service.impl;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.HospitalMapper;
import cn.yunji.doctormanager.entity.Hospital;
import cn.yunji.doctormanager.service.HospitalService;


@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
	@Resource
	private HospitalMapper hospitalDao;

	@Override
	public String findByName(String hospitalName) {
		return hospitalDao.findByName(hospitalName);
	}

	@Override
	public List<Hospital> find() {
		// TODO Auto-generated method stub
		return hospitalDao.find();
	}

	
	@Override
	public Hospital selectByPrimaryKey(String hospitalid) {
		return hospitalDao.selectByPrimaryKey(hospitalid);
	}



}
