package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;
/**
 * 预约
 * @author Wangzw
 *
 */
public interface SubscribeService {
	/** 
     * 预约数量
     * @author Wangzw
     * @return 预约数量
     */
    int queryCount();
    /**
     * 产检管理
     *  @author Wangzw
     * @param did
     * @return 产检管理
     */
    List<Map<String, Object>>   queryBySubId(int did);
}
