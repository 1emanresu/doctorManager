package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import cn.yunji.doctormanager.entity.WeightTest;

public interface WeightTestService {
	/**
     * 根据日期范围查询指定孕妇体重的数据
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<WeightTest> findByDateRange(String mid,Date begin,Date end);
    
    //查询孕妇基本信息
    public WeightTest selectByPrimaryKey(Integer wid);
    public WeightTest updateByPrimaryKey(Integer wid);
    List<WeightTest> selectByMid(String mid);
}
