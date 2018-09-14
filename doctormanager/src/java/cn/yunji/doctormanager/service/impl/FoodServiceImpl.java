package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FoodMapper;
import cn.yunji.doctormanager.entity.Food;
import cn.yunji.doctormanager.service.FoodService;
@Service("foodService")
public class FoodServiceImpl implements FoodService{

	@Resource
	private FoodMapper foodDAO;
	@Override
	public List<Food> findByAttribute(String value) {
		// TODO Auto-generated method stub
		return foodDAO.findByAttribute(value);
	}

}
