package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.HighriskTest;

public interface HighriskTestMapper {
    int deleteByPrimaryKey(Integer highrisktestid);

    int insert(HighriskTest record);

    int insertSelective(HighriskTest record);

    HighriskTest selectByPrimaryKey(Integer highrisktestid);

    int updateByPrimaryKeySelective(HighriskTest record);

    int updateByPrimaryKey(HighriskTest record);

	List<Map<String, Object>> findByMid(String mid);

	int insertLoop(List<HighriskTest> highriskTest);
	
	List<Map<String, Object>> findByMidandweeks(@Param("mid")String mid,@Param("begintime")String begintime,@Param("endtime")String endtime);
}