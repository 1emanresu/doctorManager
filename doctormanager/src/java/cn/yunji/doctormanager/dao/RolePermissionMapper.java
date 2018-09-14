package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rolepermissionid);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolepermissionid);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}