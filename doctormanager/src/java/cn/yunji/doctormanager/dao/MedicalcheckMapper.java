package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.Medicalcheck;

public interface MedicalcheckMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Medicalcheck record);

    int insertSelective(Medicalcheck record);

    Medicalcheck selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Medicalcheck record);

    int updateByPrimaryKey(Medicalcheck record);
}