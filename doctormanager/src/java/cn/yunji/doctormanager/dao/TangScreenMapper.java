package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.TangScreen;

public interface TangScreenMapper {
    int deleteByPrimaryKey(Integer tsid);

	int insert(TangScreen record);

	int insertSelective(TangScreen record);

	TangScreen selectByPrimaryKey(Integer tsid);

	int updateByPrimaryKeySelective(TangScreen record);

	int updateByPrimaryKey(TangScreen record);

	
    /**
     * 根据孕妇ID及检查时间查询唐筛记�?
     * @param mid
     * @param checkDate
     * @return
     */
	TangScreen findByMid(@Param("mid") String mid, @Param("checkDate") Date checkDate);

	void updateByMid(TangScreen tangScreen);
	
	/**
	 * 按项目查询： 根据检查项目id、mid查询检查明细及指标 (按检查时间升序排序)  @yinzx
	 * @param checkProjectId 检查项目id
	 * @param mId 孕妇id
	 * @return 查询检查明细及指标  
	 */
	List<TangScreen> findByMidAndProject(@Param("checkProjectId")Integer checkProjectId, @Param("mId")String mId);
	/**
	 * 按孕周查询： 根据检查项目id、mid、孕周 查询检查明细及指标 @yinzx
	 * @param week 孕周
	 * @param checkProjectId 检查项目id
	 * @param mId  孕妇id
	 * @return 查询检查明细及指标
	 */
	List<TangScreen> findByMidAndWeek(@Param("checkProjectId")Integer checkProjectId, @Param("mId")String mId, @Param("weeks")Integer weeks);
}