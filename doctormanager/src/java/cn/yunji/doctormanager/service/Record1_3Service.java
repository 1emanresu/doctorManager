package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.Record1_3;

public interface Record1_3Service {
    /**
     * 根据孕周查询孕期记录
     * @author luoyc
     * @param weeks
     * @return
     */
    List<Record1_3> findByWeeks(Integer weeks,String mid);
}
