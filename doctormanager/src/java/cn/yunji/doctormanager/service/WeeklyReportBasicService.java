package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.WeeklyReportBasic;

public interface WeeklyReportBasicService {
    /**
     * 根据孕周查询相应数据
     * @author luoyc
     * @param week
     * @return
     */
    WeeklyReportBasic findByWeek(Integer week);
}
