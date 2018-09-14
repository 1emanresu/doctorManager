package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Antenatal_Item;

public interface Antenatal_ItemService {
	/**
	 * @author wuwj
	 * @param weeks 孕周
	 * @return 返回产检必检项目
	 */
	List<Map<String, Object>> findallcheckprojectbyweeks(int weeks);
	/**
	 * @author wuwj
	 * @param weeks 孕周
	 * @param mid 孕妇编号
	 * @param doctorId 医生编号
	 * @param hospitalId 医院编号
	 * @return 返回检查过的项目
	 */
	List<Map<String, Object>> findcheckedprojectbyweeks(int weeks, String mid, String doctorId, String hospitalId);
	/**
	 * @author wuwj
	 * @param weeks 孕周
	 * @return 返回孕程的开始与结束孕周
	 */
	Antenatal_Item findbeginandendweeks(int weeks);
	List<Map<String, Object>> queryByWeeks(Integer week);
}
