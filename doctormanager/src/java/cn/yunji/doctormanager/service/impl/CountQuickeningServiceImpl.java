package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.CountQuickeningMapper;
import cn.yunji.doctormanager.entity.CountQuickening;
import cn.yunji.doctormanager.service.CountQuickeningService;


@Service("countQuickeningService")
public class CountQuickeningServiceImpl implements CountQuickeningService {
	@Resource
	private CountQuickeningMapper dao;

	public List<CountQuickening> find(String id) {
		return dao.find(id);
	}

	@Override
	public List<CountQuickening> findByDateRange(String mid, Date begin, Date end) {
		return dao.findByDateRange(mid, begin, end);
	}
}
