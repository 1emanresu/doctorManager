package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.ReturnCard;

public interface ReturnCardMapper {
	List<Map<String,Object>> findById(Integer userId,Integer eId);
	List<Map<String,Object>> findById1(Integer userId,Integer eId);
	void delete(Integer userId,Integer eId);
	void  insertreturncard(ReturnCard   returncard);
}
