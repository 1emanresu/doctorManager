package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Contacts;

public interface ContactsService {
	public List<Map<String,Object>> queryByMid(String mid);
}
