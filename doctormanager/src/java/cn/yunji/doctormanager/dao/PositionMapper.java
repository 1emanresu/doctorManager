package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Position;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    
    //查询所有的职位
    List<Position> find();
}