package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.FolicAcid;

public interface FolicAcidMapper {
    int deleteByPrimaryKey(Integer faid);

    int insert(FolicAcid record);

    int insertSelective(FolicAcid record);

    FolicAcid selectByPrimaryKey(Integer faid);

    int updateByPrimaryKeySelective(FolicAcid record);

    int updateByPrimaryKey(FolicAcid record);

	FolicAcid findByMid(String mid);

	int updateByMid(FolicAcid folicAcid);

	List<FolicAcid> queryByMid(String mid);
}