package cn.yunji.doctormanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.WeeklyFood;

public interface WeeklyFoodMapper {
    int deleteByPrimaryKey(Integer wid);

    int insert(WeeklyFood record);

    int insertSelective(WeeklyFood record);

    WeeklyFood selectByPrimaryKey(Integer wid);

    int updateByPrimaryKeySelective(WeeklyFood record);

    int updateByPrimaryKey(WeeklyFood record);
    /**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<WeeklyFood> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
    /**
     * 根据孕周查询相应数据
     * @author luoyc
     * @param week
     * @return
     */
    WeeklyFood findByWeek(Integer week);
}