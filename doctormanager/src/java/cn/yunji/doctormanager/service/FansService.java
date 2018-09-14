package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;
/**
 * 操作所有粉丝
 * @author wangzw 
 *  
 */
public interface FansService {
	
	/**
	 * @author wangzw 
	 * @param did
	 * @return 返回我的所有粉丝
	 */
    List<Map<String, Object>>  selectByFins(int did);
}
