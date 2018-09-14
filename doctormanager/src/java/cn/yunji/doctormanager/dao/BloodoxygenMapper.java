package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.Bloodoxygen;
import cn.yunji.doctormanager.entity.Bloodsugre;

public interface BloodoxygenMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Bloodoxygen record);

    int insertSelective(Bloodoxygen record);
    /**
     * 根据孕妇Id查询所有的血氧自测数据
     * @author luoyc
     * @param mid
     * @return
     */
    List<Bloodoxygen> findByMid(String mid);

    int updateByPrimaryKeySelective(Bloodoxygen record);

    int updateByPrimaryKey(Bloodoxygen record);
    
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