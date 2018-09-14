package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import cn.yunji.doctormanager.entity.Bloodoxygen;

public interface BloodoxygenService {
	 /**
     * 根据孕妇Id查询所有的血氧自测数据
     * @author luoyc
     * @param mid
     * @return
     */
    List<Bloodoxygen> findByMid(String mid);
    /**
     * 根据日期范围查询指定孕妇血氧数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Bloodoxygen> findByDateRange(String mid,Date begin,Date end);
}
