package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.WeeklyReportBasic;

public interface WeeklyReportBasicMapper {
    int deleteByPrimaryKey(Integer wid);

    int insert(WeeklyReportBasic record);

    int insertSelective(WeeklyReportBasic record);

    WeeklyReportBasic selectByPrimaryKey(Integer wid);

    int updateByPrimaryKeySelective(WeeklyReportBasic record);

    int updateByPrimaryKey(WeeklyReportBasic record);
    /**
     * 根据孕周查询相应数据
     * @author luoyc
     * @param week
     * @return
     */
    WeeklyReportBasic findByWeek(Integer week);
}