package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.SymptomResult;

public interface SymptomResultMapper {
    int deleteByPrimaryKey(Integer symptomid);

    int insert(SymptomResult record);

    int insertSelective(SymptomResult record);

    SymptomResult selectByPrimaryKey(Integer symptomid);

    int updateByPrimaryKeySelective(SymptomResult record);

    int updateByPrimaryKey(SymptomResult record);
}