package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.FetalHeartData;



//胎监曲线数据 @yinzx
public interface FetalHeartDataService {
	 /**
     * 添加数据（数组转换成字符串存入数据库）
     * @param record
     * @return
     */
	 int insertSelective(FetalHeartData record);

	 FetalHeartData selectByPrimaryKey(Integer fdid);

	 int updateByPrimaryKeySelective(FetalHeartData record);
    /**
     * 通过Mid查询
     * @param mid
     * @return
     */
	List<FetalHeartData> findByMid(String mid);
   /**
    * 查询所有
    * @return
    */
	List<Map<String, Object>> findAll();
	 /**
     * 通过Mid查询小孕周的数据  
     * @param mid
     * @return 最新一条数据
     */
   FetalHeartData findSmallByMid(String mid);
   /**
    * 通过Mid查询大孕周的数据 
    * @param mid
    * @return  最新一条数据
    */
   FetalHeartData findLargeByMid(String mid);
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
