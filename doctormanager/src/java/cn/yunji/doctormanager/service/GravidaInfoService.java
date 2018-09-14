package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import cn.yunji.doctormanager.entity.GravidaInfo;

public interface GravidaInfoService {
	//添加孕妇信息
	public int addGravidainfo(GravidaInfo gravidainfo);
	//更新孕妇基本信息
	public int updateGravidainfo(GravidaInfo gravidainfo);
	//查询孕妇基本信息
	public GravidaInfo find(String mid);
	// 根据对应用户编号查出对应孕妇
	GravidaInfo selectByPrimaryKey2(Integer userid);
	public List<GravidaInfo> findAll();
    /**
     * @author wangzw
     * @param patientTypeId 患者id号 processingState 是否处理过
     * @return 查询孕妇信息
     */
    List<Map<String,Object>> findGravidainfoAll(int patientTypeId,int processingState);
    /** 
     * @author wangzw
     * @param mid孕妇
     * @return 查询全部孕妇信息
     */
    List<Map<String,Object>> selectGravidainfoAll(String mid);
    /** 
     * @author wangzw
     * @param mid孕妇
     * @return 查询男方血型
     */
    Map<String,Object> queryManBlood(String mid);
    /**
     * @author wangzw
     * @param mid孕妇
     * @return	查询个人史
     */
    Map<String,Object> queryPersonage(int relationId,String mid);
    /**
     * @author wangzw
     * @param mid孕妇
     * @return	查询孕妇的症状
     */
    List<Map<String,Object>> querySymptom(String mid,Date begin,Date end);
    /**
     * 更新病人类型id
     * @author luoyc
     * @param record
     */
    void updatePatientTypeId(GravidaInfo record);
    /**
     * 更新处理状态
     * @author luoyc
     * @param record
     */
    void updateProcessingState(GravidaInfo record);
    /**
     * @author wangzw
     * 查询用户
     * @return findPagingAll
     */
    List<Map<String,Object>> findPagingAll(int patientTypeId,int processingStateint,int pageNo,int pageSize );
    /**
     * @author wangzw
     * 查询孕妇的数量
     * @param patientTypeId
     * @param processingState
     * @return countAll
     */
    int countAll(int patientTypeId);
    
    /**
     * @author zhangqt
     * 查询孕妇的信息
     * @param mid
     * @return GravidaInfo
     */
	public Map<String,Object> findByMid(String mid);
	
	 /**
     * @author zhangqt
     * 查询vip孕妇的信息
     * @return Map--GravidaInfo
     */
	public List<Map<String, Object>> queryByVip(String gname, String medicalrecordno, Integer vipGrade, Date sweeks, Date eweeks, Integer pageIndex, Integer pageSize,Date cur);
	
	/**
	 * 修改孕妇档案的信息
	 */
	public int updateGra(String mid,String gname,String hospitalid,String bhospitalid,
			String monthpresidenceaddress,
			String monthpresentaddress,Integer medicalcardtype,@DateTimeFormat(pattern="yyyy-MM-dd") Date expectedconfinement,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date recorddate,String recordno,Integer registertype,Integer attribution,Integer doctor,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date enddate,@DateTimeFormat(pattern="yyyy-MM-dd")Date birthYears,
			String distance,Integer husband_condition,Integer poor,Integer family_gdp, Integer postalcode, Integer household_register,
			Integer town, String domicile, String wedlock, Integer marry_age, Integer inoculation_history,String medical_insurance, String agricultural);
	public int addOrUpdateInfo(GravidaInfo gravidainfo);
	public String getMid(String phone);
	
	/**
     * @author zhangqt
     * 根据条件获取孕妇列表
     * @param vidgradeid VIP等级编号
     * @param doctor 医生编号
     * @param sweeks 开始孕周
     * @param eweeks 结束孕周
     * @param pageIndex
     * @param pageSize
     * @return List
     */
	public List<Map<String, Object>> findByPage(String gname,String sbirth,String ebirth,String medicalrecordno, Integer vipGrade,
			 Date sweeks, Date eweeks, Integer doctor,Integer pageIndex,Integer pageSize,String sortName,String sortOrder,String patientTypeId,String adviceState,String weeklyState,String processingState,String edate, String serviceType);
	
	/**
     * @author zhangqt
     * 获取备孕孕妇未受孕列表
     * @param vidgradeid VIP等级编号
     * @return findabnormitylist
     */
	public int getPregnancyCount1();
	/**
     * @author zhangqt
     * 获取备孕孕妇已备孕列表
     * @return findabnormitylist
     */
	public int getPregnancyCount2();
	/*public List<Map<String, Object>> findAllList();*/
	
	/**
     * @author zhangqt
     * 获取已备孕列表总数
     * @return findabnormitylist
     */
	public int getDateCount1(String gname,String sbirth,String ebirth,String medicalrecordno, Integer vipGrade, Date begin, Date end,
			Integer doctor,String patientTypeId,String adviceState,String weeklyState,String processingState,String edate, String serviceType);
	
	public int getVipCount(String gname, String medicalrecordno, Integer vipGrade, Date begin, Date end, Date cur);
	
	public String queryByUserPhone(String phone);
	/** 
	 * 用于审核建档
	 * @param mid孕妇id
	 * @param did审核医生id
	 * @author zhangqt
	 * @createDate 2017年10月26日 下午5:15:38
	 */
	public int examineInfo(String mid, Integer did);
}
