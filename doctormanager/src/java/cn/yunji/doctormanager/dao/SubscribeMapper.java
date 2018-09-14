package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Subscribe;
/**
 * 
 * @author Wangzw
 * 预约
 */
public interface SubscribeMapper {
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