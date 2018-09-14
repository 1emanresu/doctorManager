package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.CheckProject;

public interface CheckProjectMapper {
    int deleteByPrimaryKey(Integer checkprojectid);

    int insert(CheckProject record);

    int insertSelective(CheckProject record);

    CheckProject selectByPrimaryKey(Integer checkprojectid);

    int updateByPrimaryKeySelective(CheckProject record);

    int updateByPrimaryKey(CheckProject record);
    
    CheckProject selectByRiskname(String riskname);
    /**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<CheckProject> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
    /**
     * @author wangzw
     * @param mid 孕妇编号
     * @return 所检查的项目
     */
    List<Map<String, Object>> findCheckProjectAll(String mid);
    /**
     * @author wangzw
     * @param id 来自哪里
     * @return 所有的项目
     */
    List<Map<String, Object>> allFind(int id);
}