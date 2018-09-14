package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.Amniocentesis;


public interface AmniocentesisService {
	//根据孕妇编号查询
	public Amniocentesis findByMid(String mid,String checkDate);
	//增加
	public int addAmniocentesis(Amniocentesis Amniocentesis);
	//根据主键更新
	public int update(Amniocentesis Amniocentesis);
	//根据Mid更新
	public void updateByMid(Amniocentesis Amniocentesis);

	
}
