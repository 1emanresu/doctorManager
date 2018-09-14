package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.CheckResult;

public interface CheckResultService {
    
    /**
     * 
     *根据主键查询相应结果
     * @param checkresultid
     * @return
     * @author luoyc
     * @createDate 2017年11月20日 下午7:37:02
     */
    CheckResult selectByPrimaryKey(Integer checkresultid);    
	/**
	 * 根据孕妇ID，检查项目ID查询孕妇检查项日期记录
	 * @param mid		孕妇ID
	 * @param projectId	检查项目ID
	 * @return 检查项检查日期记录
	 */
	List<Map<String, Object>> queryByProjectId(String mid, Integer projectId);
	
	/**
	 * 根据孕周，检查项目ID查询检查结果明细数据
	 * @param weeks 孕周
	 * @param projectId 检查项目ID
	 * @return
	 */
	List<Map<String, Object>> queryCheckDetail(Integer weeks, Integer projectId);   

	/**
	 * 根据孕周，检查项目ID,孕妇id查询检查结果明细数据   yinzx
	 * @param weeks 孕周
	 * @param projectId 检查项目ID
	 * @return
	 */
	List<Map<String, Object>> queryCheckDetailByMId(Integer weeks, Integer checkProjectId,String mid);
	/**
	 * 按项目查询： 根据检查项目id、mid、检查结果id 查询检查明细及指标  @yinzx
	 * @param checkResultId
	 * @param checkProjectId
	 * @param mId
	 * @return 检查明细及指标
	 */
	List<Map<String, Object>> queryResultByProject(Integer checkResultId, Integer checkProjectId, String mId);
	
	/**
	 * 根据检查项目id、mid 查询检查结果id和检查时间（按时间升序）  @yinzx
	 * @param checkProjectId
	 * @param mId
	 * @return
	 */
	List<Map<String, Object>> queryCheckResultId( Integer checkProjectId, String mId);
    
	CheckResult selectByMid(CheckResult record);

	/**
	 * 根据孕妇ID，检查时间，检查项目ID查询孕妇检查记录
	 * @param mid 孕妇ID
	 * @param checkDate 检查时间
	 * @param projectId 检查项目
	 * @return
	 */
    CheckResult queryByCheckDate(String mid, Date checkDate, Integer projectId);

    /**
     * 根据检查时间，检查项目ID查询检查结果明细数据
     * @param checkDate 检查时间
     * @param projectId 检查项目ID
     * @return
     */
    List<Map<String, Object>> queryCheckDetailByDate(Date checkDate, Integer projectId);
    /**
     * 通过孕妇id查询孕妇所有b超报告的双顶径、腹围、股骨长数据
     * @author luoyc
     * @param mid
     * @return
     */
    List<Map<String, Object>> selectFetalWeightByMid(String mid);
    /**
	 * 按指标名字查询： 根据检查项目id、mid、指标名字  查询该项指标的历史数据  @yinzx（按时间升序）  @yinzx
	 * @param checkProjectId
	 * @param mId
	 * @param cname
	 * @return
	 */
	List<Map<String, Object>> queryHistoByCname(Integer checkProjectId,String mId,String cname);
	 /**
     * 根据上传日期，查询指定孕妇上传的检查结果
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<CheckResult> findByDateRange(String mid,Date begin,Date end);
    /**
     * 根据上传日期，查询指定孕妇上传的检查结果以及异常信息
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<CheckResult> findByDateRange2(String mid,Date begin,Date end);
    /**
     * 根据上传日期，查找指定孕妇指定项目的上传的检查结果以及异常信息
     * @param mid
     * @param checkprojectid
     * @param begin
     * @param end
     * @return
     * @author luoyc
     * @createDate 2017年10月19日 下午3:56:55
     */
    List<CheckResult> findByDateRange3(String mid,Date begin,Date end,Integer checkprojectid);
    List<Map<String, Object>> selectCheckDetailByMId(String mid,Integer checkProjectId,Integer weeks);
    
    /**
     * 根据孕周、mid 查询孕程的检查明细及检查指标
     * @param weeks 孕周
     * @param mid 孕妇ID
     * @return List<Map<String,Object>>
     * @author wanghp
     * @createDate 2018年1月3日 下午2:43:48
     */
    List<Map<String, Object>> getCheckDetailByMid(Integer weeks, String mid);
    /** 
     * @Description: 根据孕周、mid 查询孕程的检查明细及检查指标
     * @author yinzx
     * @createDate 2018年1月17日 下午5:03:49
     * @param weeks
     * @param mId
     * @return
     */
    Map<String, List<Map<String, Object>>> getCheckReportDetailByMid(Integer weeks, String mId);
}
