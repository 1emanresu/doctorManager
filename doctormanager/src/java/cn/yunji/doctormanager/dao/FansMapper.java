package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

 
/**
 * 粉丝
 * @author  wangzw
 *
 */
public interface FansMapper {
	
	/**
	 * @author wangzw 
	 * @param did
	 * @return 返回我的所有粉丝
	 */
    List<Map<String, Object>>  selectByFins(int did);
}