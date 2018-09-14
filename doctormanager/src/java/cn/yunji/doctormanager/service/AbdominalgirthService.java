package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.Abdominalgirth;

public interface AbdominalgirthService {
	/**
     * 根据孕妇Id查询所有的腹围自测数据
     * @author luoyc
     * @param mid
     * @return
     */
    List<Abdominalgirth> findByMid(String mid);
    /**
     * 根据日期范围查询指定孕妇腹围数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Abdominalgirth> findByDateRange(String mid,Date begin,Date end);
}
