package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.VipGradeMapper;
import cn.yunji.doctormanager.entity.VipGrade;
import cn.yunji.doctormanager.service.VipGradeService;

@Service("vipGradeService")
public class VipGradeServiceImpl  implements VipGradeService{
	@Resource
	private VipGradeMapper vipGradeDao;

	@Override
	public List<VipGrade> find() {
		return vipGradeDao.find();
	}

	@Override
	public int insertSelective(VipGrade record) {
		return vipGradeDao.insertSelective(record);
	}

	@Override
	public VipGrade selectByPrimaryKey(Integer vipgradeid) {
		return vipGradeDao.selectByPrimaryKey(vipgradeid);
	}

	@Override
	public VipGrade selectByName(String name) {
		return vipGradeDao.selectByName(name);
	}

	@Override
	public int updateByVid(VipGrade record) {
		return vipGradeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer vipgradeid) {
		return vipGradeDao.deleteByPrimaryKey(vipgradeid);
	}
	
	
	
}