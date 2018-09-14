package cn.yunji.doctormanager.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.Record1_3Mapper;
import cn.yunji.doctormanager.entity.Record1_3;
import cn.yunji.doctormanager.service.Record1_3Service;
@Service("record1_3Service")
public class Record1_3ServiceImpl implements Record1_3Service {
	@Resource
	private Record1_3Mapper record1_3Dao;

    @Override
    public List<Record1_3> findByWeeks(Integer weeks,String mid) {
        return record1_3Dao.findByWeeks(weeks,mid);
    }	
}
