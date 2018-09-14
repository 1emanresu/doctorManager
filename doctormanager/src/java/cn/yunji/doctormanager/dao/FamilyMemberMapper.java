package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.FamilyMember;

public interface FamilyMemberMapper {
    int deleteByPrimaryKey(Integer fmid);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    FamilyMember selectByPrimaryKey(Integer fmid);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);
    
    int insertfamily(FamilyMember record);
    
    List<FamilyMember> findAllByMid(String mId);

	FamilyMember findGravidaByMid(String mid);
	
	FamilyMember findHusbandByMid(String mid);
	
	Map<String, Object> selectsByMid(String mid);
	
	int updateFgravida(FamilyMember familyMember);
	
   	int updateFhusband(FamilyMember familyMember);
   	
   	String findOpenId(@Param("mid")String mid, @Param("relationid")int relationid);
	
}