package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Reminder;

public interface ReminderMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Reminder record);

    int insertSelective(Reminder record);
    /**
     * 用于发送提醒模块，用acceptedpeople=1区分，根据mid查询
     * @param mid
     * @return
     */
    List<Reminder> selectReminder();
    /**
     * 根据提醒名称和mid删除
     * zhongjl
     * @param remindname
     * @param mid
     * @return
     */
    int deleteByName(String remindname);
    /**
     * 根据提醒名称更新
     * zhongjl
     * @param record
     * @return
     */
    int updateByName(Reminder record);

    Reminder selectByDaid(Integer daid);

    int updateByPrimaryKeySelective(Reminder record);

    int updateByPrimaryKey(Reminder record);
    /**
     * 根据日期范围查询指定孕妇提醒信息 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Reminder> findByDateRange(String mid,Date begin,Date end);
    /**
     * 查询指定孕妇的最近一次自测提醒信息 
     * @param mid
     * @return
     * @author luoyc
     * @createDate 2017年10月27日 上午10:16:38
     */
    Reminder findByMid(String mid);
    /**
     * 根据提醒名称查询
     * @param name
     * @return
     */
    Reminder selectByName(String name);
    /**
     * 只根据mid查询
     * @param mid
     * @return
     */
    List<Reminder> selectByMid(String mid);
}