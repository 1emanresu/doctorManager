package Logintest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yunji.doctormanager.dao.DoctorMapper;
import cn.yunji.doctormanager.dao.NurseMapper;
import cn.yunji.doctormanager.dao.UserTbMapper;
import cn.yunji.doctormanager.dao.WeightTestMapper;
import cn.yunji.doctormanager.entity.CheckResult;
import cn.yunji.doctormanager.entity.FamilyMember;
import cn.yunji.doctormanager.entity.Nurse;
import cn.yunji.doctormanager.entity.UserTb;
import cn.yunji.doctormanager.entity.WeightTest;

public class UserLoginCase {

@Test
public void   test1(){
	String[] conf = { "conf/spring-mybatis.xml", "conf/spring-mvc.xml" };
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	System.out.println(ac);
	System.out.println(ac);
	UserTbMapper  user=ac.getBean("userTbMapper",UserTbMapper.class);
	UserTb use=user.findByNameAndpassword("15335645521", "123456");
	System.out.println(use);
	
	
	
}




@Test
public void   test4() throws ParseException{
	String[] conf = { "conf/spring-mybatis.xml", "conf/spring-mvc.xml" };
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);

	WeightTestMapper  user=ac.getBean("weightTestMapper",WeightTestMapper.class);
	//NurseMapper  nurse=ac.getBean("nurseMapper",NurseMapper.class);
	//Nurse  n=nurse.findByUserid(2);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date begin=sdf.parse("2017-05-08");
	Date end=sdf.parse("2017-05-29");
	List<WeightTest> use=user.findByDateRange("dg000001", begin, end);
	for(WeightTest weightTest:use){
		System.out.println(weightTest.getPregnancy());
	}
	
	
	
}

@Test
public void   test2(){
	String[] conf = { "conf/spring-mybatis.xml", "conf/spring-mvc.xml" };
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);

	DoctorMapper   d=ac.getBean("doctorMapper",DoctorMapper.class);
	 Map<String,Object> d1=d .selectByDname("吴丽萍");
	 
	 
	System.out.println(d1.get("title"));

}




@Test
public void   test3(){
	String[] conf = { "conf/spring-mybatis.xml", "conf/spring-mvc.xml" };
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);

	DoctorMapper   d=ac.getBean("doctorMapper",DoctorMapper.class);
	//Doctor doctor =d.selectByPrimaryKey(1);
	 //FamilyMember  list =doctor.getCheckResult().get(0).getAbnormityinfo().get(0).getGravidaInfo().getFamilyMemberList().get(0);
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	Map<String, Object>	map = new HashMap<String, Object>(); 
	// 异常信息人员基本信息
	List<CheckResult> list1 = d.selectByPrimaryKey(1).getCheckResult();
	// 只要自己本人数据
	for (int i = 0; i < list1.size(); i++) {			
FamilyMember 	   fam=  list1.get(i).getAbnormityinfo().get(i).getGravidaInfo().getFamilyMemberList().get(0);
	  
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

	System.out.println(list);
	
	
	

}

	






}
