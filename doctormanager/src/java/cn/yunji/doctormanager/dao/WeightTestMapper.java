package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.WeightTest;

public interface WeightTestMapper {
    List<WeightTest> find(String id);
    /**
     * 根据日期范围查询指定孕妇体重的数据
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<WeightTest> findByDateRange(String mid,Date begin,Date end);
  
    //根据体重编号查体重
    public WeightTest selectByPrimaryKey(Integer wid);
    public WeightTest updateByPrimaryKey(Integer wid);
    List<WeightTest> selectByMid(String mid);
}