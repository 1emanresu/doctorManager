package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Doctorschedule;

public interface DoctorscheduleMapper {
    int deleteByPrimaryKey(Integer scheduleid);

    int insert(Doctorschedule record);

    int insertSelective(Doctorschedule record);

    Doctorschedule selectByPrimaryKey(Integer scheduleid);

    int updateByPrimaryKeySelective(Doctorschedule record);

    int updateByPrimaryKey(Doctorschedule record);
    /**
     * 查询本周医生排班的信息
     * @Description: TODO(用一句话描述该方法做什么) 
     * @param mindutyDate
     * @param maxdutyDate
     * @return @Param("mindutyDate") Date mindutyDate,@Param("maxdutyDate") Date maxdutyDate
     * @author wangzw
     */
    List<Map<String, Object>> findAlldoctorschedule(String beginDate,String endDate,Integer offid);
}