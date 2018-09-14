/**
 * @Package cn.yunji.doctormanager.service.impl
 * @createDate 2017年12月11日 下午7:20:28 
 */
package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.DoctorscheduleMapper;
import cn.yunji.doctormanager.entity.Doctorschedule;
import cn.yunji.doctormanager.service.DoctorscheduleService;

/** 
 * @ClassName DoctorscheduleServiceImpl.java
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author wangzw
 */
@Service("doctorscheduleService")
public class DoctorscheduleServiceImpl implements  DoctorscheduleService{
    @Resource
    public DoctorscheduleMapper doctorscheduleDao;
    /** (非 Javadoc) 
     * <p>Title: findAlldoctorschedule</p> 
     * <p>Description: </p> 
     * @param mindutyDate
     * @param maxdutyDate
     * @return 
     * @see cn.yunji.doctormanager.service.DoctorscheduleService#findAlldoctorschedule(java.util.Date, java.util.Date)
     * Date mindutyDate, Date maxdutyDate
     *  mindutyDate, maxdutyDate
     */
    @Override
    public List<Map<String, Object>> findAlldoctorschedule(String beginDate,String endDate,Integer offid) {
        return doctorscheduleDao.findAlldoctorschedule( beginDate, endDate, offid);
    }
    /** (非 Javadoc) 
     * <p>Title: insertSelective</p> 
     * <p>Description: </p> 
     * @param record
     * @return 
     * @see cn.yunji.doctormanager.service.DoctorscheduleService#insertSelective(cn.yunji.doctormanager.entity.Doctorschedule) 
     */
    @Override
    public int insertSelective(Doctorschedule record) {
        return doctorscheduleDao.insertSelective(record);
    }

}
