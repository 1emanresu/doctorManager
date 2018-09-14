package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;
/**
 * 
 * @author wangzw
 * 我的积分信息
 */
public interface MyIntegralMapper {
	/**
	 * @author wangzw 
	 * @param did 医生编号
	 * @return 返回我的积分信息
	 */
	 List<Map<String, Object>>  queryMyIntegral(int did);
	 /**
		 * @author wangzw 
		 * @param did 医生编号
		 * @return 统计积分
		 */
	 int countIntegral(int did);
	 /**
		 * @author wangzw 
		 * @param did 医生编号
		 * @return 统计兑换积分
		 */
	 int countConversionIntegral(int did);
}