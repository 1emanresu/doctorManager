package cn.yunji.doctormanager.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.GravidaFirstCheckMapper;
import cn.yunji.doctormanager.service.GravidaFirstCheckService;
@Service("gravidaFirstCheckService")
public class GravidaFirstCheckServiceImpl implements  GravidaFirstCheckService{

    @Resource
    private GravidaFirstCheckMapper gravidaFirstCheckMapper;

    @Override
    public Map<String, Object> findByMid(String mid) {
        // TODO Auto-generated method stub
        return gravidaFirstCheckMapper.findByMid(mid);
    }
    
    
}
