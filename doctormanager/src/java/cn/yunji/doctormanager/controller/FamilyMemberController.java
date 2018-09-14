package cn.yunji.doctormanager.controller;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.FamilyMember;

import cn.yunji.doctormanager.service.FamilyMemberService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/familyMember")
public class FamilyMemberController {

	@Resource
	private FamilyMemberService familyMemberService;
	
     /*
      * 通过主键家庭成员信息以及对应的孕妇信息
      */
	@ResponseBody
	@RequestMapping("/find.do")
	public JsonResult find(Integer fmid){
		FamilyMember familyMember=familyMemberService.find(fmid);
		return new JsonResult(familyMember);
	}

    /*
     * 通过mid查询家庭成员中的孕妇信息
     */
	@ResponseBody
	@RequestMapping("/findGravidaByMid.do")
	public JsonResult findGravidaByMid(String mid){
		FamilyMember familyMember=familyMemberService.findGravidaByMid(mid);
		return new JsonResult(familyMember);
	}
	 /*
     * 通过mid查询家庭成员中的丈夫信息
     */
	@ResponseBody
	@RequestMapping("/findHusbandByMid.do")
	public JsonResult findHusbandByMid(String mid){
		FamilyMember familyMember=familyMemberService.findHusbandByMid(mid);
		return new JsonResult(familyMember);
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public int add(FamilyMember familyMember){
		
//		System.out.println(familyMember);
		
		return familyMemberService.addFamilyMember(familyMember);
	}
	@ResponseBody
	@RequestMapping("/update.do")
	public int update(FamilyMember familyMember){
		
//		System.out.println(familyMember);
		
		 return familyMemberService.updateFamilyMember(familyMember);
	}
	
	 /*
     * 更新丈夫信息
     */

	@ResponseBody
	@RequestMapping("/updatehusmessage.do")
	public int updatehusmessage(String profession,int fmid,String workunit,String phone){
//		System.out.println(profession);
//		System.out.println("fmid"+fmid);
//		System.out.println(workunit);
		FamilyMember familyMember=new FamilyMember();
		familyMember.setFmid(fmid);
		familyMember.setPhone(phone);
		familyMember.setProfession(profession);
		familyMember.setWorkunit(workunit);
		return familyMemberService.updateFamilyMember(familyMember);
	}

	/*
	 * 根据主键修改家庭信息
	 */
	public int updateByPrimaryKey(FamilyMember familyMember){
		
		return familyMemberService.updateByPrimaryKey(familyMember);
	}
	
	@ResponseBody
	@RequestMapping("/updateFgravida.do")
	public JsonResult updateFgravida(FamilyMember familyMember){
		int n = familyMemberService.updateFgravida(familyMember);
		return new JsonResult(n);
	}
	
	
	@ResponseBody
	@RequestMapping("/updateFhusband.do")
	public JsonResult updateFhusband(FamilyMember familyMember){
		int n = familyMemberService.updateFhusband(familyMember);
		return new JsonResult(n);
	}
	/**
	 通过mid查询所有家庭成员的信息
	 @Author hongwx 增加关系表的关联  date：2017/10/ 20
	 */
	@ResponseBody
	@RequestMapping("/findAllByMid.do")
	public JsonResult findAllByMid(String mid){
		List<FamilyMember> list = familyMemberService.findAllByMid(mid);
		return new JsonResult(list);
	}
}
