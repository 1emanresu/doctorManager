package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.Foodrecord;

public interface FoodrecordMapper {
    int deleteByPrimaryKey(Integer frid);

    int insert(Foodrecord record);

    int insertSelective(Foodrecord record);

    Foodrecord selectByPrimaryKey(Integer frid);

    int updateByPrimaryKeySelective(Foodrecord record);

    int updateByPrimaryKey(Foodrecord record);
}