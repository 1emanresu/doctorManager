package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.Reminder;

public interface ReminderService {
	
	int insert(Reminder record);
	
	int insertSelective(Reminder record);
	
	int deleteByName(String remindname);
	
	int updateByName(Reminder record);
	
	Reminder selectByDaid(Integer daid);
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
     * 根据mid查询所有信息
     * @param mid
     * @return
     * @author zhongjl
     */
    List<Reminder> selectReminder();
    
    Reminder selectByName(String name);
    /**
     * 只根据mid查询
     * @param mid
     * @return
     */
    List<Reminder> selectByMid(String mid);
}
