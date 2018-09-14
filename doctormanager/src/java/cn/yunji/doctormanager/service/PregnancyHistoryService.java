package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.PregnancyHistory;

public interface PregnancyHistoryService {

	PregnancyHistory queryByMid(String Mid);
	
	int update(PregnancyHistory PregnancyHistory);

	int updateByMid(PregnancyHistory pregnancyHistory);

	int addPregnancyHistory(PregnancyHistory pregnancyHistory);
	/**
	 * @author wangzw
	 * @param mid 查询既往史
	 * @return PregnancyHistory
	 */
	List<PregnancyHistory> selectHistoryGradeInfo(String mid);
}
