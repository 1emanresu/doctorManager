package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.BloodoxygenMapper;
import cn.yunji.doctormanager.entity.Bloodoxygen;
import cn.yunji.doctormanager.service.BloodoxygenService;
@Service("bloodoxygenService")
public class BloodoxygenServiceImpl implements BloodoxygenService {
	@Resource
	private BloodoxygenMapper bloodoxygenDao;

	@Override
	public List<Bloodoxygen> findByMid(String mid) {
		
		return bloodoxygenDao.findByMid(mid);
	}

	@Override
	public List<Bloodoxygen> findByDateRange(String mid, Date begin, Date end) {
		
		return bloodoxygenDao.findByDateRange(mid, begin, end);
	}
	
}
