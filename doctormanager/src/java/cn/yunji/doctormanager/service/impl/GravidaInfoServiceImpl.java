package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FamilyMemberMapper;
import cn.yunji.doctormanager.dao.GravidaInfoMapper;
import cn.yunji.doctormanager.entity.FamilyMember;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.service.GravidaInfoService;
@Service("gravidaInfoService") 
public class GravidaInfoServiceImpl implements GravidaInfoService{
	@Resource 
	private GravidaInfoMapper dao;
	@Resource
	private FamilyMemberMapper FamilyMemberDAO;

	public int updateGravidainfo(GravidaInfo gravidainfo) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(gravidainfo);
	}

	@Override
	public GravidaInfo selectByPrimaryKey2(Integer userid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey2(userid);
	}

	public GravidaInfo find(String mid) {
		// TODO Auto-generated method stub 
		return dao.selectByPrimaryKey(mid);
	}
 
	public int addGravidainfo(GravidaInfo gravidainfo) { 
		// TODO Auto-generated method stub
		return dao.insertSelective(gravidainfo); 
	} 

	public List<GravidaInfo> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Map<String, Object>> findGravidainfoAll(int patientTypeId,int processingState) {
		return dao.findGravidainfoAll(patientTypeId,processingState);
	}

	@Override
	public List<Map<String, Object>> selectGravidainfoAll(String mid) {
		return dao.selectGravidainfoAll(mid);
	}

	@Override
	public Map<String,Object> queryManBlood(String mid) {
		return dao.queryManBlood(mid);
	}

	@Override
	public Map<String, Object> queryPersonage(int relationId, String mid) {
		return dao.queryPersonage(relationId, mid);
	}

	@Override
	public void updatePatientTypeId(GravidaInfo record) {
		dao.updatePatientTypeId(record);
	}

	@Override
	public void updateProcessingState(GravidaInfo record) {
		dao.updateProcessingState(record);
	}

	@Override
	public List<Map<String, Object>> findPagingAll(int patientTypeId,int processingState, int pageNo, int pageSize) {
		return dao.findPagingAll(patientTypeId,processingState, pageNo, pageSize);
	}

	@Override
	public int countAll(int patientTypeId) {
		return dao.countAll(patientTypeId);
	}

	@Override
	public Map<String,Object> findByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.findByMid(mid);
	}

	@Override
	public List<Map<String, Object>> queryByVip(String gname, String medicalrecordno, Integer vipGrade, Date sweeks, Date eweeks, Integer pageIndex, Integer pageSize,Date cur) {
		// TODO Auto-generated method stub
		return dao.queryByVip(gname,medicalrecordno,vipGrade,sweeks,eweeks,pageIndex,pageSize,cur);
	}

	//查询建档所有信息
		/*public GravidaInfo findMessage(String mid) {
			// TODO Auto-generated method stub
			GravidaInfo gravidainfo=dao.find(mid);
			FamilyMember mom = FamilyMemberDAO.findGravidaByMid(mid);
			System.out.println(mom);
			List<FamilyMember> list = gravidainfo.getFamilyMemberList();
			list.add(mom);
			FamilyMember dad = FamilyMemberDAO.findHusbandByMid(mid);
			list.add(dad);
			gravidainfo.setFamilyMemberList(list);
			return gravidainfo;
		}
		
		public void updateMessage(GravidaInfo gravidainfo) {
			// TODO Auto-generated method stub
			List<FamilyMember> list=gravidainfo.getFamilyMemberList();
			FamilyMemberDAO.updateByPrimaryKeySelective(list.get(0));
			FamilyMemberDAO.updateByPrimaryKeySelective(list.get(1));
			dao.updateByPrimaryKey(gravidainfo);
			
		}*/
		
		@Override
		public int updateGra(String mid, String gname, String hospitalid, String bhospitalid,
				String monthpresidenceaddress,
				String monthpresentaddress, Integer medicalcardtype, Date expectedconfinement, Date recorddate,
				String recordno, Integer registertype, Integer attribution, Integer doctor, Date enddate, Date birthYears,
				String distance, Integer husband_condition, Integer poor, Integer family_gdp, Integer postalcode,
				Integer household_register, Integer town, String domicile, String wedlock, Integer marry_age,
				Integer inoculation_history, String medical_insurance, String agricultural) {
			
			GravidaInfo gravidainfo = new GravidaInfo();
			gravidainfo.setMid(mid);
			gravidainfo.setGname(gname);
			gravidainfo.setHospitalid(hospitalid);
			gravidainfo.setBhospitalid(bhospitalid);
			
			gravidainfo.setMonthpresidenceaddress(monthpresidenceaddress);
			gravidainfo.setMonthpresentaddress(monthpresentaddress);
			gravidainfo.setRecordno(recordno);
			gravidainfo.setRegistertype(registertype);
			gravidainfo.setAttribution(attribution);
			gravidainfo.setDoctor(doctor);
			gravidainfo.setMedicalcardtype(medicalcardtype);
			gravidainfo.setExpectedconfinement(expectedconfinement);
			gravidainfo.setRecorddate(recorddate);
			gravidainfo.setEnddate(enddate);
			gravidainfo.setBirthYears(birthYears);
			gravidainfo.setDistance(distance);
			gravidainfo.setHusband_condition(husband_condition);
			gravidainfo.setPoor(poor);
			gravidainfo.setFamily_gdp(family_gdp);
			gravidainfo.setPostalcode(postalcode);
			gravidainfo.setHousehold_register(household_register);
			gravidainfo.setTown(town);
			gravidainfo.setDomicile(domicile);
			gravidainfo.setWedlock(wedlock);
			gravidainfo.setMarry_age(marry_age);
			gravidainfo.setInoculation_history(inoculation_history);
			gravidainfo.setMedical_insurance(medical_insurance);
			gravidainfo.setAgricultural(agricultural);
			int n = dao.updateGravida(gravidainfo);
			if (n == 1) {
				return n;
			}else{
				throw new RuntimeException("修改失败");
			}
			
		}

		@Override
		public int addOrUpdateInfo(GravidaInfo gravidainfo) {
			return dao.addOrUpdateInfo(gravidainfo);
		}

		@Override
		public List<Map<String, Object>> querySymptom(String mid, Date begin, Date end) {	
			return dao.querySymptom(mid, begin, end);
		}

		@Override
		public String getMid(String phone) {
			// TODO Auto-generated method stub
			return dao.getMid(phone);
		}

		@Override
		public List<Map<String, Object>> findByPage(String gname,String sbirth,String ebirth,String medicalrecordno, Integer vipGrade, Date sweeks, Date eweeks, Integer doctor,Integer pageIndex,Integer pageSize,String sortName,String sortOrder,String patientTypeId,String adviceState,String weeklyState,String processingState,String edate,String serviceType) {
			// TODO Auto-generated method stub
			return dao.findByPage(gname,sbirth,ebirth,medicalrecordno,vipGrade, sweeks, eweeks, doctor,pageIndex,pageSize, sortName, sortOrder,patientTypeId,adviceState,weeklyState,processingState,edate, serviceType);
		}

		@Override
		public int getPregnancyCount1() {
			// TODO Auto-generated method stub
			return dao.getPregnancyCount1();
		}

		@Override
		public int getPregnancyCount2() {
			// TODO Auto-generated method stub
			return dao.getPregnancyCount2();
		}

		@Override
		public int getDateCount1(String gname,String sbirth,String ebirth,String medicalrecordno, Integer vipGrade, Date begin, Date end,
				Integer doctor,String patientTypeId,String adviceState,String weeklyState,String processingState,String edate,String serviceType) {
			// TODO Auto-generated method stub
			return dao.getDateCount1(gname,sbirth,ebirth,medicalrecordno,vipGrade, begin, end, doctor, patientTypeId, adviceState, weeklyState,processingState, edate , serviceType);
		}

		@Override
		public String queryByUserPhone(String phone) {
			// TODO Auto-generated method stub
			return dao.queryByUserPhone(phone);
		}

		@Override
		public int examineInfo(String mid, Integer did) {
			return dao.examineInfo(mid,did);
		}

		@Override
		public int getVipCount(String gname, String medicalrecordno, Integer vipGrade, Date begin, Date end, Date cur) {
			return dao.getVipCount(gname,medicalrecordno,vipGrade,begin,end,cur);
		}

		/*@Override
		public List<Map<String, Object>> findAllList() {
			// TODO Auto-generated method stub
			return dao.findAllList();
		}*/
}
