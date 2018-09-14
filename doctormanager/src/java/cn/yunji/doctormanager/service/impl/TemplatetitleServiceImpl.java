package cn.yunji.doctormanager.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FamilyMemberMapper;
import cn.yunji.doctormanager.dao.TemplatetitleMapper;
import cn.yunji.doctormanager.entity.FamilyMember;
import cn.yunji.doctormanager.entity.Templatetitle;
import cn.yunji.doctormanager.service.TemplatetitleService;
@Service("templatetitleService")
public class TemplatetitleServiceImpl implements TemplatetitleService{

	@Resource
	private TemplatetitleMapper TemplatetitleDAO;
	@Resource
	private FamilyMemberMapper familyMemberDAO;
	@Override
	public int insertSelective(Templatetitle record) {
		// TODO Auto-generated method stub
		return TemplatetitleDAO.insertSelective(record);
	}

	@Override
	public Templatetitle queryCheckDetail(Integer weeks, Integer checkProjectId, String mId) {
		// TODO Auto-generated method stub
		FamilyMember Gravida = familyMemberDAO.findGravidaByMid(mId);
		Templatetitle templatetitle = TemplatetitleDAO.queryCheckDetail(weeks, checkProjectId, mId);
		if(templatetitle!=null){
			templatetitle.setName(Gravida.getName());
			templatetitle.setAge(Gravida.getAge());
		}
		return templatetitle;
	}

	@Override
	public Templatetitle queryCheckDetailByDate(Date checkdate, Integer checkProjectId, String mId) {
		// TODO Auto-generated method stub
		FamilyMember Gravida = familyMemberDAO.findGravidaByMid(mId);
		Templatetitle templatetitle = TemplatetitleDAO.queryCheckDetailByDate(checkdate, checkProjectId, mId);
		if(templatetitle!=null){
    		templatetitle.setName(Gravida.getName());
    		templatetitle.setAge(Gravida.getAge());
		}
		return templatetitle;
	}

}
