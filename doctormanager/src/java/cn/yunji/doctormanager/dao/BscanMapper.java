package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Bscan;

public interface BscanMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Bscan record);

    int insertSelective(Bscan record);

    Bscan selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Bscan record);

    int updateByPrimaryKey(Bscan record);
    
    Bscan selectNewReport(String mid);

    /**
     * 获取B超描述及提示信息
     * @param weeks
     * @return
     */
	List<Map<String, Object>> queryBscanTip(@Param("week") Integer weeks);

	/**
	 * 根据孕妇ID查询结果
	 * @param mid
	 * @return
	 */
	Bscan findByMid(@Param("mid") String mid);

	/**
	 * 根据孕妇ID与孕周查询提示--wuwj
	 * @param mid
	 * @param week
	 * @return
	 */
	
	Bscan selectTipByMidandWeek(@Param("mid") String mid, @Param("week") Integer week);
	/**
	  * 根据孕周、mid、 检查项目id查看B超报告  yinzx
	  * @param mid
	  * @param weeks
	  * @return
	  */
	Bscan findByMidAndWeeks(@Param("weeks")Integer weeks,@Param("checkProjectId") Integer checkProjectId, @Param("mId")String mId);
	/**
	 * 按项目查询：  根据检查项目、孕妇id查询明细信息(按日期升序) yinzx
	 * @param checkProjectId
	 * @param mId
	 * @return  list
	 */
	List<Bscan> findByMidAndProject(@Param("checkProjectId")Integer checkProjectId, @Param("mId") String mId);
}