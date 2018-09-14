package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.DietaryHabitMapper;
import cn.yunji.doctormanager.entity.DietaryHabit;
import cn.yunji.doctormanager.service.DietaryHabitService;

@Service("DietaryHabitService")
public class DietaryHabitServiceImpl implements DietaryHabitService{

	@Resource
	private DietaryHabitMapper dietaryHabitMapper;
	
	@Override
	public int insertSelective(DietaryHabit record) {
		return dietaryHabitMapper.insertSelective(record);
	}

	@Override
	public DietaryHabit findByMid(String mid) {
		return dietaryHabitMapper.findByMid(mid);
	}

	
}
