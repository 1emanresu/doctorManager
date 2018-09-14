package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.vipOrder;

public interface vipOrderMapper {
    int deleteByPrimaryKey(Integer ovipid);

    int insert(vipOrder record);

    int insertSelective(vipOrder record);

    vipOrder selectByPrimaryKey(Integer ovipid);

    int updateByPrimaryKeySelective(vipOrder record);

    int updateByPrimaryKey(vipOrder record);

    List<Map<String,Object>> queryServiceTypeNum();

    List<Map<String,Object>> queryWeeklyHandleNum(@Param("weeklast")String weeklast,@Param("vipid")Integer vipid);
}