package cn.yunji.doctormanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.PsychologyEssentials;

public interface PsychologyEssentialsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PsychologyEssentials record);

    int insertSelective(PsychologyEssentials record);

    PsychologyEssentials selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PsychologyEssentials record);

    int updateByPrimaryKey(PsychologyEssentials record);
    /**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<PsychologyEssentials> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
}