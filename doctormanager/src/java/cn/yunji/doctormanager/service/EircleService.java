package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Eircle;

public interface EircleService {
	   List<Map<String,Object>> findByUserId(Integer userId);
	      void      deleteById(Integer userId,Integer eid);
	      void     update(Integer userId, Integer eid,String praise);
	      void     updatePraise(Integer userId,Integer eid,String praise);
	      void     insert(Integer userId,String title,String content);
	
	
}
