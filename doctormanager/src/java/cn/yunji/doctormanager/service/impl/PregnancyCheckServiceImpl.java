package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.PregnancyCheckMapper;
import cn.yunji.doctormanager.entity.PregnancyCheck;
import cn.yunji.doctormanager.service.PregnancyCheckService;
@Service("pregnancyCheckService")
public class PregnancyCheckServiceImpl implements PregnancyCheckService{

    @Resource
    private  PregnancyCheckMapper  pregnancyCheckDAO;
    @Override
    public int addOfUpdate(PregnancyCheck pregnancyCheck) {
        // TODO Auto-generated method stub
        Integer pcid=pregnancyCheck.getPcid();
        PregnancyCheck record = pregnancyCheckDAO.findByPcid(pcid);
        
        if(record==null){
            return pregnancyCheckDAO.insertSelective(pregnancyCheck);
        }else{
            return pregnancyCheckDAO.updateByPcid(pregnancyCheck);
        }
        
    }
    @Override
    public int updateByPcid(PregnancyCheck pregnancyCheck) {
        // TODO Auto-generated method stub
        return pregnancyCheckDAO.updateByPcid(pregnancyCheck);
    }
    @Override
    public PregnancyCheck findByPcid(int pcid) {
        // TODO Auto-generated method stub
        return pregnancyCheckDAO.findByPcid(pcid);
    }
    @Override
    public int add(PregnancyCheck record) {
        // TODO Auto-generated method stub
        return pregnancyCheckDAO.insertSelective(record);
    }

}
