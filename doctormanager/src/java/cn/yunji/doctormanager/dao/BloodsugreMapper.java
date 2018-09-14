package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import cn.yunji.doctormanager.entity.Bloodsugre;

public interface BloodsugreMapper {
    List<Bloodsugre> find(String id);
    /**
     * 根据日期范围查询指定孕妇血压数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Bloodsugre> findByDateRange(String mid,Date begin,Date end);
}