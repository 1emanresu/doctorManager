package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.OrderDetails;

public interface OrderDetailsMapper {
    int deleteByPrimaryKey(Integer odid);

    int insert(OrderDetails record);

    int insertSelective(OrderDetails record);

    OrderDetails selectByPrimaryKey(Integer odid);

    int updateByPrimaryKeySelective(OrderDetails record);

    int updateByPrimaryKey(OrderDetails record);

	/** 
	 * 修改处理状态
	 * @param odid
	 * @author zhangqt
	 * @createDate 2017年11月17日 上午10:10:32
	 */
	void updateState(Integer odid);
}