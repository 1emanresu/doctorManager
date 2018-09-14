package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import cn.yunji.doctormanager.entity.MyEcg;

public interface MyEcgMapper {
	 List<MyEcg> find(String id);
	 /**
	  * 根据日期范围查询指定孕妇血氧数据 
	  * @author luoyc
	  * @param mid
	  * @param begin
	  * @param end
	  * @return
	  */
	 List<MyEcg> findByDateRange(String mid,Date begin,Date end);
}