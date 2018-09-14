package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.HighRiskRtandardMapper;
import cn.yunji.doctormanager.entity.HighRiskRtandard;
import cn.yunji.doctormanager.service.HighRiskRtandardService;

@Service("highRiskRtandardService")
public class HighRiskRtandardServiceImpl implements HighRiskRtandardService {
	@Resource
	private HighRiskRtandardMapper highRiskRtandardMapper;
    @Resource
	private HighRiskRtandardMapper dao;

	@Override
	public List<HighRiskRtandard> queryById(String hid, int cid) {
		// TODO Auto-generated method stub
		return dao.queryById(hid, cid);
	}
	@Override
	public HighRiskRtandard queryHighRiskRtandard(Number value, String hid, int cid, boolean flag) {
		//return null;
		return dao.queryHighRiskRtandard(value,hid,cid,flag);
	}
    @Override
	public List<HighRiskRtandard> findByCid(HighRiskRtandard record) {
		return highRiskRtandardMapper.findByCid(record);
	}

	@Override
	public HighRiskRtandard getHisgRiskStandardbycid(int cid) {
		// TODO Auto-generated method stub
		return dao.selectBycid(cid);
	}

}
