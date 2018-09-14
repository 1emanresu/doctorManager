package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.HighriskTest;

public interface HighriskTestService {
	public List<Map<String, Object>> findByMid(String mid);
	//循环添加
	public int insertLoop(List<HighriskTest> highriskTest);
	
	List<Map<String, Object>> findByMidandweeks(String mid,String begintime,String endtime);
}
