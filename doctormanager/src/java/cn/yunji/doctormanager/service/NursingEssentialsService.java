package cn.yunji.doctormanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.NursingEssentials;

public interface NursingEssentialsService {
    /**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<NursingEssentials> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
}
