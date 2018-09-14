package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.DoctorAdviceMapper;
import cn.yunji.doctormanager.entity.DoctorAdvice;
import cn.yunji.doctormanager.service.DoctorAdviceService;
import cn.yunji.doctormanager.service.impl.DoctorAdviceServiceImpl;

@Service("doctorAdviceService")
public class DoctorAdviceServiceImpl implements DoctorAdviceService {
	@Resource
	private DoctorAdviceMapper doctorAdviceMapper;

	@Override
	public int addDoctorAdvice(DoctorAdvice doctorAdvice) {
		return doctorAdviceMapper.insert(doctorAdvice);
	}

	@Override
	public List<DoctorAdvice> queryByMid(String mid) {
		return doctorAdviceMapper.doctorAdviceQueryByMid(mid);
	}

	@Override
	public Integer insertDoctorAdvice(DoctorAdvice doctorAdvice) {

		return doctorAdviceMapper.insertDoctorAdvice(doctorAdvice);
	}

	@Override
	public List<DoctorAdvice> findByDateRange(String mid, Date begin, Date end) {

		return doctorAdviceMapper.findByDateRange(mid, begin, end);
	}

	@Override
	public List<DoctorAdvice> findByMid(String mid, String keyword,String sdate,String edate,Integer pageIndex,Integer pageSize) {
		// TODO Auto-generated method stub
		return doctorAdviceMapper.findByMid(mid,keyword,sdate,edate, pageIndex, pageSize);
	}
}
