package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.OrderDetails;

/**
 * 用一句话描述这个类的作用
 * @author zhangqt
 * @CreateDate 2017年11月16日 上午10:26:03
 */
public interface OrderDetailsService {
	public int insert(OrderDetails od);

	/** 
	 * 修改处理状态
	 * @param odid
	 * @author zhangqt
	 * @createDate 2017年11月17日 上午10:09:45
	 */
	public void updateState(Integer odid);
}
