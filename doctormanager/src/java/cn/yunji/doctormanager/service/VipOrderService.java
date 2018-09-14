package cn.yunji.doctormanager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.vipOrder;

public interface VipOrderService {
	public int addOrder(vipOrder vipOrder);

	/**
	 * 查询开通医嘱问诊与开通周报的人数
	 * @return weekly 代表周报人数
	 * @return inquiry 代表医嘱问诊人数
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	public List<Map<String,Object>> queryServiceTypeNum();

	/**
	 * 查询本周周报处理状况
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	public List<Map<String,Object>> queryWeeklyHandleNum(String weeklast,Integer vipid);
}
