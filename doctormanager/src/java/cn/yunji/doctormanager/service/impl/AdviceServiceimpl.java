package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.AdviceMapper;
import cn.yunji.doctormanager.entity.Advice;
import cn.yunji.doctormanager.service.AdviceService;
 
@Service("adviceService")
public class AdviceServiceimpl implements AdviceService{
	@Resource
    public	AdviceMapper adviceMapper;
	@Override
	public int insertSelective(Advice advice) {
		return adviceMapper.insertSelective(advice);
	}

}
