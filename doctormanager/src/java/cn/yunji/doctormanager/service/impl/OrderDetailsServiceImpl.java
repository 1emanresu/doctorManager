package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.OrderDetailsMapper;
import cn.yunji.doctormanager.entity.OrderDetails;
import cn.yunji.doctormanager.service.OrderDetailsService;

/**
 * 套餐明细
 * @author zhangqt
 * @CreateDate 2017年11月16日 上午10:26:55
 */
@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Resource
	private OrderDetailsMapper orderDetailsDao;
	@Override
	public int insert(OrderDetails od) {
		return orderDetailsDao.insert(od);
	}
	@Override
	public void updateState(Integer odid) {
		orderDetailsDao.updateState(odid);
	}

}
