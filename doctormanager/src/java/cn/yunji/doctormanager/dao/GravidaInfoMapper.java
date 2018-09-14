package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.GravidaInfo;

public interface GravidaInfoMapper {
	int deleteByPrimaryKey(String mid);

	int insert(GravidaInfo record);

	int insertSelective(GravidaInfo record);

	GravidaInfo selectByPrimaryKey(String mid);

	// 根据对应用户编号查出对应孕妇
	GravidaInfo selectByPrimaryKey2(Integer userid);

	int updateByPrimaryKeySelective(GravidaInfo record);

	int updateByPrimaryKey(GravidaInfo record);

	// 查询孕妇基本信息
	public GravidaInfo find(String mid);

	List<GravidaInfo> findAll(); 

	/**
	 * @author wangzw
	 * @param patientTypeId
	 *            患者id号 processingState 是否处理过
	 * @return 查询孕妇信息
	 */
	List<Map<String, Object>> findGravidainfoAll(int patientTypeId, int processingState);

	/**
	 * @author wangzw
	 * @param mid孕妇
	 * @return 查询全部孕妇信息
	 */
	List<Map<String, Object>> selectGravidainfoAll(String mid);

	/**
	 * @author wangzw3
	 * @param mid孕妇
	 * @return 查询男方血型
	 */
	Map<String, Object> queryManBlood(String mid);

	/**
	 * @author wangzw
	 * @param mid孕妇
	 *            关系relationId
	 * @return 查询个人史
	 */
	Map<String, Object> queryPersonage(int relationId, String mid);

	/**
	 * @author wangzw
	 * @param mid孕妇
	 * @return 查询孕妇的症状
	 */
	List<Map<String, Object>> querySymptom(String mid, Date begin, Date end);

	/**
	 * 更新病人类型id
	 * 
	 * @author luoyc
	 * @param record
	 */
	void updatePatientTypeId(GravidaInfo record);

	/**
	 * 更新处理状态
	 * 
	 * @author luoyc
	 * @param record
	 */
	void updateProcessingState(GravidaInfo record);

	/**
	 * @author wangzw 查询用户
	 * @return findPagingAll
	 */
	List<Map<String, Object>> findPagingAll(int patientTypeId, int processingState, int pageNo, int pageSize);

	/**
	 * @author wangzw 查询孕妇的数量
	 * @param patientTypeId
	 * @param processingState
	 * @return countAll
	 */
	int countAll(int patientTypeId);

	Map<String, Object> findByMid(String mid);

	List<Map<String, Object>> queryByVip(@Param("gname") String gname,@Param("medicalrecordno") String medicalrecordno,
			@Param("vipGradeid") Integer vipGrade,@Param("sweeks") Date sweeks,@Param("eweeks") Date eweeks,@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize,@Param("cur") Date cur);

	public int updateGravida(GravidaInfo gravidainfo);

	int addOrUpdateInfo(GravidaInfo gravidainfo);

	String getMid(String phone);

	List<Map<String, Object>> findAllList();

	List<Map<String, Object>> findByPage(@Param("gname") String gname,@Param("sbirth") String sbirth,@Param("ebirth") String ebirth,@Param("medicalrecordno") String medicalrecordno, @Param("vipGrade") Integer vipGrade,
			@Param("sweeks") Date sweeks, @Param("eweeks") Date eweeks, @Param("doctor") Integer doctor,@Param("pageIndex")Integer pageIndex,
			@Param("pageSize")Integer pageSize,@Param("sortName")String sortName,@Param("sortOrder")String sortOrder,
			@Param("patientTypeId") String patientTypeId,@Param("adviceState")String adviceState,@Param("weeklyState")String weeklyState,@Param("processingState") String processingState,@Param("edate") String edate,@Param("serviceType") String serviceType);

	int getPregnancyCount1();

	int getPregnancyCount2(); 

	int getDateCount1(@Param("gname") String gname,@Param("sbirth") String sbirth,@Param("ebirth") String ebirth,@Param("medicalrecordno") String medicalrecordno, @Param("vipGrade") Integer vipGrade,
			@Param("sweeks") Date sweeks, @Param("eweeks") Date eweeks, @Param("doctor") Integer doctor,
			@Param("patientTypeId") String patientTypeId,@Param("adviceState")String adviceState,
			@Param("weeklyState")String weeklyState,@Param("processingState") String processingState,@Param("edate")String edate,@Param("serviceType") String serviceType);

	String queryByUserPhone(String phone);

	/** 
	 * 用于审核建档
	 * @param mid孕妇id
	 * @param did审核医生id
	 * @author zhangqt
	 * @createDate 2017年10月26日 下午5:17:02
	 */
	int examineInfo(String mid, Integer did);
	
	int getVipCount(@Param("gname") String gname,@Param("medicalrecordno") String medicalrecordno,@Param("vipGradeid") Integer vipGrade,
			@Param("sweeks") Date sweeks,@Param("eweeks") Date eweeks,@Param("cur") Date cur);
}










