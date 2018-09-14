package cn.yunji.doctormanager.dao;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;

import cn.yunji.doctormanager.entity.Amniocentesis;

public interface AmniocentesisMapper {
    int deleteByPrimaryKey(Integer amid);

    int insert(Amniocentesis record);

    int insertSelective(Amniocentesis record);

    Amniocentesis selectByPrimaryKey(Integer amid);

    int updateByPrimaryKeySelective(Amniocentesis record);

    int updateByPrimaryKey(Amniocentesis record);
	
	Amniocentesis findByMid(@Param("mid") String mid,@Param("checkDate") String checkDate);

	void updateByMid(Amniocentesis amniocentesis);
}