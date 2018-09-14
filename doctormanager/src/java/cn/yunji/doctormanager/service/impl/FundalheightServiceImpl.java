package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.FundalheightMapper;
import cn.yunji.doctormanager.entity.Fundalheight;
import cn.yunji.doctormanager.service.FundalheightService;
@Service("fundalheight")
public class FundalheightServiceImpl implements FundalheightService {
	@Resource
	private FundalheightMapper fundalheightDao;

	@Override
	public List<Fundalheight> findByMid(String mid) {	
		return fundalheightDao.findByMid(mid);
	}

	@Override
	public List<Fundalheight> findByDateRange(String mid, Date begin, Date end) {
		return fundalheightDao.findByDateRange(mid, begin, end);
	}
	
}
