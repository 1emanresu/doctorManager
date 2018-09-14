package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.CheckResult;

public interface CheckResultMapper {
    int deleteByPrimaryKey(Integer checkresultid);
 
    int insert(CheckResult record);
     
    int insertSelective(CheckResult record);

    CheckResult selectByPrimaryKey(Integer checkresultid);
          
    int updateByPrimaryKeySelective(CheckResult record);

    int updateByPrimaryKey(CheckResult record);
   /**
     * 根据doctorid查找对应的检查结果
     * @param doctorid    医生ID
     * @return
     */
    CheckResult selectByDoctorId(Integer doctorid);
    /**
     * 动态根据表名查询孕妇检查结果时间
     * @param mid 孕妇ID
     * @param projectId 检查项目ID
     * @param table 动态查询表名
     * @return
     */
    List<Map<String, Object>> queryByProjectId(@Param("mid") String mid, @Param("projectId") Integer projectId, @Param("table") String table);
    
    CheckResult selectByMid(CheckResult record);
    /**
     * 查询检查明细及检查指标
     * @param weeks 孕周
     * @param checkProjectId 检查项目ID
     * @return
     */
	List<Map<String, Object>> queryCheckDetail(@Param("weeks") Integer weeks, @Param("checkProjectId") Integer checkProjectId);
	/**
     * 查询检查明细及检查指标
     * @param weeks 孕周
     * @param checkProjectId 检查项目ID
     * @param mId 孕妇ID
     * @return
     */
	List<Map<String, Object>> queryCheckDetailByMId(@Param("weeks") Integer weeks, @Param("checkProjectId") Integer checkProjectId, @Param("mId") String mId);
	/**
	 * 根据孕周、mid 查询孕程的检查明细及检查指标
	 * @param weeks
	 * @param mid
	 * @return <![CDATA[  List<Map<String,Object>>  ]]>
	 * @author wanghp
	 * @createDate 2018年1月3日 下午2:41:19
	 */
	List<Map<String,Object>> getCheckDetailByMid(@Param("weeks") Integer weeks,@Param("mid") String mid);
	/**
	 * 按项目查询： 根据检查项目id、mid、检查结果id 查询检查明细及指标  @yinzx
	 * @param checkResultId
	 * @param checkProjectId
	 * @param mId
	 * @return 检查明细及指标
	 */
	List<Map<String, Object>> queryResultByProject(@Param("checkResultId") Integer checkResultId, @Param("checkProjectId") Integer checkProjectId, @Param("mId") String mId);
	/**
	 * 根据检查项目id、mid 查询检查结果id和检查时间（按时间升序）  @yinzx
	 * @param checkProjectId
	 * @param mId
	 * @return
	 */
	List<Map<String, Object>> queryCheckResultId( @Param("checkProjectId") Integer checkProjectId, @Param("mId") String mId);
	/**
	 * 按指标名字查询： 根据检查项目id、mid、指标名字  查询该项指标的历史数据  @yinzx（按时间升序）  @yinzx
	 * @param checkProjectId
	 * @param mId
	 * @param cname
	 * @return
	 */
	List<Map<String, Object>> queryHistoByCname( @Param("checkProjectId") Integer checkProjectId, @Param("mId") String mId,@Param("cname") String cname);
	/**
	 * 根据孕妇ID，检查时间，检查项目ID查询孕妇检查记录
     * @param mid 孕妇ID
     * @param checkDate 检查时间
     * @param projectId 检查项目
	 * @return
	 */
    CheckResult queryByCheckDate(@Param("mid") String mid, @Param("checkDate") Date checkDate, @Param("projectId") Integer projectId);
    /**
     * 根据检查时间查询检查明细及检查指标
     * @param checkDate 检查时间
     * @param projectId 检查项目ID
     * @return
     */
    List<Map<String, Object>> queryCheckDetailByDate(@Param("checkDate") Date checkDate, @Param("projectId") Integer projectId);
    /**
     * 通过孕妇id查询孕妇所有b超报告的双顶径、腹围、股骨长数据
     * @author luoyc
     * @param mid
     * @return
     */
    List<Map<String, Object>> selectFetalWeightByMid(String mid);
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
     * 根据上传日期，查询指定孕妇上传的检查结果以及异常信息(1和2关联关系不一样)
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
    /*根据孕周时间查找对应时间段内最新的报告信息*/
    List<Map<String, Object>> selectCheckDetailByMId(@Param("mid") String mid,  @Param("checkProjectId") Integer checkProjectId,@Param("weeks") Integer weeks);
}