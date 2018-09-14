package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.PatientType;

public interface PatientTypeMapper {
    int deleteByPrimaryKey(Integer patienttypeid);

    int insert(PatientType record);

    int insertSelective(PatientType record);

    PatientType selectByPrimaryKey(Integer patienttypeid);

    int updateByPrimaryKeySelective(PatientType record);

    int updateByPrimaryKey(PatientType record);
    /**
     * 查询所有的病人类型
     * @return
     * @author luoyc
     * @createDate 2017年10月27日 上午9:33:54
     */
    List<PatientType> findAll();
}