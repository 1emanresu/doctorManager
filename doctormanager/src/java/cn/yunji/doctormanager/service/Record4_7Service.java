package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.Record1_3;
import cn.yunji.doctormanager.entity.Record4_7;

public interface Record4_7Service {
    /**
     * 根据孕周查询孕期记录
     * @author luoyc
     * @param weeks
     * @return
     */
    List<Record4_7> findByWeeks(Integer weeks,String mid);
}
