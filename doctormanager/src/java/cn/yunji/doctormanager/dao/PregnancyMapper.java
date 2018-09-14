package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Pregnancy;

public interface PregnancyMapper {
    

	int deleteByPrimaryKey(Integer pcid);

    int insert(Pregnancy record);

    int insertSelective(Pregnancy record);

    Pregnancy selectByPrimaryKey(Integer pcid);

    int updateByPrimaryKeySelective(Pregnancy record);

    int updateByPrimaryKey(Pregnancy record);
    
    public int updateByPcid(Integer pcid);

	Pregnancy findByMid(String mid);

	void updateByMid(Pregnancy pregnancy);

	List<Map<String, Object>> findByCheck(@Param("sage")Integer sage,@Param("eage")Integer eage,@Param("dreFoli") Integer dreFoli,@Param("medicalrecordno") String medicalrecordno,@Param("pageIndex") Integer pageIndex,
			@Param("pageSize")Integer pageSize);
	
	List<Map<String, Object>> findByCheck2(@Param("sage")Integer sage,@Param("eage")Integer eage,@Param("dreFoli") Integer dreFoli,@Param("medicalrecordno") String medicalrecordno,@Param("pageIndex") Integer pageIndex,
			@Param("pageSize")Integer pageSize);
	
	List<Map<String, Object>> findByNotCheck(@Param("sage")Integer sage,@Param("eage")Integer eage,@Param("dreFoli") Integer dreFoli,@Param("medicalrecordno") String medicalrecordno,@Param("pageIndex") Integer pageIndex,
			@Param("pageSize")Integer pageSize);

	int getDateCount2(@Param("sage")Integer sage,@Param("eage")Integer eage,@Param("dreFoli") Integer dreFoli,@Param("medicalrecordno") String medicalrecordno);

	int getDateCount1(@Param("sage")Integer sage,@Param("eage")Integer eage,@Param("dreFoli") Integer dreFoli,@Param("medicalrecordno") String medicalrecordno);

	int getDateCount3(@Param("sage")Integer sage,@Param("eage")Integer eage,@Param("dreFoli") Integer dreFoli,@Param("medicalrecordno") String medicalrecordno);
}