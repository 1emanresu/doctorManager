package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Bscan;

public interface BscanService {
	
	public Bscan selectByBid(int bid);
	
	public Bscan getNewReport(String mid);
	
	public void insert(Bscan record);

	/**
	 * 获取B超描述及提示信息
	 * @param weeks
	 * @return
	 */
	public List<Map<String, Object>> queryBscanTip(Integer weeks);

	/**
	 * 根据孕妇ID查找结果
	 * @param string
	 * @return
	 */
	public Bscan findByMid(String mid);
	

	/**
	 * 根据孕妇ID与孕周查询提示
	 * @param mid
	 * @param week
	 * @return
	 */
	
	public Bscan selectTipByMidandWeek(String mid, int week);
	/**
	  * 根据孕周、mid、 检查项目id查看B超报告  yinzx
	  * @param mid
	  * @param weeks
	  * @return
	  */
	public Bscan findByMidAndWeeks(Integer weeks, Integer checkProjectId, String mId);
	/**
	 * 按项目查询：  根据检查项目、孕妇id查询明细信息(按日期升序) yinzx
	 * @param checkProjectId
	 * @param mId
	 * @return  list
	 */
	public List<Bscan> findByMidAndProject(Integer checkProjectId, String mId);
}
