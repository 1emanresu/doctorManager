package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Electrocardio;

public interface ElectrocardioService {
	//以孕妇id 与检查的时间查询心电检查的结果
	public Electrocardio queryByMid(String mid, Date checkDate);
	//添加心电检查
	public int addEcg(Electrocardio e);
	
	/**
	 * 根据孕周查询心电描述及提示
	 * @param weeks
	 * @return
	 */
	public List<Map<String, Object>> queryElectrocardioTip(Integer weeks);
	
	/**
	 * 根据用户ID查询心电信息
	 * @param mid
	 * @param checkDate
	 * @return
	 */
	public Electrocardio findByMid(String mid, Date checkDate);
	/**
	  * 根据孕周、mid、 检查项目id查看B超报告  yinzx
	  * @param mid
	  * @param weeks
	  * @return
	  */
	public Electrocardio findByMidAndWeeks(Integer weeks, Integer checkProjectId, String mId);

	/**
	 *  根据检查项目、孕妇id查询明细信息(按日期升序) yinzx
	 * @param checkProjectId
	 * @param mId
	 * @return  list
	 */
	public List<Electrocardio> findByMidAndProject(Integer checkProjectId, String mId);
}
