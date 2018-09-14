package cn.yunji.doctormanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Exercise;

public interface ExerciseService {
	/**
	 * 查询微量运动
	 * @author yinzx
	 * @return
	 */
	public List<Exercise> findMicroSports();
	/**
	 * 查询中量运动
	 * @author yinzx
	 * @return
	 */
	public List<Exercise> findModerateSports();
	/**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<Exercise> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
}
