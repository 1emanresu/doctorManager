package cn.yunji.doctormanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.WeeklyFood;

public interface WeeklyFoodService {
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
