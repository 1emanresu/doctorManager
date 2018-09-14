package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.PregnancyHistory;

public interface PregnancyHistoryMapper {
    int deleteByPrimaryKey(Integer phid);

    int insert(PregnancyHistory record);

    int insertSelective(PregnancyHistory record);

    PregnancyHistory selectByPrimaryKey(Integer phid);

    int updateByPrimaryKeySelective(PregnancyHistory record);

    int updateByPrimaryKey(PregnancyHistory record);

	PregnancyHistory queryByMid(String mid);

	int updateByMid(PregnancyHistory pregnancyHistory);
	/**
	 * @author wangzw
	 * @param mid 查询既往史
	 * @return PregnancyHistory
	 */
	List<PregnancyHistory> selectHistoryGradeInfo(String mid);
}