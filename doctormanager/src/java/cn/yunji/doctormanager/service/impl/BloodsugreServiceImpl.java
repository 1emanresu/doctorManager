package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.BloodsugreMapper;
import cn.yunji.doctormanager.entity.Bloodsugre;
import cn.yunji.doctormanager.service.BloodsugreService;


@Service("bloodsugreService")
public class BloodsugreServiceImpl implements BloodsugreService {
	@Resource
	private BloodsugreMapper dao;

	public List<Bloodsugre> find(String id) {
		return dao.find(id);
	}

	@Override
	public List<Bloodsugre> findByDateRange(String mid, Date begin, Date end) {
		return dao.findByDateRange(mid, begin, end);
	}
}
