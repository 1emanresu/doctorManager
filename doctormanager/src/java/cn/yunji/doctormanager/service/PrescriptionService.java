package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.Prescription;

public interface PrescriptionService {
	public List<Prescription> queryByMid(String mid);
	/**
     * 根据日期范围查询指定孕妇的用药记录
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Prescription> findByDateRange(String mid,Date begin,Date end);
    /**
     * 根据mid和处方日期查出对应孕妇的用药记录
     * @param mid
     * @param predate
     * @return
     */
    List<Prescription> selectByPredate(String mid,Date predate);
}
