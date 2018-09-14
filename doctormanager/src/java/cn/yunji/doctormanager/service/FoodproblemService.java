

package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Foodproblem;

public interface FoodproblemService {
	//根据fmid查询问题	
	public Foodproblem selectByPrimaryKey(Integer fpid);
	List<Map<String, Object>> selectAll();
}
