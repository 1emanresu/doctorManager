package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Antenatal_Item;

public interface Antenatal_ItemMapper {
    int deleteByPrimaryKey(Integer itemid);

	int insert(Antenatal_Item record);

	int insertSelective(Antenatal_Item record);

	Antenatal_Item selectByPrimaryKey(Integer itemid);

	int updateByPrimaryKeySelective(Antenatal_Item record);

	int updateByPrimaryKey(Antenatal_Item record);

	int deleteByPrimaryKey1(Integer itemid);

    int insert1(Antenatal_Item record);

    int insertSelective1(Antenatal_Item record);

    Antenatal_Item selectByPrimaryKey1(Integer itemid);

    int updateByPrimaryKeySelective1(Antenatal_Item record);

    int updateByPrimaryKey1(Antenatal_Item record);
    
    List<Map<String, Object>> findallcheckprojectbyweeks(Integer weeks);
    
    List<Map<String, Object>> findcheckedprojectbyweeks(Integer weeks, String mid, String doctorId, String hospitalId);
    
    Antenatal_Item findbeginandendweeks(Integer weeks);
    
    List<Map<String, Object>> queryByWeeks(Integer week);
}