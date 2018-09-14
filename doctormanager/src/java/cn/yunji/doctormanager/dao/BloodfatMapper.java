package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.Bloodoxygen;

public interface BloodfatMapper {
    List<Bloodfat> find(String id); 
    /**
     * 根据日期范围查询指定孕妇血脂数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Bloodfat> findByDateRange(String mid,Date begin,Date end);
}