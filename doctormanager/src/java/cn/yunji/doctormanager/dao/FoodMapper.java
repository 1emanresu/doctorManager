package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Food;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodid);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Integer foodid);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
    /**
     * 根据食物属性，找到对应食物列表
     * @param value 食物属性索引
     * @return
     */
    List<Food> findByAttribute(String value);
    
}