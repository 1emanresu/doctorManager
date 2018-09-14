package cn.yunji.doctormanager.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.Record4_7Mapper;
import cn.yunji.doctormanager.entity.Record4_7;
import cn.yunji.doctormanager.service.Record4_7Service;
@Service("record4_7Service")
public class Record4_7ServiceImpl implements Record4_7Service {
	@Resource
	private Record4_7Mapper record4_7Dao;

    @Override
    public List<Record4_7> findByWeeks(Integer weeks,String mid) {
        return record4_7Dao.findByWeeks(weeks,mid);
    }	
}
