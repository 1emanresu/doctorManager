package cn.yunji.doctormanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.NursingEssentials;

public interface NursingEssentialsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NursingEssentials record);

    int insertSelective(NursingEssentials record);

    NursingEssentials selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NursingEssentials record);

    int updateByPrimaryKey(NursingEssentials record);
    /**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<NursingEssentials> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
}