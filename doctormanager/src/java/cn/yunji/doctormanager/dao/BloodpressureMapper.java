package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import cn.yunji.doctormanager.entity.Bloodpressure;

public interface BloodpressureMapper {
    List<Bloodpressure> find(String mid);
    /**
     * 根据日期范围查询指定孕妇血压数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Bloodpressure> findByDateRange(String mid,Date begin,Date end);
    /**
     *  根据mid查询指定孕妇最新的血压数据
     *  @author yinzx
     * @param mid
     * @return
     */
    Bloodpressure findNewPressure(String mid);
}