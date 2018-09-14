package cn.yunji.doctormanager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.RemoteReservation;
import cn.yunji.doctormanager.service.Antenatal_ItemService;
import cn.yunji.doctormanager.service.RemoteReservationService;

@Controller
@RequestMapping("/remoteReservation")
public class RemoteReservationController {
	@Resource
	private RemoteReservationService remoteReservationService;
	@Resource
    private Antenatal_ItemService antenatal_ItemService;

	/**
	 * 查询当天预约挂号的孕妇
	 * @return map
	 * @author zhangqt
	 */
	@RequestMapping("/queryByBespeak.do")
	@ResponseBody
	public Map queryByBespeak(String sdate,String edate,String name,String sweeks, String eweeks,String shour,String ehour,String pendingState,Integer pageIndex,Integer pageSize) {
		Date expectedconfinement = new Date();
		Long expected = expectedconfinement.getTime();
		Date end = null;
		Date begin = null;
		if (sweeks != null) {
			//七天的long值
			Long SEVEN_DAY = 7 * 24 * 60 * 60 * 1000L;
			begin = new Date(expected - SEVEN_DAY * (Integer.parseInt(eweeks)));
			end = new Date(expected - SEVEN_DAY * (Integer.parseInt(sweeks)));
		}
		Map map=new HashMap();
		List<Map<String,Object>> r=remoteReservationService.queryByBespeak(sdate,edate,name,begin,end, shour, ehour,pendingState,pageIndex,pageSize);
		int total=remoteReservationService.queryByBespeakCount(sdate,edate,name,begin,end, shour, ehour,pendingState);
		map.put("rows", r);
		map.put("total", total);
		return map;
	}
    @RequestMapping("/queryCheckReportNeeded.do")
    @ResponseBody
    public List<Map<String,Object>> queryCheckReportNeeded(Integer week) {
        return antenatal_ItemService.queryByWeeks(week);
    }	
    /**
	 * 更新处理状态为已处理
	 * @return int
	 * @author zhangqt
	 */
    @RequestMapping("/updateState.do")
    @ResponseBody
    public int updateState(Integer rrid) {
        return remoteReservationService.updateState(rrid);
    }	
}
