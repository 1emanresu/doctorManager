package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.yunji.doctormanager.entity.FetalHeartData;

public interface FetalHeartDataMapper {
    int deleteByPrimaryKey(Integer fdid);

    int insert(FetalHeartData record);

    int insertSelective(FetalHeartData record);

    FetalHeartData selectByPrimaryKey(Integer fdid);

    int updateByPrimaryKeySelective(FetalHeartData record);

    int updateByPrimaryKey(FetalHeartData record);

	List<FetalHeartData> findByMid(String mid);
	
	List<Map<String, Object>> findAll();

    List<FetalHeartData> findSmallByMid(String mid);
    
    List<FetalHeartData> findLargeByMid(String mid);
    /**
     * 根据日期范围查询指定孕妇胎心数据
     * @param mid
     * @param begin
     * @param end
     * @return
     * @author luoyc
     * @createDate 2017年11月11日 上午11:45:03
     */
    List<FetalHeartData> findByDateRange(String mid,Date begin,Date end);
}