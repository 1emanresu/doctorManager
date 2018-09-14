package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Contacts;

public interface ContactsMapper {
    int deleteByPrimaryKey(Integer contid);

    int insert(Contacts record);

    int insertSelective(Contacts record);

    Contacts selectByPrimaryKey(Integer contid);

    int updateByPrimaryKeySelective(Contacts record);

    int updateByPrimaryKey(Contacts record);

	List<Map<String,Object>> queryByMid(String mid);
}