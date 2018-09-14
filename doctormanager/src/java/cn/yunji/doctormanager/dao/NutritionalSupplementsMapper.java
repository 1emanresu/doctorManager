package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.NutritionalSupplements;

public interface NutritionalSupplementsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NutritionalSupplements record);

    int insertSelective(NutritionalSupplements record);

    NutritionalSupplements selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NutritionalSupplements record);

    int updateByPrimaryKey(NutritionalSupplements record);
}