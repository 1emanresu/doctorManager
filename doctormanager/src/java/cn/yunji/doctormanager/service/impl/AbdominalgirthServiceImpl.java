package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.AbdominalgirthMapper;
import cn.yunji.doctormanager.entity.Abdominalgirth;
import cn.yunji.doctormanager.service.AbdominalgirthService;
@Service("abdominalgirthService")
public class AbdominalgirthServiceImpl implements AbdominalgirthService {
	@Resource
	private AbdominalgirthMapper abdominalgirthDao;

	@Override
	public List<Abdominalgirth> findByMid(String mid) {
		
		return abdominalgirthDao.findByMid(mid);
	}

	@Override
	public List<Abdominalgirth> findByDateRange(String mid, Date begin, Date end) {
		
		return abdominalgirthDao.findByDateRange(mid, begin, end);
	}
	
}
