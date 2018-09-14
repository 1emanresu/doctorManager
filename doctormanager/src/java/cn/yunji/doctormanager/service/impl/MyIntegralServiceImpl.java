package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.MyIntegralMapper;
import cn.yunji.doctormanager.service.MyIntegralService;

 
@Service("myIntegralService")
public class MyIntegralServiceImpl implements MyIntegralService{
	@Resource
	MyIntegralMapper myIntegralMapper;
 
	@Override
	public List<Map<String, Object>> queryMyIntegral(int did) {
		return myIntegralMapper.queryMyIntegral(did);
	}
 
	@Override
	public int countIntegral(int did) {
		return  myIntegralMapper.countIntegral(did);
	}
 
	@Override
	public int countConversionIntegral(int did) {
		return myIntegralMapper.countConversionIntegral(did);
	}

}
