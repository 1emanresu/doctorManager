package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.Selfteststatu;

public interface SelfteststatuService {
    /**
     * 根据指标编号查询
     * @param cid
     * @param data
     * @return
     */
    Selfteststatu findByCid(Integer cid,Double data);
    /**
     * 根据孕周查询
     * @param cid
     * @param week
     * @return
     */
    Selfteststatu findByWeek(Integer week,Integer cid);
    /**
     * 根据BMI和孕周查询
     * @param cid
     * @param data
     * @param week
     * @return
     */
    Selfteststatu findByWeekAndBMI(Integer week,Integer cid,Double data,Double BMI);
}
