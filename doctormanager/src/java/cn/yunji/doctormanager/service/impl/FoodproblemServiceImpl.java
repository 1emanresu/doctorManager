/**@Title:FoodproblemServiceImpl.java
 * @description
 * @author king_smm
 * @date 2017年12月1日下午2:16:22
 * @copyright(c) 2017 云济健康管理(深圳)有限公司 AllRight Reserved.
 */
package cn.yunji.doctormanager.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FoodproblemMapper;
import cn.yunji.doctormanager.entity.Foodproblem;
import cn.yunji.doctormanager.service.FoodproblemService;

@Service("foodproblemService")
public class FoodproblemServiceImpl implements FoodproblemService{

	@Resource
	private FoodproblemMapper foodproblemMapper;
	/**
	 * @methodName selectByPrimaryKey
	 * @author hongwx
	 * @param fpid
	 * @return 根据fpid查询问题
	 * @see cn.yunji.doctormanager.service.FoodproblemService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Foodproblem selectByPrimaryKey(Integer fpid) {
		return foodproblemMapper.selectByPrimaryKey(fpid);
	}

	/**@methodName selectAll
	 * @description: 
	 * @return 
	 * @see cn.yunji.doctormanager.service.FoodproblemService#selectAll()
	 */
	@Override
	public List<Map<String, Object>> selectAll() {
		
		return foodproblemMapper.selectAll();
	}
}
