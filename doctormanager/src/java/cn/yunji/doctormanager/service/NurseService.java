package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Nurse;
/**
 * 护士
 * @author Wangzw
 *
 */
public interface NurseService {
	/**
	 * 获取护士的基本信息
	 * @author Wangzw
	 * @param nid
	 * @return 护士的基本信息
	 */
	 List<Map<String, Object>> queryByNurseId(int nid);
	 

	 
}
