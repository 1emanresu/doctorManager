package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.DoctorAdvice;

public interface DoctorAdviceService {
	public int addDoctorAdvice(DoctorAdvice doctorAdvice);
	List<DoctorAdvice> queryByMid(String mid);
    /**
     * @author luoyc 
     * @param doctorAdvice
     * @return
     * 插入医生建议并返回主键
     */
    Integer insertDoctorAdvice(DoctorAdvice doctorAdvice);
    /**
     * 根据日期范围查询指定孕妇的医嘱 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<DoctorAdvice> findByDateRange(String mid,Date begin,Date end);
	/** 
	 * 用一句话描述该方法做什么
	 * @param mid
	 * @param keyword
	 * @return
	 * @author zhangqt
	 * @createDate 2017年11月9日 下午1:54:09
	 */
	public List<DoctorAdvice> findByMid(String mid, String keyword,String sdate,String edate,Integer pageIndex,Integer pageSize);
}
