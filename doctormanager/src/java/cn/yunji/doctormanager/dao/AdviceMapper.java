package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.Advice;
 

/**
 *医生反馈 
 * @author  wangzw
 *
 */
public interface AdviceMapper {

	 

	/**
	 * 添加医生反馈信息 
	 * @author  wangzw
	 * @param record 
	 * @return 1
	 */  
	int insertSelective(Advice record);
}