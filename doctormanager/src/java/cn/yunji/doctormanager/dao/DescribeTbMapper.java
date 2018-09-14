package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.DescribeTb;

public interface DescribeTbMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(DescribeTb record);

    int insertSelective(DescribeTb record);

    DescribeTb selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(DescribeTb record);

    int updateByPrimaryKey(DescribeTb record);
}