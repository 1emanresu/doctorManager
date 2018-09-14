package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.HighRiskResultTypeMapper;
import cn.yunji.doctormanager.entity.HighRiskResultType;
import cn.yunji.doctormanager.service.HighRiskResultTypeService;

@Service("highRiskResultTypeService")
public class HighRiskResultTypeServiceImpl implements HighRiskResultTypeService {
	@Resource
	private HighRiskResultTypeMapper highRiskResultTypeMapper;

	@Override
	public HighRiskResultType queryByType(int score) {
		return highRiskResultTypeMapper.queryByType(score);
	}

	@Override
	public HighRiskResultType queryByScore(int score) {
		return highRiskResultTypeMapper.selectByScore(score);
	}
    
    @Override
    public List<HighRiskResultType> queryAll() {
        // TODO Auto-generated method stub
        return highRiskResultTypeMapper.queryAll();
    }

}
