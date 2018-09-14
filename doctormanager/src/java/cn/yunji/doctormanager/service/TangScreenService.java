package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.TangScreen;

public interface TangScreenService {

    /**
     * 根据孕妇ID及检查时间查询唐筛记录
     * @param mid
     * @param checkDate
     * @return
     */
	public TangScreen findByMid(String mid, Date checkDate);
	//增加
	public int addTangScreen(TangScreen TangScreen);
	//根据主键更新
	public int update(TangScreen TangScreen);
	//根据Mid更新
	public void updateByMid(TangScreen TangScreen);
	/**
	 * 按项目查询： 根据检查项目id、mid查询检查明细及指标 (按时间升序排序)  @yinzx
	 * @param checkProjectId 检查项目id
	 * @param mId 孕妇id
	 * @return 查询检查明细及指标  
	 */
	public List<TangScreen> findByMidAndProject(Integer checkProjectId, String mId);
	/**
	 * 按孕周查询： 根据检查项目id、mid、孕周 查询检查明细及指标 @yinzx
	 * @param week 孕周
	 * @param checkProjectId 检查项目id
	 * @param mId  孕妇id
	 * @return 查询检查明细及指标
	 */
	public List<TangScreen> findByMidAndWeek(Integer checkProjectId, String mId, Integer week);

	
	
	
}
