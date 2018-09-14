package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.MyCheckResultMapper;
import cn.yunji.doctormanager.entity.MyCheckResult;
import cn.yunji.doctormanager.service.MyCheckResultService;
@Service("myCheckResultService")
public class MyCheckResultServiceImpl implements MyCheckResultService {
	@Resource
	MyCheckResultMapper myCheckResultMapper;

	@Override
	public List<Map<String, Object>> findmycheckedByweeks(String mid, int bweeks, int eweeks) {
		// TODO Auto-generated method stub
		return myCheckResultMapper.findmycheckedByweeks(mid, bweeks, eweeks);
	}
	

}
