package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.BloodpressureMapper;
import cn.yunji.doctormanager.entity.Bloodpressure;
import cn.yunji.doctormanager.service.BloodpressureService;


@Service("bloodpressureService")
public class BloodpressureServiceImpl implements BloodpressureService {
	@Resource
	private BloodpressureMapper dao;

	public List<Bloodpressure> find(String id) {
		return dao.find(id);
	}

	@Override
	public List<Bloodpressure> findByDateRange(String mid, Date begin, Date end) {
		return dao.findByDateRange(mid, begin, end);
	}
}
