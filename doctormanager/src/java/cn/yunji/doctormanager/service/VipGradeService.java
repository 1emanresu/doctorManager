package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.VipGrade;

public interface VipGradeService {
	public List<VipGrade> find();
	
	int insertSelective(VipGrade record);
	
	VipGrade selectByPrimaryKey(Integer vipgradeid);
	
	/**
	 * 根据会员套餐名称查询
	 * @param name
	 * @return
	 */
	VipGrade selectByName(String name);
	
	int updateByVid(VipGrade record);
	
	int deleteByPrimaryKey(Integer vipgradeid);
}
