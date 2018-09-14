package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.Urine;

public interface UrineMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Urine record);

    int insertSelective(Urine record);

    Urine selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Urine record);

    int updateByPrimaryKey(Urine record);
}