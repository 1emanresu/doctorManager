package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Abnormityinfo;
import cn.yunji.doctormanager.entity.Fundalheight;

public interface AbnormityinfoService {

	/**
	 * 根据孕妇id，检查时间，检查项目ID查询异常信息及相关医嘱
	 * @param mid				孕妇id
	 * @param checkdate			检查时间
	 * @param checkProjectId	检查项目ID
	 * @return 异常信息及相关医嘱
	 */
	List<Map<String, Object>> queryByCheckProjectId(String mid, Date checkdate, Integer checkProjectId);
	
	Abnormityinfo queryByMid(String mid, Date checkDate,int cid);
	
	public int addAbnormityinfo(Abnormityinfo abnormityinfo);

	List<Map<String, Object>> queryByDate(Map<String,Object> map);
	
	List<Map<String, Object>> queryByWeeks(Map<String,Object> map);
	
	/**
	 * @methodName queryByAll
	 * @description:查询所有高危患者 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String,Object>> queryByAll();
	
	/**
	 * @methodName queryByDate
	 * @description:查询孕妇  腹围，B超，血糖，血压 ，体重，胎心
	 * @param mid
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String,Object> queryByAllDate(String mid);
	/**
	 * @methodName queryByWCheckDate
	 * @description:查询体重
	 * @param CheckDate
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String,Object>> queryByWCheckDate(String mid);
	/**
	 * @methodName queryByCCheckDate
	 * @description:查询胎动 
	 * @param CheckDate
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String,Object>> queryByCCheckDate(String mid);
	/**
	 * @methodName queryByCids
	 * @description:查询异常信息 
	 * @param cids
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String,Object>> queryByCids(int...cids);
	/**
	 * @methodName querybyCidHightTypeId
	 * @description:查询知识库 
	 * @param cid
	 * @param hightTypeId
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String,Object> querybyCidHightTypeId(int cid,int hightTypeId );
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
	 * 按孕周查询查询孕妇的所有异常并给出相应的医嘱和判断标准
	 * @author luoyc
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> findByWeeks(Map<String, Object> map);
	/**
     * 根据日期范围查询指定孕妇宫高数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Abnormityinfo> findByDateRange(String mid,Date begin,Date end);
	/**
	 * @author wuwj
	 * @methodName findrisk 查询风险因子
	 * @param  孕妇id
	 * @return Map<String,Object>
	 */
	List<Map<String, Object>> findrisk(String mid);
	/**
     * 根据日期范围查询指定孕妇异常信息 
     * @author luoyc
     * @param mid
     * @param cid
     * @param begin
     * @param end
     * @return
     */
    List<Abnormityinfo> findByCpidAndMid(String mid,Integer cpid,Date begin,Date end);

	List<Abnormityinfo> queryByMidAll(String mid); 
	
	/**
     * 查询医嘱管理患者列表
     * @author yinzx
	 * @param medicalNo 病历号
     * @param sweeks 起始孕周
     * @param eweeks 结束孕周
     * @param highTypeId 高危类型id
     * @param doctor 医生编号
     * @param vipgradeid vip类型
     * @param patientTypeId 患者类型编号
     * @param adviceState 医嘱管理状态
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> findPatientList(String medicalNo, Date sweeks, Date eweeks,Integer highTypeId, Integer doctor,Integer vipgradeid,
            Integer patientTypeId,Integer adviceState,Integer pageNo,Integer pageSize );
    /**
     * 查询周报管理患者列表
     * @author yinzx
     * @param medicalNo 病历号
     * @param sweeks 起始孕周
     * @param eweeks 结束孕周
     * @param highTypeId 高危类型id
     * @param doctor 医生编号
     * @param vipgradeid vip类型
     * @param patientTypeId 患者类型编号
     * @param weeklyState 周报管理状态
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> findWeeklyList(String medicalNo, Date sweeks, Date eweeks,Integer highTypeId,
            Integer doctor,Integer vipgradeid,Integer patientTypeId,Integer weeklyState,Integer pageNo,Integer pageSize);
    
    
    /**
     * 按mid查询异常指标项
     * @param mid
     * @return
     */
    List<Map<String, Object>> findCidByMid(String mid);
    /**
     * 获取医嘱管理 患者的总数量
     * @param vipgradeid   服务等级
     * @param doctor   医生编号
     * @param patienttypeid 高危编号
     * @param adviceState  处理状态
     * @return
     */
    int getListCount1(String medicalNo, Date sweeks, Date eweeks,Integer highTypeId, Integer doctor,Integer vipgradeid,
            Integer patientTypeId,Integer adviceState);
    /**
     * 获取周报管理 患者的总数量
     * @param vipgradeid   服务等级
     * @param doctor   医生编号
     * @param patienttypeid 高危编号
     * @param weeklyState  处理状态
     * @return
     */
    int getListCount2(Integer vipgradeid, Integer doctor, Integer patienttypeid, Integer weeklyState);
    /**
     * 根据结果Id查询异常 
     * @author luoyc
     * @param resultId
     * @return
     */
    List<Abnormityinfo> findByResultId(Integer resultId);
    
    List<Abnormityinfo> selectByWeeks(String mid,String begintime,String endtime);
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
