package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.BloodfatMapper;
import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.service.BloodfatService;


@Service("bloodfatService")
public class BloodfatServiceImpl implements BloodfatService {
	@Resource
	private BloodfatMapper dao;

	public List<Bloodfat> find(String id) {
		return dao.find(id);
	}

	@Override
	public List<Bloodfat> findByDateRange(String mid, Date begin, Date end) {
		return dao.findByDateRange(mid, begin, end);
	}

}
