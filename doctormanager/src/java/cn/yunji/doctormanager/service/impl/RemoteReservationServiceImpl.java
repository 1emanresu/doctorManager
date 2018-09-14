package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.RemoteReservationMapper;
import cn.yunji.doctormanager.service.RemoteReservationService;

@Service("remoteReservationService")
public class RemoteReservationServiceImpl implements RemoteReservationService {
	@Resource 
	private RemoteReservationMapper remoteReservationdao;

	@Override
	public List<Map<String, Object>> queryByBespeak(String sdate,String edate,String name,Date sweeks, Date eweeks,String shour,String ehour,String pendingState,Integer pageIndex,Integer pageSize) {
		return remoteReservationdao.queryByBespeak( sdate, edate, name, sweeks,  eweeks, shour, ehour,pendingState, pageIndex, pageSize);
	}

	@Override
	public int changeState(int state, String mid) {
		return remoteReservationdao.changeState(state,mid);
	}

	@Override
	public int queryByBespeakCount(String sdate,String edate,String name,Date sweeks, Date eweeks,String shour,String ehour,String pendingState) {
		return remoteReservationdao.queryByBespeakCount(sdate,edate,name, sweeks,  eweeks, shour, ehour,pendingState);
	}

	@Override
	public int updateState(Integer rrid) {
		return remoteReservationdao.updateState(rrid);
	}

	@Override
	public int updatePendingState(Integer rrid) {
		// TODO Auto-generated method stub
		return remoteReservationdao.updatePendingState(rrid);
	}
}
