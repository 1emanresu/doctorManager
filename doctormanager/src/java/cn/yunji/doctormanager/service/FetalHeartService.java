package cn.yunji.doctormanager.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.FetalException;
import cn.yunji.doctormanager.entity.Fetalheart;

public interface FetalHeartService {
	
	public Fetalheart search(Fetalheart fetalheart);

	/**
	 * 根据孕周查询胎心检查结果
	 * @param weeks
	 * @return
	 */
	public List<Map<String, Object>> queryDescription(Integer weeks);

	/**
	 * 根据孕妇ID查询胎心结果
	 * @param mid
	 * @param checkDate
	 * @return
	 */
	public Fetalheart findByMid(String mid, Date checkDate);
	/**
	 * 按项目查询： 根据检查项目id、mid查询检查明细及指标 (按时间升序排序)  @yinzx
	 * @param checkProjectId 检查项目id
	 * @param mId 孕妇id
	 * @return 查询检查明细及指标  
	 */
	public List<Fetalheart> findByMidAndProject(Integer checkProjectId, String mId);
	/**
	 * 按孕周查询： 根据检查项目id、mid、孕周 查询检查明细及指标 @yinzx
	 * @param week 孕周
	 * @param checkProjectId 检查项目id
	 * @param mId  孕妇id
	 * @return 查询检查明细及指标
	 */
	public List<Fetalheart> findByMidAndWeek(Integer checkProjectId, String mId, Integer weeks);
	/**
	 * 根据宫缩曲线的 索引列表，纵坐标列表，得到宫缩曲线的分析结果信息
	 * @param xlist 索引列表
	 * @param ylist 纵坐标列表
	 * @param t 表示1秒  t个点
	 * @return
	 * @throws ParseException
	 */
	public List<FetalException> analysisUC(List<Integer> xlist, List<Integer> ucList, int t) throws ParseException;
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
