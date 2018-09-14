package cn.yunji.doctormanager.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.PsychologyEssentials;

public interface PsychologyEssentialsService {
    /**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<PsychologyEssentials> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
}
