package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import cn.yunji.doctormanager.entity.Temperature;

public interface TemperatureService {
    List<Temperature> find(String id);
    /**
     * 根据日期范围查询指定孕妇体重的数据
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Temperature> findByDateRange(String mid,Date begin,Date end);
}
