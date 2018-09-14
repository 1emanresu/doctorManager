package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.WeeklyNursingMapper;
import cn.yunji.doctormanager.entity.WeeklyNursing;
import cn.yunji.doctormanager.service.WeeklyNursingService;


@Service("weeklyNursingService")
public class WeeklyNursingServiceImpl implements WeeklyNursingService {
	@Resource
	private WeeklyNursingMapper weeklyNursingDao;

    @Override
    public WeeklyNursing findByWeek(Integer week) {

        return weeklyNursingDao.findByWeek(week);
    }


}
