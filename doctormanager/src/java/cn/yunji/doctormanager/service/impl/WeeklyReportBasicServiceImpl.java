package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.WeeklyReportBasicMapper;
import cn.yunji.doctormanager.entity.WeeklyReportBasic;
import cn.yunji.doctormanager.service.WeeklyReportBasicService;


@Service("weeklyReportBasicService")
public class WeeklyReportBasicServiceImpl implements WeeklyReportBasicService {
	@Resource
	private WeeklyReportBasicMapper weeklyReportBasicDao;

    @Override
    public WeeklyReportBasic findByWeek(Integer week) {
        
        return weeklyReportBasicDao.findByWeek(week);
    }

}
