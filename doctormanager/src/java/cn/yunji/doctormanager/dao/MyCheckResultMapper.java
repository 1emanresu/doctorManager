package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.MyCheckResult;

public interface MyCheckResultMapper {
    int deleteByPrimaryKey(Integer mcrid);

    int insert(MyCheckResult record);

    int insertSelective(MyCheckResult record);

    MyCheckResult selectByPrimaryKey(Integer mcrid);

    int updateByPrimaryKeySelective(MyCheckResult record);

    int updateByPrimaryKey(MyCheckResult record);
    
    List<Map<String, Object>> findmycheckedByweeks(String mid, Integer bweeks, Integer eweeks);
}