package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

public  interface  ReturnCardService {

	List<Map<String,Object>> findById(Integer userId,Integer eId);
	void delete(Integer userId,Integer eId);
    void  insertreturncard(Integer userId,Integer eId,String rcontent);
	
}
