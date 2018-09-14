package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Foodproblem;

public interface FoodproblemMapper {
    int deleteByPrimaryKey(Integer fpid);

    int insert(Foodproblem record);

    int insertSelective(Foodproblem record);

    Foodproblem selectByPrimaryKey(Integer fpid);

    int updateByPrimaryKeySelective(Foodproblem record);

    int updateByPrimaryKey(Foodproblem record);
    List<Map<String, Object>> selectAll();
}