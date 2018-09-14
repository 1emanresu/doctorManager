package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.Templatetitle;
import java.util.Date;
public interface TemplatetitleService {
    

	int insertSelective(Templatetitle record);
    /**
     * 根据 孕周、检查项目、孕妇id查询明细信息 yinzx
     * @param 孕周 weeks
     * @param 检查项目 checkProjectId
     * @param 孕妇mId
     * @return
     */
	Templatetitle  queryCheckDetail(Integer weeks, Integer checkProjectId,String mId);
	
	/**
	 *  根据 检查日期、检查项目、孕妇id查询明细信息 yinzx
	 * @param checkdate
	 * @param checkProjectId
	 * @param mId
	 * @return
	 */
	Templatetitle  queryCheckDetailByDate(Date checkdate, Integer checkProjectId,String mId);


	
}