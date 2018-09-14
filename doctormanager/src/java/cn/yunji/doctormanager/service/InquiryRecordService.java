package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.InquiryRecord;

public interface InquiryRecordService {
    /**
     * 根据qid查询问诊记录
     * @author luoyc
     * @param qid
     * @return
     */
    InquiryRecord findByQid(Integer qid);
	/**
     * 查询指定孕妇在指定日期的问诊记录
     * @author luoyc
     * @param record
     * @return
     */
    List<InquiryRecord> findByDate(InquiryRecord record);
    /**
     * 查询指定孕妇所有的问诊记录
     * @author luoyc
     * @param mid
     * @param pageSize 
     * @param pageIndex 
     * @param keyword 
     * @return
     */
    List<InquiryRecord> findByMid(String mid, String keyword,String sdate,String edate, Integer pageIndex, Integer pageSize);
    /**
     * 查询指定孕妇在指定日期范围的问诊记录
     * @author luoyc
     * @param mid
     * @param start
     * @param end
     * @return
     */
    List<InquiryRecord> findByDateRange(String mid,Date start,Date end);
    int insert(InquiryRecord record);
    
    /**
     * 用mid查全部记录
     * @param mid
     * @return
     */
    List<InquiryRecord> selectByMid(String mid);
    /** 
     * @Description: 根据mid查询所有问诊报告记录
     * @author yinzx
     * @createDate 2018年1月17日 下午3:06:53
     * @param mid
     * @return
     */
    List<Map<String, Object>> findAllByMid(String mid);
}
