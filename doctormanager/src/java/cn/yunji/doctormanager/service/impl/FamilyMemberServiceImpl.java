package cn.yunji.doctormanager.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FamilyMemberMapper;
import cn.yunji.doctormanager.dao.GravidaInfoMapper;
import cn.yunji.doctormanager.entity.FamilyMember;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.service.FamilyMemberService;
@Service("familyMemberService")
public class FamilyMemberServiceImpl implements FamilyMemberService {

	@Resource
	private FamilyMemberMapper dao;
	@Resource
	private GravidaInfoMapper gdao;
	
	public int addFamilyMember(FamilyMember familyMember) {
		// TODO Auto-generated method stub
		return dao.insertSelective(familyMember);
	}

	public int updateFamilyMember(FamilyMember familyMember) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(familyMember);
	}

	public FamilyMember find(Integer FMId) {
		// TODO Auto-generated method stub
		 FamilyMember familyMember=dao.selectByPrimaryKey(FMId);
		 String MId = familyMember.getMid();
		 //查询对应的孕妇信息
		 GravidaInfo gravida = gdao.selectByPrimaryKey(MId);
		 familyMember.setGravidaInfo(gravida);
		return familyMember;
	}
	
     /** 通过孕妇id查询孕妇所有家庭成员信息
     * @see 
     */
	public List<FamilyMember> findAllByMid(String MId) {
		// TODO Auto-generated method stub
		return dao.findAllByMid(MId);
	}

	public FamilyMember findGravidaByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.findGravidaByMid(mid);
	}

	public FamilyMember findHusbandByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.findHusbandByMid(mid);
	}
	

	
	@Override
	public int updateByPrimaryKey(FamilyMember familyMember) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(familyMember);
	}


	/**@methodName selectsByMid
	 * @description: 
	 * @param mid
	 * @return 
	 * @see cn.yunji.doctormanager.service.FamilyMemberService#selectsByMid(java.lang.String)
	 */
	@Override
	public Map<String, Object> selectsByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.selectsByMid(mid);
	}

	@Override
	public int updateFgravida(FamilyMember familyMember) {
		// TODO Auto-generated method stub
		return dao.updateFgravida(familyMember);
	}

	@Override
	public int updateFhusband(FamilyMember familyMember) {
		// TODO Auto-generated method stub
		return dao.updateFhusband( familyMember);
	}

}
