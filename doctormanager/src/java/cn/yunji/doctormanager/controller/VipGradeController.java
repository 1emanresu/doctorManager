package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.VipGrade;
import cn.yunji.doctormanager.service.VipGradeService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/vipGrade")
public class VipGradeController {
	@Resource
	private VipGradeService vipGradeService;
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult find(){
		return new JsonResult(vipGradeService.find());
	}
	
	@RequestMapping("/insertSelective.do")
	@ResponseBody
	public int insertSelective(VipGrade record){
		return vipGradeService.insertSelective(record);
	}
	
	@RequestMapping("/selectByPrimaryKey.do")
	@ResponseBody
	public JsonResult selectByPrimaryKey(Integer vipgradeid){
		VipGrade record = vipGradeService.selectByPrimaryKey(vipgradeid);
		return new JsonResult(record);
	}

	/**
	 * 根据会员套餐名称查询所有
	 * @param vipgradename
	 * @return
	 */
	@RequestMapping("/selectByName.do")
	@ResponseBody
	public JsonResult selectByName(String vipgradename){
		VipGrade record = vipGradeService.selectByName(vipgradename);
		return new JsonResult(record);
	}

	@RequestMapping("/updateByVid.do")
	@ResponseBody
	public int updateByVid(VipGrade record){
		//System.out.println(record);
		int n = vipGradeService.updateByVid(record);
		return n;
	}

	@RequestMapping("/deleteByPrimaryKey.do")
	@ResponseBody
	public int deleteByPrimaryKey(Integer vipgradeid){
		int n = vipGradeService.deleteByPrimaryKey(vipgradeid);
		return n;
	}
}
