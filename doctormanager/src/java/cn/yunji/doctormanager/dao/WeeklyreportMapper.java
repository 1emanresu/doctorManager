package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Weeklyreport;

public interface WeeklyreportMapper {
    int deleteByPrimaryKey(Integer wid); 
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
    /**
     * 查询指定孕妇所有的周报记录
     * @author zhangqt
     * @param mid
     * @param pageSize 
     * @param pageIndex 
     * @param keyword 
     * @return
     */
    List<Weeklyreport> findByMid(@Param("mid")String mid,@Param("keyword") String keyword,@Param("sdate") String sdate,@Param("edate") String edate,@Param("pageIndex") Integer pageIndex,@Param("pageSize")Integer pageSize);
    int insert(Weeklyreport record);

    int insertSelective(Weeklyreport record);

    Weeklyreport selectByPrimaryKey(Integer wid);

    int updateByPrimaryKeySelective(Weeklyreport record);

    int updateByPrimaryKey(Weeklyreport record);
}