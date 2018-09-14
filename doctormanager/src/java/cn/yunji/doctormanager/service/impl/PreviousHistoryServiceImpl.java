package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.PreviousHistoryMapper;
import cn.yunji.doctormanager.entity.PreviousHistory;
import cn.yunji.doctormanager.service.PreviousHistoryService;
@Service("previousHistoryService")
public class PreviousHistoryServiceImpl implements PreviousHistoryService{

    @Resource
    private PreviousHistoryMapper previousHistoryMapper;

    @Override
    public String findByMid(String mid) {
        // TODO Auto-generated method stub
        String result="";
        PreviousHistory ph = previousHistoryMapper.findByMid(mid);
        if(ph==null){return "无";}
        Integer heartdisease=ph.getHeartdisease();
        if(heartdisease==1){
            result+="心脏病";
        }
        Integer tb=ph.getHeartdisease();
        if(tb==1){
            result+=" 肺结核";
        }
        Integer hepatopathy=ph.getHepatopathy();
        if(hepatopathy==1){
            result+=" 肝脏病";
        }
        Integer Hypertension=ph.getHypertension();
        if(Hypertension==1){
            result+=" 高血压";
        }
        Integer Umpire=ph.getUmpire();
        if(Umpire==1){
            result+=" 性病";
        }
        Integer Diabetes=ph.getDiabetes();
        if(Diabetes==1){
            result+=" 糖尿病";
        }
        Integer Psychosis=ph.getPsychosis();
        if(Psychosis==1){
            result+=" 精神病";
        }
        Integer Heent=ph.getHeent();
        if(Heent==1){
            result+=" 五官疾病";
        }
        
        if(result=="") result="无";
        return result;
    }
   
}
