package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.WeeklyNursing;

public interface WeeklyNursingService {
    /**
     * 根据孕周查询相应数据
     * @author luoyc
     * @param week
     * @return
     */
    WeeklyNursing findByWeek(Integer week);
}
