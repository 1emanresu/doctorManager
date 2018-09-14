package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Fetalheart;
/**
 * 胎心模块DAO
 * @author zhengpl
 *
 */
public interface FetalheartMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Fetalheart record);

    int insertSelective(Fetalheart record);

    Fetalheart selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Fetalheart record);

    int updateByPrimaryKey(Fetalheart record);
    
    /**
     * 根据孕妇ID、检查时间、孕周查询胎心结果
     * @param record
     * @return
     */
    Fetalheart search(Fetalheart record);

    /**
     * 根据孕周查询胎心检查结果
     * @param weeks
     * @return
     */
	List<Map<String, Object>> queryDescription(@Param("weeks") Integer weeks);

	/**
	 * 根据孕妇ID查询胎心结果
	 * @param mid
	 * @param checkDate
	 * @return
	 */
	Fetalheart findByMid(@Param("mid") String mid, @Param("checkDate") Date checkDate);
	/**
	 * 按项目查询： 根据检查项目id、mid查询检查明细及指标 (按时间升序排序)  @yinzx
	 * @param checkProjectId 检查项目id
	 * @param mId 孕妇id
	 * @return 查询检查明细及指标  
	 */
	List<Fetalheart> findByMidAndProject(@Param("checkProjectId")Integer checkProjectId, @Param("mId")String mId);
	/**
	 * 按孕周查询： 根据检查项目id、mid、孕周 查询检查明细及指标 @yinzx
	 * @param week 孕周
	 * @param checkProjectId 检查项目id
	 * @param mId  孕妇id
	 * @return 查询检查明细及指标
	 */
	List<Fetalheart> findByMidAndWeek(@Param("checkProjectId")Integer checkProjectId, @Param("mId")String mId, @Param("weeks")Integer weeks);
	/**
	 * 根据日期范围查询指定孕妇的胎心结果
	 * @param mid
	 * @param begin
	 * @param end
	 * @return
	 * @author luoyc
	 * @createDate 2017年10月19日 下午5:02:00
	 */
	List<Fetalheart> findByDateRange(String mid,Date begin,Date end);
}