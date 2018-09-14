package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Nipt;

public interface NiptMapper {
    int deleteByPrimaryKey(Integer nid);

	int insert(Nipt record);

	int insertSelective(Nipt record);

	Nipt selectByPrimaryKey(Integer nid);

	int updateByPrimaryKeySelective(Nipt record);

	int updateByPrimaryKey(Nipt record);

	
    
    Nipt selectByMid(String mid);
    
    List<Map<String, Object>> queryByNewDate(String mid);
    
    List<Map<String, Object>> queryByDate(String mid);

    /**
     * 根据孕妇ID查询�?��结果
     * @param mid
     * @param checkDate
     * @return
     */
	Nipt queryByMid(@Param("mid") String mid, @Param("checkDate") Date checkDate);
	/**
	 * 按项目查询： 根据检查项目id、mid查询检查明细及指标 (按时间升序排序)  @yinzx
	 * @param checkProjectId 检查项目id
	 * @param mId 孕妇id
	 * @return 查询检查明细及指标  
	 */
	List<Nipt> findByMidAndProject(@Param("checkProjectId")Integer checkProjectId, @Param("mId")String mId);
	/**
	 * 按孕周查询： 根据检查项目id、mid、孕周 查询检查明细及指标 @yinzx
	 * @param week 孕周
	 * @param checkProjectId 检查项目id
	 * @param mId  孕妇id
	 * @return 查询检查明细及指标
	 */
	List<Nipt> findByMidAndWeek(@Param("checkProjectId")Integer checkProjectId, @Param("mId")String mId, @Param("weeks")Integer weeks);
    
}