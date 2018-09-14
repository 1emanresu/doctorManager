package cn.yunji.doctormanager.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.UserTbMapper;
import cn.yunji.doctormanager.entity.UserTb;
import cn.yunji.doctormanager.service.LoginAllException;
import cn.yunji.doctormanager.service.UserLoginService;

@Service("userLoginService")
public class UserLoginServiceImpl  implements UserLoginService{
  @Resource
	 private  UserTbMapper userTbDao;
	public    Map<String,Object>  login(String userName, String password, String rType)
			throws  LoginAllException{
		
		if(userName==null ||userName.trim().isEmpty()){
			throw new   LoginAllException("账号为空");
		}
		if(password==null ||password.trim().isEmpty()){
			throw new  LoginAllException("密码为空");
		}			
	UserTb  user1=userTbDao.findByNameAndpassword(userName, password); 	
    
	 
	if(user1==null){
    	 throw new   LoginAllException("账号或者密码错误");
     } 
     if(!rType.equals(user1.getAddUserRole().getRole().getRtype())){
    	 throw   new  LoginAllException("用户不存在");
     }
     Map<String,Object> map=new   HashMap<String,Object>();
    if(user1.getDoctorid()!=null){
             map.put("doctorid", user1.getDoctorid().getDoctorid());
             map.put("userId", user1.getUserid());
             map.put("dname", user1.getDoctorid().getDname());
     }else if(user1.getGravidaInfo()!=null){
    	     map.put("mid", user1.getGravidaInfo().getMid());
    	     map.put("gname", user1.getDoctorid().getDname());
    	     map.put("userId", user1.getUserid());
     }else  if(user1.getNuser()!=null){
    	 map.put("nurseid",user1.getNuser().getNurseid()); 
    	 map.put("nurseuserid",user1.getUserid());
     }

     return    map;
   
	}
	@Override
	public Map<String, Object> webLogin(String userName, String password) {
		UserTb user=userTbDao.findByNameAndpassword(userName, password);
		Map<String,Object> map=new HashMap<String,Object>();
		if(user==null){
			return null;
		}else if(user.getDoctorid()!=null){
            map.put("doctorId", user.getDoctorid().getDoctorid());
            map.put("userId", user.getUserid());
            map.put("dName", user.getDoctorid().getDname());
            map.put("pid", user.getDoctorid().getPid());
	    }else  if(user.getNuser()!=null){
		   	map.put("nurseId",user.getNuser().getNurseid()); 
		   	map.put("userId",user.getUserid());
		   	map.put("nName", user.getNuser().getNname());
	    }else if(user.getGravidaInfo()!=null){
	    	return null;
	    }
		return map;
	}
	
	@Override
	public int register(UserTb user) {
		// TODO Auto-generated method stub
		return userTbDao.insertSelective(user);
	}
	@Override
	public int queryByUserName(String username) {
		// TODO Auto-generated method stub
		return userTbDao.queryByUserName(username);
	}

	

}
