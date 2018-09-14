package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.OfficeMapper;
import cn.yunji.doctormanager.entity.Office;
import cn.yunji.doctormanager.service.OfficeService;
@Service("officeService")
public class OfficeServiceImpl implements OfficeService {
	@Resource
	private OfficeMapper officeDao;
	@Override
	public List<Office> findOffice() {
		// TODO Auto-generated method stub
		return officeDao.findOffice();
	}

}
