package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import cn.yunji.doctormanager.entity.InquiryRecord;
import cn.yunji.doctormanager.entity.Weeklyreport;

public interface WeeklyreportService {
	/**
     * 查询指定孕妇在指定日期范围的周报记录
     * @author luoyc
     * @param mid
     * @param start
     * @param end
     * @return
     */
    List<Weeklyreport> findByDateRange(String mid,Date start,Date end);
    /**
     * 查询指定孕妇在指定日期的周报记录
     * @author luoyc
     * @param record
     * @return
     */
    List<Weeklyreport> findByDate(Weeklyreport record);
  
    int insert(Weeklyreport record);
    /**
     * 查询孕妇所有的周报记录
     * @author zhangqt
     * @param mid
     * @param pageSize 
     * @param pageIndex 
     * @param keyword (可选)
     * @return List<Weeklyreport>
     */
    List<Weeklyreport> findByMid(String mid,String keyword,String sdate,String edate, Integer pageIndex,Integer pageSize);
}
