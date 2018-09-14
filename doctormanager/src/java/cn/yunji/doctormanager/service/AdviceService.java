package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.Advice;
 
/**
  *医生反馈
  * @author  wangzw
  *
  */
public interface AdviceService {
 
	/**
	 * 添加医生反馈信息 
	 * @author  wangzw
	 * @param record 
	 * @return 1
	 */
	int insertSelective(Advice record);
}
