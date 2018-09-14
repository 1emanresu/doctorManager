package cn.yunji.doctormanager.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.Record8_10Mapper;
import cn.yunji.doctormanager.entity.Record8_10;
import cn.yunji.doctormanager.service.Record8_10Service;
@Service("record8_10Service")
public class Record8_10ServiceImpl implements Record8_10Service {
	@Resource
	private Record8_10Mapper record8_10Dao;

    @Override
    public List<Record8_10> findByWeeks(Integer weeks,String mid) {
        return record8_10Dao.findByWeeks(weeks,mid);
    }	
}
