package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Office;

public interface OfficeMapper {
    int deleteByPrimaryKey(Integer officeid);

    int insert(Office record);

    int insertSelective(Office record);

    Office selectByPrimaryKey(Integer officeid);

    int updateByPrimaryKeySelective(Office record);

    int updateByPrimaryKey(Office record);

	List<Office> findOffice();
}