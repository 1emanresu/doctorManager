package cn.yunji.doctormanager.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.dao.DoctorMapper;
import cn.yunji.doctormanager.dao.UserTbMapper;
import cn.yunji.doctormanager.entity.Doctor;
import cn.yunji.doctormanager.entity.UserTb;
import cn.yunji.doctormanager.service.DoctorService;
import cn.yunji.doctormanager.service.HospitalService;
import cn.yunji.doctormanager.service.OfficeService;
import cn.yunji.doctormanager.service.UserTbService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 用一句话描述这个类的作用
 * 
 * @author renjz
 * @CreateDate 2017年10月31日 下午3:06:16
 */
@Controller
@RequestMapping("/personCentor")
public class PersonCentorController {
	@Resource
	public DoctorService doctorService;
	@Resource
	private UserTbService userTbService;
	@Resource
	private HospitalService hospitalService;
	@Resource
	private OfficeService officeService;
	@Resource
	public DoctorMapper doctorDao;
	@Resource
	public UserTbMapper UserTbDao;

	@RequestMapping("/doctorInfo.do")
	@ResponseBody
	/**
	 * 医生基本信息
	 *
	 * @return
	 * @author renjz
	 * @createDate 2017年10月31日 下午3:53:29
	 */
	public JsonResult doctorInfo(Integer did) {
		try {
			Doctor map = doctorService.findDoctor(did);
			return new JsonResult(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(0);
	}

	@RequestMapping("/loadOfInfo.do")
	@ResponseBody

	/**
	 * 科室基本信息
	 *
	 * @return
	 * @author renjz
	 * @createDate 2017年10月31日 下午3:53:29
	 */
	public JsonResult loadOfInfo() {
		try {
			return new JsonResult(officeService.findOffice());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(0);
	}

	@RequestMapping("/loadHpInfo.do")
	@ResponseBody
	/**
	 * 
	 * 医院基本信息
	 * 
	 * @return
	 * @author renjz
	 * @createDate 2017年10月31日 下午3:54:32
	 */
	public JsonResult loadHpInfo() {
		try {
			return new JsonResult(hospitalService.find());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(0);
	}

	/**
	 * 
	 * 更新医生信息
	 * 
	 * @return
	 * @author renjz
	 * @createDate 2017年10月31日 下午3:54:32
	 */
	@RequestMapping("/saveInfo.do")
	@ResponseBody
	public int saveInfo(Doctor doctor) {
		int n = doctorService.updateByPrimaryKeySelective(doctor);
		return n;
	}

	/**
	 * 
	 * 验证密码
	 * 
	 * @return
	 * @author renjz
	 * @createDate 2017年10月31日 下午3:54:32
	 */
	@RequestMapping("/checkPwd.do")
	@ResponseBody
	public int checkPwd(String username, String pwd) {
		UserTb user = userTbService.selectByName(username);
		if(pwd.equals(user.getPassword())){
			return 1;
		}
		return 0;
	}
	/**
	 * 
	 * 修改密码
	 * 
	 * @return
	 * @author renjz
	 * @createDate 2017年10月31日 下午3:54:32
	 */
	@RequestMapping("/changPwd.do")
	@ResponseBody
	public int changPwd(UserTb userTb) {
		//System.out.println(userTb);
		int n = userTbService.updateByPrimaryKeySelective(userTb);
		return n;
	}
}







