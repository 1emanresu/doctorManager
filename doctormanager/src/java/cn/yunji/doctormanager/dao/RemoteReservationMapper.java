package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.RemoteReservation;

public interface RemoteReservationMapper {
	int deleteByPrimaryKey(Integer rrid);

	int insert(RemoteReservation record);

	int insertSelective(RemoteReservation record);

	RemoteReservation selectByPrimaryKey(Integer rrid);

	int updateByPrimaryKeySelective(RemoteReservation record);

	int updateByPrimaryKey(RemoteReservation record);

	List<Map<String, Object>> queryByBespeak(@Param("sdate") String sdate, @Param("edate") String edate,
			@Param("name") String name, @Param("sweeks") Date sweeks, @Param("eweeks") Date eweeks, @Param("shour")String shour,@Param("ehour")String ehour,@Param("pendingState") String pendingState, @Param("pageIndex") Integer pageIndex,
			@Param("pageSize") Integer pageSize);

	int changeState(int inquiryState, String mid);

	int queryByBespeakCount(@Param("sdate") String sdate, @Param("edate") String edate, @Param("name") String name, @Param("sweeks") Date sweeks, @Param("eweeks") Date eweeks, @Param("shour")String shour,@Param("ehour")String ehour,@Param("pendingState") String pendingState);

	/** 
	 * 用一句话描述该方法做什么
	 * @param rrid
	 * @return
	 * @author zhangqt
	 * @createDate 2017年11月17日 下午2:19:06
	 */
	int updateState(Integer rrid);

	/** 
	 * 用一句话描述该方法做什么
	 * @param rrid
	 * @return
	 * @author oumh
	 * @createDate 2018年1月24日 下午3:44:50
	 */
	int updatePendingState(Integer rrid);
}