package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Relation;

public interface RelationMapper {
    int deleteByPrimaryKey(Integer relationid);

    int insert(Relation record);

    int insertSelective(Relation record);

    Relation selectByPrimaryKey(Integer relationid);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);

	List<Relation> find();
}