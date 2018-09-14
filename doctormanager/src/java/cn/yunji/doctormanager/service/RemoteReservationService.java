package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RemoteReservationService {
	public List<Map<String,Object>> queryByBespeak(String sdate,String edate,String name,Date sweeks, Date eweeks,String shour,String ehour,String pendingState,Integer pageIndex,Integer pageSize);

	public int changeState(int state, String mid);

	public int queryByBespeakCount(String sdate,String edate,String name,Date sweeks, Date eweeks,String shour,String ehour,String pendingState);
	
	public int updateState(Integer rrid);

	/** 
	 * 用一句话描述该方法做什么
	 * @param rrid
	 * @author oumh
	 * @createDate 2018年1月24日 下午3:41:39
	 */
	public int updatePendingState(Integer rrid);
}
