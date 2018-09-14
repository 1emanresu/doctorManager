package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.MyEcgMapper;

import cn.yunji.doctormanager.entity.MyEcg;
import cn.yunji.doctormanager.service.MyEcgService;


@Service("myEcgService") 
public class MyEcgServiceImpl implements MyEcgService {
	@Resource
	private MyEcgMapper dao;

	public List<MyEcg> find(String id) {
		return dao.find(id);
	}

	@Override
	public List<MyEcg> findByDateRange(String mid, Date begin, Date end) {
		return dao.findByDateRange(mid, begin, end);
	}
}
