package cn.yunji.doctormanager.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.ReturnCardMapper;
import cn.yunji.doctormanager.entity.ReturnCard;
import cn.yunji.doctormanager.service.ReturnCardService;
@Service( "returnCardService")
public class ReturnCardServiceImpl implements ReturnCardService {
@Resource 
private   ReturnCardMapper  rdao;
	

	public List<Map<String, Object>> findById(Integer userId, Integer eId) {
		List<Map<String, Object>> list  =rdao.findById(userId, eId);
		return  list;
	}

	
	public void delete(Integer userId, Integer eId) {
        rdao.delete(userId, eId);
		
	}


	@Override
	//回帖保存
	public void insertreturncard(Integer userId, Integer eId, String rcontent) {
		Date  now =new Date();
		//System.out.println(userId+","+eId+","+rcontent);
		ReturnCard  r=   new  ReturnCard(eId,rcontent,userId,now);    
		rdao.insertreturncard(r);
		
	}

}



