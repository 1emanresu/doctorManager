package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Record1_3;

public interface Record1_3Mapper {
    int deleteByPrimaryKey(Integer rid13);

    int insert(Record1_3 record);

    int insertSelective(Record1_3 record);

    Record1_3 selectByPrimaryKey(Integer rid13);

    int updateByPrimaryKeySelective(Record1_3 record);

    int updateByPrimaryKey(Record1_3 record);
    /**
     * 根据孕周查询孕期记录
     * @author luoyc
     * @param weeks
     * @return
     */
    List<Record1_3> findByWeeks(Integer weeks,String mid);
}