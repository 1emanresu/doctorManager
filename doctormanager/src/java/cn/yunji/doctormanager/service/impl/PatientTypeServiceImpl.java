package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.PatientTypeMapper;
import cn.yunji.doctormanager.entity.PatientType;
import cn.yunji.doctormanager.service.PatientTypeService;

@Service("patientTypeService")
public class PatientTypeServiceImpl implements PatientTypeService {
	@Resource
	private PatientTypeMapper patientTypeDao;

    @Override
    public List<PatientType> findAll() {
        return patientTypeDao.findAll();
    }


}
