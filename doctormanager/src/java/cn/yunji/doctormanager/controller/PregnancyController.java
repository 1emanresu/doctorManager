package cn.yunji.doctormanager.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Pregnancy;
import cn.yunji.doctormanager.entity.PregnancyCheck;
import cn.yunji.doctormanager.service.PregnancyCheckService;
import cn.yunji.doctormanager.service.PregnancyService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/pregnancy")
public class PregnancyController {

	@Resource
	private PregnancyService service; 
	@Resource
    private PregnancyCheckService pcService;
	
	@ResponseBody
	@RequestMapping("/findByCheck.do")
	public JsonResult findByCheck(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno,Integer pageIndex,Integer pageSize){
		if(sage==-1){sage=null;}
		if(eage==-1){eage=null;}
		if(dreFoli==-1){dreFoli=null;}
		if(medicalrecordno==""){medicalrecordno=null;}
		List<Map<String,Object>>  pregnancyList= service.findByCheck(sage,eage,dreFoli,medicalrecordno,pageIndex,pageSize);
		return new JsonResult(pregnancyList);
	}
	
	@ResponseBody
	@RequestMapping("/findByCheck2.do")
	public JsonResult findByCheck2(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno,Integer pageIndex,Integer pageSize){
		if(sage==-1){sage=null;}
		if(eage==-1){eage=null;}
		if(dreFoli==-1){dreFoli=null;}
		if(medicalrecordno==""){medicalrecordno=null;}
		List<Map<String,Object>>  pregnancyList= service.findByCheck2(sage,eage,dreFoli,medicalrecordno,pageIndex,pageSize);
		return new JsonResult(pregnancyList);
	}

	@ResponseBody
	@RequestMapping("/findByNotCheck.do")
	public JsonResult findByNotCheck(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno,Integer pageIndex,Integer pageSize){
		if(sage==-1){sage=null;}
		if(eage==-1){eage=null;}
		if(dreFoli==-1){dreFoli=null;}
		if(medicalrecordno==""){medicalrecordno=null;}
		List<Map<String,Object>>  pregnancyList= service.findByNotCheck(sage,eage,dreFoli,medicalrecordno,pageIndex,pageSize);
		return new JsonResult(pregnancyList);
	}
	
	
	@ResponseBody
	@RequestMapping("/getDateCount1.do")
	public int getDateCount1(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno){
		if(sage==-1){sage=null;}
		if(eage==-1){eage=null;}
		if(dreFoli==-1){dreFoli=null;}
		if(medicalrecordno==""){medicalrecordno=null;}
		int c= service.getDateCount1(sage,eage,dreFoli,medicalrecordno);
		return c;
	}
	
	@ResponseBody
	@RequestMapping("/getDateCount2.do")
	public int getDateCount2(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno){
		if(sage==-1){sage=null;}
		if(eage==-1){eage=null;}
		if(dreFoli==-1){dreFoli=null;}
		if(medicalrecordno==""){medicalrecordno=null;}
		int c= service.getDateCount2(sage,eage,dreFoli,medicalrecordno);
		return c;
	}
	
	@ResponseBody
	@RequestMapping("/getDateCount3.do")
	public int getDateCount3(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno){
		if(sage==-1){sage=null;}
		if(eage==-1){eage=null;}
		if(dreFoli==-1){dreFoli=null;}
		if(medicalrecordno==""){medicalrecordno=null;}
		int c= service.getDateCount3(sage,eage,dreFoli,medicalrecordno);
		return c;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/findByPcid.do")
	public JsonResult findByPcid(Integer pcid){
		Pregnancy pregnancy = service.findByPCid(pcid);
		return new JsonResult(pregnancy);
	}
	@ResponseBody
	@RequestMapping("/findByMid.do")
	public JsonResult findByMid(String mid){
		Pregnancy pregnancy = service.findByMid(mid);
		int pcid=pregnancy.getPcid();
		PregnancyCheck pcheck = pcService.findByPcid(pcid);
		if(pcheck!=null){
		    pregnancy.setPregnancyCheck(pcheck);
		}
		return new JsonResult(pregnancy);
	}
	/**
	 * 添加 或更新 备孕信息
	 * @author yinzx
	 * @param pregnancy
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateByMid.do")
	public JsonResult updateByMid(Pregnancy pregnancy,PregnancyCheck pregnancyCheck){
//	    System.out.println("11111111111111111111");
//	    System.out.println(pregnancyCheck);
		String mid=pregnancy.getMid();
		Pregnancy record = service.findByMid(mid);
		pregnancy.setPregnancyCheck(pregnancyCheck);
//		System.out.println(pregnancy.getPregnancyCheck());
		if( record==null){
			//如果没有该记录 则做插入数据操作
//		    System.out.println("插入数据操作");
			service.addPregnancy(pregnancy);
			//添加备孕体检信息
			PregnancyCheck pcheck = pregnancy.getPregnancyCheck();
			if(pcheck!=null){
			    Pregnancy p = service.findByMid(mid);
	            int pcid=p.getPcid();
	            pcheck.setPcid(pcid);
	            pcService.add(pcheck);
			}
		}else {
			//若存在 则更新信息
//		    System.out.println("更新信息");
			service.updateByMid(pregnancy);
			int pcid=record.getPcid();
//			System.out.println("pcid="+pcid);
			//添加或更新备孕体检信息
            PregnancyCheck pcheck = pregnancy.getPregnancyCheck();
            pcheck.setPcid(pcid);
            pcService.addOfUpdate(pcheck);
		}
		
		return new JsonResult(1);
	}

	@ResponseBody
	@RequestMapping("/addPregnancy.do")
	public int addPregnancy(Pregnancy pregnancy){
//		System.out.println(pregnancy);
		return service.addPregnancy(pregnancy);
	}
	@ResponseBody
	@RequestMapping("/update.do")
	public int update(Pregnancy pregnancy){
//		System.out.println("0000");
//		System.out.println(pregnancy);
		return service.update(pregnancy);
	}
	
	@ResponseBody
	@RequestMapping("/updateByPcid.do")
	public JsonResult updateByPcid(Integer pcid, Integer sibship, Integer familyhistory, Integer recentmarriage){
		int n = service.updateByPcid(pcid, sibship, familyhistory, recentmarriage);
		return new JsonResult(n);
	}
}
