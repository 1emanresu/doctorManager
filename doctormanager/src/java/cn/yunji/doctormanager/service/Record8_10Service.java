package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.Record1_3;
import cn.yunji.doctormanager.entity.Record8_10;

public interface Record8_10Service {
    /**
     * 根据孕周查询孕期记录
     * @author luoyc
     * @param weeks
     * @return
     */
    List<Record8_10> findByWeeks(Integer weeks,String mid);
}
