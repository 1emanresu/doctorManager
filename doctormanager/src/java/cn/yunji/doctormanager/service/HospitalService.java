package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.Hospital;

public interface HospitalService {
	/**
     * 根据医院名字查询医院id
     * @author luoyc
     * @param hospitalName
     * @return
     */
    String findByName(String hospitalName);
    /**
     * 查询医院list
     * @author zhangqt
     * @return
     */
    public List<Hospital> find();
    
    public Hospital selectByPrimaryKey(String hospitalid);
}
