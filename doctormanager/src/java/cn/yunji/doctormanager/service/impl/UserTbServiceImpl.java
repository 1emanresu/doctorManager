package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.UserTbMapper;
import cn.yunji.doctormanager.entity.UserTb;
import cn.yunji.doctormanager.service.UserTbService;
@Service("userTbService")
public class UserTbServiceImpl implements UserTbService {
	@Resource
	UserTbMapper UserTbDAO;
	@Override
	public int updateByPrimaryKeySelective(UserTb userTb) {
		return UserTbDAO.updateByPrimaryKeySelective(userTb);
	}
	@Override
	public int addUser(UserTb userTb) {
		// TODO Auto-generated method stub
		return UserTbDAO.insert(userTb);
	}
	@Override
	public UserTb findByNameAndpassword(String userName, String password) {
		// TODO Auto-generated method stub
		return UserTbDAO.findByNameAndpassword(userName, password);
	}
	@Override
	public UserTb selectByName(String username) {
		// TODO Auto-generated method stub
		return UserTbDAO.selectByName(username);
	}

}
