package cn.yunji.doctormanager.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.DoctorMapper;
import cn.yunji.doctormanager.dao.FansMapper;
import cn.yunji.doctormanager.dao.MyIntegralMapper;
import cn.yunji.doctormanager.entity.CheckResult;
import cn.yunji.doctormanager.entity.Doctor;
import cn.yunji.doctormanager.entity.FamilyMember;
import cn.yunji.doctormanager.service.DoctorService;
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{
	@Resource
	public DoctorMapper doctor;	
	@Resource
	private  FansMapper   fans;
	@Resource
	private MyIntegralMapper    Integra;
	@Override
	public List<Map<String, Object>> queryByDoctortId(int did) {
 		return doctor.queryByDoctortId(did);
	} 
	@Override
	public Doctor findDoctor(int doctorId) {  
		return doctor.findDoctor(doctorId);
	}
	
	
	
	@Override
	public Map<String, Object> doctorBasicAndfansAndIntegral(Integer did) {
		Doctor doctor1 =doctor .selectByPrimaryKey2(did);
		//粉丝数
		 List<Map<String, Object>> fan=   fans.selectByFins(did);
		 int    fs;
		  if(fans!=null){
		       fs=fan.size();				  
		  }  else{
			  fs =0;
		  }
		   //积分
		  int     Inte=   Integra.countIntegral(did);
		  //职称
		  Map<String,Object>jobName=doctor.selectByDname(doctor1.getDname());
		  
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dname", doctor1.getDname());
		map.put("hospitalname", doctor1.getHospital().getHospitalname());
		map.put("officename", doctor1.getOffice().getOfficename());
    	map.put("jobname",jobName.get("title"));
		map.put("fans", fs);
		map.put("integraley",Inte);
	
		return map;

 
	}
	@Override
	public List<Map<String, Object>> riskprewarning(Integer doctorid) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object>	map = new HashMap<String, Object>(); 
		// 异常信息人员基本信息
		List<CheckResult> list1 = doctor.selectByPrimaryKey(1).getCheckResult();
		// 只要自己患者本人数据
		for (int i = 0; i < list1.size(); i++) {			
			 FamilyMember fam= list1.get(i).getAbnormityinfo().get(i).getGravidaInfo().getFamilyMemberList().get(0);
			map.put("mid", list1.get(i).getMid());//孕妇id
			map.put("gweeks", list1.get(i).getGweeks());// 孕周
			if(list1.get(i).getCheckdate()!=null){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String  str=sdf.format(list1.get(i).getCheckdate());
				map.put("checkdate", str);// 检查日期					
			}
			map.put("list", fam);	
		
			//map = new HashMap<String, Object>(); 					
		}	
		list.add(map);
		return list;
	
	}
	@Override
	public int addDoctorAccount(Doctor doctor1) {
		// TODO Auto-generated method stub
		return doctor.insertSelective(doctor1);
	}
	
	@Override
	public List<Map<String, Object>> queryInfo(String hid, String dname,Integer pageIndex,Integer pageSize) {
		return doctor.queryInfo(hid,dname,pageIndex,pageSize);
	}
	@Override
	public int queryInfoCount(String hid, String dname) {
		// TODO Auto-generated method stub
		return doctor.queryInfoCount(hid,dname);
	}
	@Override
	public int updateByPrimaryKeySelective(Doctor record) {
		// TODO Auto-generated method stub
		return doctor.updateByPrimaryKeySelective(record);
	}
    /** (非 Javadoc) 
     * <p>Title: findByofficeId</p> 
     * <p>Description: </p> 
     * @param officeId
     * @return 
     * @see cn.yunji.doctormanager.service.DoctorService#findByofficeId(java.lang.Integer) 
     */
    @Override
    public List<Doctor> findByofficeId(Integer offItemId) {
        return doctor.findByofficeId(offItemId);
    }
    /** (非 Javadoc) 
     * <p>Title: alertOffid</p> 
     * <p>Description: </p> 
     * @param offID
     * @return 
     * @see cn.yunji.doctormanager.service.DoctorService#alertOffid(java.lang.Integer) 
     */
    @Override
    public int alertOffid(Integer offID,Integer doctorid) {
        return doctor.alertOffid(offID,doctorid);
    }

}
