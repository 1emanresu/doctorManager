package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.PrescriptionMapper;
import cn.yunji.doctormanager.entity.Prescription;
import cn.yunji.doctormanager.service.PrescriptionService;
@Service("prescriptionService")
public class PrescriptionServiceImpl implements PrescriptionService {
	@Resource
	private PrescriptionMapper prescriptionDao;

	@Override
	public List<Prescription> queryByMid(String mid) {
		return prescriptionDao.queryByMid(mid);
	}

    @Override
    public List<Prescription> findByDateRange(String mid, Date begin, Date end) {
        return prescriptionDao.findByDateRange(mid, begin, end);
    }

	@Override
	public List<Prescription> selectByPredate(String mid, Date predate) {
		return prescriptionDao.selectByPredate(mid, predate);
	}
	
}
