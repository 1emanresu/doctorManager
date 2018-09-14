package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Record8_10;

public interface Record8_10Mapper {
    int deleteByPrimaryKey(Integer rid810);

    int insert(Record8_10 record);

    int insertSelective(Record8_10 record);

    Record8_10 selectByPrimaryKey(Integer rid810);

    int updateByPrimaryKeySelective(Record8_10 record);

    int updateByPrimaryKey(Record8_10 record);
    /**
     * 根据孕周查询孕期记录
     * @author luoyc
     * @param weeks
     * @return
     */
    List<Record8_10> findByWeeks(Integer weeks,String mid);
}