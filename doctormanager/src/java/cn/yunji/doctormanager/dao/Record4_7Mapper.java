package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Record4_7;

public interface Record4_7Mapper {
    int deleteByPrimaryKey(Integer rid47);

    int insert(Record4_7 record);

    int insertSelective(Record4_7 record);

    Record4_7 selectByPrimaryKey(Integer rid47);

    int updateByPrimaryKeySelective(Record4_7 record);

    int updateByPrimaryKey(Record4_7 record);
    /**
     * 根据孕周查询孕期记录
     * @author luoyc
     * @param weeks
     * @return
     */
    List<Record4_7> findByWeeks(Integer weeks,String mid);
}