package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.VipGrade;

public interface VipGradeMapper {
    int deleteByPrimaryKey(Integer vipgradeid);

    int insert(VipGrade record);

    int insertSelective(VipGrade record);

    VipGrade selectByPrimaryKey(Integer vipgradeid);

    int updateByPrimaryKeySelective(VipGrade record);

    int updateByPrimaryKey(VipGrade record);

	List<VipGrade> find();
	
	VipGrade selectByName(String name);
}