package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.OfficeItem;

public interface OfficeItemMapper {
    int deleteByPrimaryKey(Integer offid);

    int insert(OfficeItem record);

    int insertSelective(OfficeItem record);

    OfficeItem selectByPrimaryKey(Integer offid);

    int updateByPrimaryKeySelective(OfficeItem record);

    int updateByPrimaryKey(OfficeItem record);
    /**
     * 查询全部的科室子列表
     * @Description: TODO(用一句话描述该方法做什么) 
     * @return
     * @author wangzw
     */
    List<OfficeItem> findOffAll();
}