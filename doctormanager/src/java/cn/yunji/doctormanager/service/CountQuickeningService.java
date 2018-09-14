package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.CountQuickening;

public interface CountQuickeningService {
    List<CountQuickening> find(String id);
    /**
     * 根据日期范围查询指定孕妇胎动数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<CountQuickening> findByDateRange(String mid,Date begin,Date end);
}
