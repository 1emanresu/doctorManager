package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.FolicAcid;


public interface FolicAcidService {
	//根据孕妇编号查询
	public FolicAcid findByMid(String Mid);
	//增加
	public int addFolicAcid(FolicAcid FolicAcid);
	//根据主键更新
	public int update(FolicAcid FolicAcid);
	//根据Mid更新
	public void updateByMid(FolicAcid folicAcid);
	//根据孕妇id查询，返回list
	public List<FolicAcid> queryByMid(String mid);
	
}
