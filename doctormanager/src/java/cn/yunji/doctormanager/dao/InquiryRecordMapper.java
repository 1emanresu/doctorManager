package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.InquiryRecord;

public interface InquiryRecordMapper {
    int deleteByPrimaryKey(Integer qid);

    

    int insertSelective(InquiryRecord record);
    /**
     * 查询指定孕妇在指定日期范围的问诊记录
     * @author luoyc
     * @param mid
     * @param start
     * @param end
     * @return
     */
    List<InquiryRecord> findByDateRange(String mid,Date start,Date end);
    /**
     * 查询指定孕妇在指定日期的问诊记录
     * @author luoyc
     * @param record
     * @return
     */
    List<InquiryRecord> findByDate(InquiryRecord record);
    /**
     * 根据qid查询问诊记录
     * @author luoyc
     * @param qid
     * @return
     */
    InquiryRecord findByQid(Integer qid);
    /**
     * 查询指定孕妇所有的问诊记录
     * @author zhangqt
     * @param mid
     * @param pageSize 
     * @param pageIndex 
     * @param keyword 
     * @return
     */
    List<InquiryRecord> findByMid(@Param("mid")String mid,@Param("keyword") String keyword,@Param("sdate") String sdate,@Param("edate") String edate,@Param("pageIndex") Integer pageIndex,@Param("pageSize")Integer pageSize);
    int insert(InquiryRecord record);
    int updateByPrimaryKeySelective(InquiryRecord record);
   
    int updateByPrimaryKey(InquiryRecord record);
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