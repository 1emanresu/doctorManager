package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.vipOrderMapper;
import cn.yunji.doctormanager.entity.vipOrder;
import cn.yunji.doctormanager.service.VipOrderService;
@Service("vipOrderService")
public class VipOrderServiceImpl implements VipOrderService {
	@Resource
	private vipOrderMapper vipOrderMapper;
	@Override
	public int addOrder(vipOrder vipOrder) {
		// TODO Auto-generated method stub
		return vipOrderMapper.insert(vipOrder);
	}
	@Override
	public List<Map<String,Object>> queryServiceTypeNum() {
		// TODO Auto-generated method stub
		return vipOrderMapper.queryServiceTypeNum();
	}
	@Override
	public List<Map<String,Object>> queryWeeklyHandleNum(String weeklast,Integer vipid) {
		// TODO Auto-generated method stub
		return vipOrderMapper.queryWeeklyHandleNum(weeklast, vipid);
	}

}
