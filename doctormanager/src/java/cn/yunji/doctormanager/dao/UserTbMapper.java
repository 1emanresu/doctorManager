package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.UserTb;

public interface UserTbMapper {

	//检查密码账号
	UserTb findByNameAndpassword(String  userName, String password);
	
    int deleteByPrimaryKey(Integer userid);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);

	int queryByUserName(String username);
	
	UserTb selectByName(String username);
}