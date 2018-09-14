package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.HighriskProblemMapper;
import cn.yunji.doctormanager.entity.HighriskProblem;
import cn.yunji.doctormanager.service.HighriskProblemService;

@Service("highriskProblemService")
public class HighriskProblemServiceImpl implements HighriskProblemService {
	@Resource
	private HighriskProblemMapper highriskProblemDao;

	@Override
	public List<HighriskProblem> find() {
		return highriskProblemDao.find();
	}
	
}
