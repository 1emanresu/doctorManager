package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.MyAdvice;

public interface MyAdviceService {
	int insert(MyAdvice record);
	
	List<MyAdvice> selectByDoctorId(Integer doctorid);
}
