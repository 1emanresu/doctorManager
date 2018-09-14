package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.MyAdvice;

public interface MyAdviceMapper {
    int deleteByPrimaryKey(Integer myadviceid);

    int insert(MyAdvice record);

    int insertSelective(MyAdvice record);

    MyAdvice selectByPrimaryKey(Integer myadviceid);

    int updateByPrimaryKeySelective(MyAdvice record);

    int updateByPrimaryKey(MyAdvice record);
    
    List<MyAdvice> selectByDoctorId(Integer doctorid);
}