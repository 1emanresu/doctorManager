package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.Geneticscreening;

public interface GeneticscreeningMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Geneticscreening record);

    int insertSelective(Geneticscreening record);

    Geneticscreening selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Geneticscreening record);

    int updateByPrimaryKey(Geneticscreening record);
}