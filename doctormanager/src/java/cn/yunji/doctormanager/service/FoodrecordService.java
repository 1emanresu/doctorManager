/**@Title:FoodrecordService.java
 * @description
 * @author king_smm
 * @date 2017年12月1日下午2:41:16
 * @copyright(c) 2017 云济健康管理(深圳)有限公司 AllRight Reserved.
 */
package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Foodrecord;

public interface FoodrecordService {

	//根据mid插入问题的答案
	public int insertSelective(Foodrecord foodrecord);
	
}
