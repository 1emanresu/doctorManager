package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.NurseMapper;
import cn.yunji.doctormanager.entity.Nurse;
import cn.yunji.doctormanager.service.NurseService;

@Service("nurseService")
public class NurseServiceImpl implements NurseService{
	@Resource
	public NurseMapper nurseMapper;
	@Override
	public List<Map<String, Object>> queryByNurseId(int nid) {
		// TODO Auto-generated method stub
		return nurseMapper.queryByNurseId(nid);
	}

}
