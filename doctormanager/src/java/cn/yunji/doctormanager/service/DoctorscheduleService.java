/**
 * @Package cn.yunji.doctormanager.service
 * @createDate 2017年12月11日 下午7:20:20 
 */
package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Doctorschedule;

/** 
 * @ClassName DoctorscheduleService.java
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author wangzw
 */
public interface DoctorscheduleService {
    /**
     * 查询本周医生排班的信息
     * @Description: TODO(用一句话描述该方法做什么) 
     * @param mindutyDate
     * @param maxdutyDate
     * @return
     * @author wangzw
     * Date mindutyDate,Date maxdutyDate
     */
    List<Map<String, Object>> findAlldoctorschedule(String beginDate,String endDate,Integer offid);
    /**
     * 
     * @Description: TODO(用一句话描述该方法做什么) 
     * @param record
     * @return
     * @author wangzw
     */
    int insertSelective(Doctorschedule record);
}
