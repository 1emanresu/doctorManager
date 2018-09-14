package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.TemperatureMapper;
import cn.yunji.doctormanager.entity.Temperature;
import cn.yunji.doctormanager.service.TemperatureService;


@Service("temperatureService")
public class TemperatureServiceImpl implements TemperatureService {
	@Resource
	private TemperatureMapper dao;

	public List<Temperature> find(String id) {
		return dao.find(id);
	}

	@Override
	public List<Temperature> findByDateRange(String mid, Date begin, Date end) {
		
		return dao.findByDateRange(mid, begin, end);
	}
}
