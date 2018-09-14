package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.EircleMapper;
import cn.yunji.doctormanager.entity.Eircle;
import cn.yunji.doctormanager.service.EircleService;



@Service("eircleService")
public class EircleServiceImpl implements EircleService {
 @Resource
 private EircleMapper   edao;
	@Override
	public List<Map<String, Object>> findByUserId(Integer userId) {
		List<Map<String, Object>> list=edao.findByUserId(userId);
		return  list;
	}
	@Override
	public void deleteById(Integer userId, Integer eid) {
            edao.deleteById(userId, eid);
	}

	@Override
	//点赞
	public void update(Integer userId, Integer eid,String praise) {
	   	Eircle  e=edao.findByUserIdAndeid(userId, eid);
	   	if(e.getPraise()!=null&&!"".equals(e.getPraise().trim())){
	   		  praise=new  StringBuilder(e.getPraise()).append(","+praise).toString();
			  Eircle e1=new Eircle(eid,userId,praise);
			  edao.updateAll(e1);
	   	}else{
	   		Eircle e1=new Eircle(eid,userId,praise);
	   		edao.updateAll(e1);
	   	}
	}

	@Override
	//发帖
	public void insert(Integer userId, String title, String content) {
		Date now =new Date();
		Map<String ,Object >map=new HashMap<String ,Object>();
		map.put("title",title );
		map.put("content",content );
		map.put("userId",userId);
		map.put("eDate",now );
		edao.insert(map);
	}



	@Override
	//取消赞
	public void updatePraise(Integer userId, Integer eid,String praise) {
		Eircle  e=edao.findByUserIdAndeid(userId, eid);
		String  praise1 =e.getPraise();
		if(praise1.length()>praise.length()){
	       praise =praise1.substring(0,praise1.indexOf(praise)-1);
	       Eircle  eircle =new Eircle (eid,userId,praise);
	       edao.updatepraise(eircle);		
		}else if(praise1.length()==praise.length()){
			praise =praise1.substring(0,praise1.indexOf(praise));
		    Eircle  eircle =new Eircle (eid,userId,praise);
		    edao.updatepraise(eircle);
		}else{
			Eircle  eircle =new Eircle (eid,userId,"");
			edao.updatepraise(eircle);
		}

	}

	
}
