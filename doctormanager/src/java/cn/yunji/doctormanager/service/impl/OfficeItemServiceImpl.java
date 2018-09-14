/**
 * @Package cn.yunji.doctormanager.service.impl
 * @createDate 2017年12月11日 下午4:12:52 
 */
package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.OfficeItemMapper;
import cn.yunji.doctormanager.entity.OfficeItem;
import cn.yunji.doctormanager.service.OfficeItemService;

/** 
 * @ClassName OfficeItemServiceImpl.java
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author wangzw
 */
@Service("officeItemService")
public class OfficeItemServiceImpl implements OfficeItemService{
    @Resource
    private OfficeItemMapper officeItemDao;

    
    /** (非 Javadoc) 
     * <p>Title: findOffAll</p> 
     * <p>Description: </p> 
     * @return 
     * @see cn.yunji.doctormanager.service.OfficeItemService#findOffAll() 
     */
    @Override
    public List<OfficeItem> findOffAll() {
        return officeItemDao.findOffAll();
    }

}
