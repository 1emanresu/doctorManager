package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.DietaryHabit;

public interface DietaryHabitService {

	int insertSelective(DietaryHabit record);
	
	/**
	 * 根据mid查出所有
	 * zhongjl
	 * @param mid
	 * @return
	 */
	DietaryHabit findByMid(String mid);
}
