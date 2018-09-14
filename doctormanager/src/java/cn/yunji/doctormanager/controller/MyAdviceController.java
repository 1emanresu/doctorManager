package cn.yunji.doctormanager.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.yunji.doctormanager.entity.MyAdvice;
import cn.yunji.doctormanager.service.MyAdviceService;
import cn.yunji.doctormanager.util.JsonResult;

//异常信息
@Controller
@RequestMapping("/myAdvice")
public class MyAdviceController {
	@Resource
	private MyAdviceService myAdviceService;

	/**
	 * 插入医生的个人医嘱库
	 * @author luoyc
	 * @param myAdvice
	 * @return
	 */
	@RequestMapping("/insert.do")
	@ResponseBody
	public JsonResult insert(Integer doctorid,String myknowledge){
		MyAdvice myAdvice=new MyAdvice();
		myAdvice.setCid(1);
		myAdvice.setRiskfactorid(1);
		myAdvice.setDoctorid(doctorid);
		myAdvice.setMyknowledge(myknowledge);
		return new JsonResult(myAdviceService.insert(myAdvice));
	}
	
	/**
	 * 根据医生id查找出所有医嘱
	 */
	@RequestMapping("/selectByDoctorId.do")
	@ResponseBody
	public JsonResult selectByDoctorId(Integer doctorid){
		List<MyAdvice> list = myAdviceService.selectByDoctorId(doctorid);
		return new JsonResult(list);
	}
}
