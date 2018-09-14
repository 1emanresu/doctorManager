package cn.yunji.doctormanager.service;

import java.util.Map;

import cn.yunji.doctormanager.entity.UserTb;



public interface UserLoginService {
	//用户登录接口
	Map<String,Object>  login(String userName, String password,String rType)throws  LoginAllException;
	
	//电脑端信息系统登录by luoyc
	Map<String,Object>  webLogin(String userName, String password);
	
	//用户注册
	int register(UserTb user);
	
	//参数username返回id
	public int queryByUserName(String username);
}
