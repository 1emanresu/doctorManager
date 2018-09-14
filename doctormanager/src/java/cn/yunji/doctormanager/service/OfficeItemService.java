/**
 * @Package cn.yunji.doctormanager.service
 * @createDate 2017年12月11日 下午4:11:29 
 */
package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.OfficeItem;

/** 
 * @ClassName OfficeItemService.java
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author wangzw
 */
public interface OfficeItemService {
    /**
     * 查询全部的科室子列表
     * @Description: TODO(用一句话描述该方法做什么) 
     * @return
     * @author wangzw
     */
    List<OfficeItem> findOffAll();
}
