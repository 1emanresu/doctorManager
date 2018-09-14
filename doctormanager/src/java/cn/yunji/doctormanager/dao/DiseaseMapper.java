package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.Disease;

public interface DiseaseMapper {
    int deleteByPrimaryKey(Integer diseaseid);

    int insert(Disease record);

    int insertSelective(Disease record);

    Disease selectByPrimaryKey(Integer diseaseid);

    int updateByPrimaryKeySelective(Disease record);

    int updateByPrimaryKey(Disease record);
}