package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.UserRole;

public interface UserRoleMapper {
	UserRole  findByUserId(Integer  UserId);
    int deleteByPrimaryKey(Integer userroleid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userroleid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}