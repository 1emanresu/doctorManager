package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.HighRiskResultType;

public interface HighRiskResultTypeService {

	public HighRiskResultType queryByType(int score);
	
	public HighRiskResultType queryByScore(int score);

    List<HighRiskResultType> queryAll();
	
}
