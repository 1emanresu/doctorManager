package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Hospital;

public interface HospitalMapper {
    int deleteByPrimaryKey(String hospitalid);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(String hospitalid);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);
    
    /**
     * 根据医院名字查询医院id
     * @author luoyc
     * @param hospitalName
     * @return
     */
    String findByName(String hospitalName);

	List<Hospital> find();
}