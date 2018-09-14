package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Nipt;

public interface NiptService {
	
	Nipt queryBymid(String mid);
	
	List<Map<String, Object>> queryByNewDate(String mid);
	
    List<Map<String, Object>> queryByDate(String mid);

    /**
     * 根据孕妇ID查询检查结果
     * @param mid
     * @param checkDate
     * @return
     */
	Nipt findByMid(String mid, Date checkDate);
	/**
	 * 按项目查询： 根据检查项目id、mid查询检查明细及指标 (按时间升序排序)  @yinzx
	 * @param checkProjectId 检查项目id
	 * @param mId 孕妇id
	 * @return 查询检查明细及指标  
	 */
	List<Nipt> findByMidAndProject(Integer checkProjectId, String mId);
	/**
	 * 按孕周查询： 根据检查项目id、mid、孕周 查询检查明细及指标 @yinzx
	 * @param week 孕周
	 * @param checkProjectId 检查项目id
	 * @param mId  孕妇id
	 * @return 查询检查明细及指标
	 */
	List<Nipt> findByMidAndWeek(Integer checkProjectId, String mId, Integer weeks);
}
