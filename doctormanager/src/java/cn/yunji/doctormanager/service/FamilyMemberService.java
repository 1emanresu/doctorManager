package cn.yunji.doctormanager.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.FamilyMember;


public interface FamilyMemberService {
	//添加家庭成员信息
	public int addFamilyMember(FamilyMember familyMember);
	//更新家庭成员信息
	public int updateFamilyMember(FamilyMember familyMember);
	//通过主键查询家庭成员信息
	public FamilyMember find(Integer FMId);
	//根据孕妇编号查询所有家庭成员信息
	public List<FamilyMember> findAllByMid(String MId);
	/*
     * 通过mid查询家庭成员中的孕妇信息
     */
	public FamilyMember findGravidaByMid(String mid);
	/*
     * 通过mid查询家庭成员中的丈夫信息
     */
	FamilyMember findHusbandByMid(String mid);
	
	Map<String, Object> selectsByMid(String mid);
	
	public int updateByPrimaryKey(FamilyMember familyMember);
   	/**
   	 修改成员表孕妇相关信息
   	 * @return int
   	 * @throws
   	 */
	public int updateFgravida(FamilyMember familyMember);
  
   	/**
   	 修改成员表丈夫相关信息
   	 * @return int
   	 * @throws
   	 */
	
	public int updateFhusband(FamilyMember familyMember);
	
}
