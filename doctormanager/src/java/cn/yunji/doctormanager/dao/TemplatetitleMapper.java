package cn.yunji.doctormanager.dao;


import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Templatetitle;

public interface TemplatetitleMapper {
    int deleteByPrimaryKey(Integer ttid);

	int insert(Templatetitle record);

	int insertSelective(Templatetitle record);

	Templatetitle selectByPrimaryKey(Integer ttid);

	int updateByPrimaryKeySelective(Templatetitle record);

	int updateByPrimaryKey(Templatetitle record);

	/**
     * 根据 孕周、检查项目、孕妇id查询明细信息
     * @param 孕周 weeks
     * @param 检查项目 checkProjectId
     * @param 孕妇mId
     * @return
     */
	Templatetitle queryCheckDetail(@Param("weeks") Integer weeks, @Param("checkProjectId") Integer checkProjectId, @Param("mId") String mId);
    /**
     * 根据 检查时间、检查项目、孕妇id查询明细信息
     * @param checkdate
     * @param checkProjectId
     * @param mId
     * @return
     */
	Templatetitle queryCheckDetailByDate(@Param("checkdate")Date checkdate, @Param("checkProjectId") Integer checkProjectId, @Param("mId") String mId);
	
}