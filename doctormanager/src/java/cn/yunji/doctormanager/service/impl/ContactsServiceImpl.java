package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.ContactsMapper;
import cn.yunji.doctormanager.entity.Contacts;
import cn.yunji.doctormanager.service.ContactsService;

@Service("contactsService")
public class ContactsServiceImpl implements ContactsService {
	@Resource
	private ContactsMapper contactsDao;
	@Override
	public List<Map<String,Object>> queryByMid(String mid) {
		// TODO Auto-generated method stub
		return contactsDao.queryByMid(mid);
	}

}
