package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.Bloodpressure;

public interface BloodpressureService {
    List<Bloodpressure> find(String id);
    /**
     * 根据日期范围查询指定孕妇血压数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Bloodpressure> findByDateRange(String mid,Date begin,Date end);
}
