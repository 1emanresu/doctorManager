package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

 
import cn.yunji.doctormanager.dao.SubscribeMapper;
import cn.yunji.doctormanager.service.SubscribeService;
@Service("subscribeService")
public class SubscribeServiceImpl implements SubscribeService{
    @Resource
	private SubscribeMapper subscribeMapper;

	@Override
	public int queryCount() {
		return subscribeMapper.queryCount();
	}

	@Override
	public List<Map<String, Object>> queryBySubId(int did) {
		return subscribeMapper.queryBySubId(did);
	}

}
