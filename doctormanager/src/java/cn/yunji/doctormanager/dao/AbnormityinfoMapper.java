package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import cn.yunji.doctormanager.entity.Abnormityinfo;

public interface AbnormityinfoMapper {
	int deleteByPrimaryKey(Integer abnormityid);

	int insert(Abnormityinfo record);

	int insertSelective(Abnormityinfo record);

	Abnormityinfo selectByPrimaryKey(Integer abnormityid);

	Abnormityinfo selectByPrimaryKey2(String mid);

	int updateByPrimaryKeySelective(Abnormityinfo record);

	int updateByPrimaryKey(Abnormityinfo record);

	Abnormityinfo queryByMid(@Param("mid") String mid, @Param("checkDate") Date checkDate, @Param("cid") int cid);

	List<Map<String, Object>> queryByCheckProjectId(@Param("mid") String mid, @Param("checkdate") Date checkdate,
			@Param("checkProjectId") Integer checkProjectId);

	List<Map<String, Object>> queryByDate(Map<String, Object> map);

	List<Map<String, Object>> queryByWeeks(Map<String, Object> map);
	/**
	 * 按孕周查询查询孕妇的所有异常并给出相应的医嘱和判断标准
	 * @author luoyc
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> findByWeeks(Map<String, Object> map);
	/**
	 * @methodName queryByAll @description: 所有高危患者 @return
	 * List<Map<String,Object>> @throws
	 */
	List<Map<String, Object>> queryByAll();

	/**
	 * @methodName queryByDate @description:查询孕妇 腹围，B超，血糖，血压 ，体重，胎心 @param
	 * mid @return List<Map<String,Object>> @throws
	 */
	Map<String, Object> queryByAllDate(String mid);

	/**
	 * @methodName queryByWCheckDate @description:查询体重 @param CheckDate @return
	 * List<Map<String,Object>> @throws
	 */
	List<Map<String, Object>> queryByWCheckDate(String mid);

	/**
	 * @methodName queryByCCheckDate @description:查询胎动 @param CheckDate @return
	 * List<Map<String,Object>> @throws
	 */
	List<Map<String, Object>> queryByCCheckDate(String mid);

	/**
	 * @methodName queryByCids @description:查询异常信息 @param cids @return
	 * List<Map<String,Object>> @throws
	 */
	List<Map<String, Object>> queryByCids(int... cids);

	/**
	 * @methodName querybyCidHightTypeId @description:查询知识库 @param cid @param
	 * hightTypeId @return Map<String,Object> @throws
	 */
	Map<String, Object> querybyCidHightTypeId(int cid, int hightTypeId);

	/**
	 * @author wangzw
	 * @methodName findShouAll 查询所有收缩压的信息
	 * @param 检查指标的id 和孕妇id
	 * @return Map<String,Object>
	 */
	List<Map<String, Object>>  findShouAll(int cid,String mid);
	/**
	 * @author wangzw
	 * @methodName findByMid 查询所有异常的信息
	 * @param  孕妇id
	 * @return Map<String,Object>
	 */
	List<Map<String, Object>> findByMid(String mid);
	/**
     * 根据结果Id查询异常 
     * @author luoyc
     * @param resultId
     * @return
     */
    List<Abnormityinfo> findByResultId(Integer resultId);
	/**
     * 根据日期范围查询指定孕妇异常信息 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Abnormityinfo> findByDateRange(String mid,Date begin,Date end);
	/**
     * 根据日期范围查询指定孕妇异常信息 
     * @author luoyc
     * @param mid
     * @param cpid
     * @param begin
     * @param end
     * @return
     */
    List<Abnormityinfo> findByCpidAndMid(String mid,Integer cpid,Date begin,Date end); 
	/**
	 * @author wuwj
	 * @methodName findrisk 查询风险因子
	 * @param  孕妇id
	 * @return Map<String,Object>
	 */
	List<Map<String, Object>> findrisk(String mid);

	List<Abnormityinfo> queryByMidAll(String mid);
	/**
	 * 查询医嘱管理患者列表
	 * @author yinzx
	 * @param patientTypeId 患者类型编号
	 * @param adviceState 医嘱管理状态
     * @param pageNo
     * @param pageSize
	 * @return
	 */
	List<Map<String, Object>> findPatientList(@Param("medicalNo")String medicalNo,@Param("sweeks") Date sweeks,@Param("eweeks") Date eweeks,
	        @Param("highTypeId")Integer highTypeId, @Param("doctor")Integer doctor, @Param("vipgradeid")Integer vipgradeid,@Param("patienttypeid")Integer patientTypeId,
	        @Param("adviceState")Integer adviceState,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
	/**
     * 查询医嘱管理患者列表
     * @author yinzx
     * @param patientTypeId 患者类型编号
     * @param weeklyState 周报管理状态
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> findWeeklyList(@Param("medicalNo")String medicalNo,@Param("sweeks") Date sweeks,@Param("eweeks") Date eweeks
            ,@Param("highTypeId")Integer highTypeId, @Param("doctor")Integer doctor, @Param("vipgradeid")Integer vipgradeid, @Param("patienttypeid")Integer patientTypeId,
            @Param("weeklyState")Integer weeklyState,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);

	/**
	 * 按mid查询异常指标项
	 * @author yinzx
	 * @param mid
	 * @return
	 */
	List<Map<String, Object>> findCidByMid(String mid);
	
	Integer findScoreByCid(@Param("mid")String mid, @Param("cid") Integer cid,@Param("resultid") Integer resultid);
	/**
     * 获取医嘱管理  患者的总数量
	 * @param adviceState 
	 * @param patienttypeid 
	 * @param doctor 
	 * @param vipgradeid 
     * @return
     */
    int getListCount1(@Param("medicalNo")String medicalNo,@Param("sweeks") Date sweeks,@Param("eweeks") Date eweeks,
            @Param("highTypeId")Integer highTypeId, @Param("doctor")Integer doctor, @Param("vipgradeid")Integer vipgradeid,@Param("patienttypeid")Integer patientTypeId,
            @Param("adviceState")Integer adviceState);
    /**
     * 获取周报管理  患者的总数量
     * @return
     */
    int getListCount2(@Param("vipgradeid")Integer vipgradeid,@Param("doctor")Integer doctor, @Param("patienttypeid")Integer patientTypeId,@Param("weeklyState")Integer weeklyState);
    
    List<Abnormityinfo> selectByWeeks(@Param("mid")String mid,@Param("begintime")String begintime,@Param("endtime")String endtime);
    /**
     * 
     * 根据时间范围获取异常条数
     * @param mid
     * @param begin
     * @param end
     * @return
     * @author luoyc
     * @createDate 2017年11月18日 下午3:06:38
     */
    List<Map> findByDateRangeCount(String mid,Date begin,Date end);
}