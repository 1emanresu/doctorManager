package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.SelfteststatuMapper;
import cn.yunji.doctormanager.entity.Selfteststatu;
import cn.yunji.doctormanager.service.SelfteststatuService;


@Service("selfteststatuService")
public class SelfteststatuServiceImpl implements SelfteststatuService {
	@Resource
	private SelfteststatuMapper selfteststatuDao;

    @Override
    public Selfteststatu findByCid(Integer cid, Double data) {
        
        return selfteststatuDao.findByCid(cid, data);
    }

    @Override
    public Selfteststatu findByWeek(Integer week, Integer cid) {
        
        return selfteststatuDao.findByWeek(week, cid);
    }

    @Override
    public Selfteststatu findByWeekAndBMI(Integer week, Integer cid, Double data, Double BMI) {
        
        return selfteststatuDao.findByWeekAndBMI(week, cid, data, BMI);
    }



}
