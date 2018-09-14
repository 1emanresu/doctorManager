package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.yunji.doctormanager.dao.FansMapper;
import cn.yunji.doctormanager.service.FansService;
@Service("fansService")
public class FansServiceImpl implements FansService{
	@Resource
    public	FansMapper fansMapper;
	@Override
	public List<Map<String, Object>> selectByFins(int did){
		return fansMapper.selectByFins(did);
	}

}
