package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.HighrisktestResultMapper;
import cn.yunji.doctormanager.entity.HighrisktestResult;
import cn.yunji.doctormanager.service.HighrisktestResultService;
@Service("highrisktestResultService")
public class HighrisktestResultServiceImpl implements HighrisktestResultService {
	@Resource
	private HighrisktestResultMapper highrisktestResultMapper;
	@Override
	public int insert(HighrisktestResult highrisktestResult) {
		return highrisktestResultMapper.insert(highrisktestResult);
	}

}
