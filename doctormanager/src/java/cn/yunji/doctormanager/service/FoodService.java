package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.Food;

public interface FoodService {

	 /**
     * 根据食物属性，找到对应食物列表  @yinzx
     * @param value 食物属性索引
     * @return
     */
    List<Food> findByAttribute(String value);
}
