package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.WeeklyreportMapper;
import cn.yunji.doctormanager.entity.Weeklyreport;
import cn.yunji.doctormanager.service.WeeklyreportService;


@Service("weeklyreport")
public class WeeklyreportServiceImpl implements WeeklyreportService {
	@Resource
	private WeeklyreportMapper weeklyreportDao;

	@Override
	public List<Weeklyreport> findByDateRange(String mid, Date start, Date end) {
		
		return weeklyreportDao.findByDateRange(mid, start, end);
	}

	@Override
	public List<Weeklyreport> findByDate(Weeklyreport record) {

		return weeklyreportDao.findByDate(record);
	}

	@Override
	public int insert(Weeklyreport record) {

		return weeklyreportDao.insert(record);
	}

	@Override
	public List<Weeklyreport> findByMid(String mid,String keyword,String sdate,String edate, Integer pageIndex,Integer pageSize) {
		return weeklyreportDao.findByMid(mid,keyword,sdate,edate,pageIndex,pageSize);
	}

	
}
