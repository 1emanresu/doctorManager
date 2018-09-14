package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.PregnancyMapper;
import cn.yunji.doctormanager.entity.Pregnancy;
import cn.yunji.doctormanager.service.PregnancyService;

@Service("pregnancyService")
public class PregnancyServiceImpl implements PregnancyService {
	@Resource
	private PregnancyMapper dao;

	public Pregnancy findByPCid(Integer pcid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(pcid);
	}

	public int addPregnancy(Pregnancy pregnancy) {
		// TODO Auto-generated method stub
		return dao.insertSelective(pregnancy);
	}

	public int update(Pregnancy pregnancy) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(pregnancy);
	}

	@Override
	public int updateByPcid(Integer pcid, Integer sibship, Integer familyhistory, Integer recentmarriage) {
		Pregnancy record = new Pregnancy();
		record.setPcid(pcid);
		record.setSibship(sibship);
		record.setFamilyhistory(familyhistory);
		record.setRecentmarriage(recentmarriage);
		int n = dao.updateByPrimaryKey(record);
		if (n == 1) {
			return n;
		}
		throw new RuntimeException("修改失败");
	}

	@Override
	public Pregnancy findByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.findByMid(mid);
	}

	@Override
	public void updateByMid(Pregnancy pregnancy) {
		// TODO Auto-generated method stub
		dao.updateByMid(pregnancy);
	}

	@Override
	public List<Map<String, Object>> findByCheck(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno,Integer pageIndex,Integer pageSize) {
		return dao.findByCheck(sage,eage, dreFoli, medicalrecordno, pageIndex, pageSize);
	}
	
	@Override
	public List<Map<String, Object>> findByCheck2(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno,Integer pageIndex,Integer pageSize) {
		return dao.findByCheck2(sage,eage, dreFoli, medicalrecordno, pageIndex, pageSize);
	}
	
	@Override
	public List<Map<String, Object>> findByNotCheck(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno,Integer pageIndex,Integer pageSize) {
		return dao.findByNotCheck(sage,eage, dreFoli, medicalrecordno, pageIndex, pageSize);
	}

	@Override
	public int getDateCount1(Integer sage, Integer eage, Integer dreFoli, String medicalrecordno) {
		// TODO Auto-generated method stub
		return dao.getDateCount1(sage,eage, dreFoli, medicalrecordno);
	}

	@Override
	public int getDateCount2(Integer sage, Integer eage, Integer dreFoli, String medicalrecordno) {
		return dao.getDateCount2(sage,eage, dreFoli, medicalrecordno);
	}

	@Override
	public int getDateCount3(Integer sage, Integer eage, Integer dreFoli, String medicalrecordno) {
		// TODO Auto-generated method stub
		return dao.getDateCount3(sage,eage, dreFoli, medicalrecordno);
	}
}
