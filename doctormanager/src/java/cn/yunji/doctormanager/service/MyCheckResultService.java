package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.MyCheckResult;

public interface MyCheckResultService {
	/**
	 * @author wuwj
	 * @param mid 孕妇编号
	 * @param bweeks 孕程起始孕周
	 * @param eweeks 孕程结束孕周
	 * @return MycheckResult
	 * 根据一段孕程中做过的自测项目
	 */
	List<Map<String, Object>> findmycheckedByweeks(String mid, int bweeks, int eweeks);

}
