package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.DietaryHabit;

public interface DietaryHabitMapper {
    int deleteByPrimaryKey(Integer hid);

    int insert(DietaryHabit record);

    int insertSelective(DietaryHabit record);

    DietaryHabit selectByPrimaryKey(Integer hid);

    int updateByPrimaryKeySelective(DietaryHabit record);

    int updateByPrimaryKey(DietaryHabit record);
    
    /**
	 * 根据mid查出所有
	 * zhongjl
	 * @param mid
	 * @return
	 */
    DietaryHabit findByMid(String mid);
}