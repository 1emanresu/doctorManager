/**@Title:FoodrecordServiceImpl.java
 * @description
 * @author king_smm
 * @date 2017年12月1日下午2:42:53
 * @copyright(c) 2017 云济健康管理(深圳)有限公司 AllRight Reserved.
 */
package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FoodrecordMapper;
import cn.yunji.doctormanager.entity.Foodrecord;
import cn.yunji.doctormanager.service.FoodrecordService;

@Service("foodrecordService")
public class FoodrecordServiceImpl implements FoodrecordService{
	@Resource
	private FoodrecordMapper foodrecordMapper;
	
	public int insertSelective(Foodrecord foodrecord){
		return foodrecordMapper.insertSelective(foodrecord);
	}

}
