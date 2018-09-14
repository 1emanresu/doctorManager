package cn.yunji.doctormanager.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.dao.HighRiskResultTypeMapper;
import cn.yunji.doctormanager.dao.KnowledgeMapper;
import cn.yunji.doctormanager.entity.CheckDetail;
import cn.yunji.doctormanager.entity.CheckResult;
import cn.yunji.doctormanager.entity.HighRiskResultType;
import cn.yunji.doctormanager.entity.HighRiskRtandard;
import cn.yunji.doctormanager.entity.Knowledge;
import cn.yunji.doctormanager.service.CheckProjectService;
import cn.yunji.doctormanager.service.CheckResultService;
import cn.yunji.doctormanager.service.HighRiskRtandardService;
import cn.yunji.doctormanager.util.JsonResult;


/**<p>FileName: CheckDetailController</p>
 * @description:
 * @author king_smm
 * @version 
 */
@Controller
public class RutineTestController {
	@Resource
	private HighRiskRtandardService highRiskRtandardService;
	@Resource
	private CheckResultService checkResultService;
	@Resource
	private CheckProjectService checkProjectService;
	@Resource
	private HighRiskResultTypeMapper highRiskResultTypeMapper;
	@Resource
	private KnowledgeMapper knowledgeMapper;
	@RequestMapping("/rutine.do")
	@ResponseBody
	public JsonResult queryByCrid(String mid,@DateTimeFormat(pattern="yyyy-MM-dd") Date checkDate,String riskname,String hospitalid){
		CheckResult cr=new CheckResult();
		cr.setCheckdate(checkDate);
		cr.setMid(mid);
		cr.setCheckprojectid(checkProjectService.selectByRiskname(riskname).getCheckprojectid());
		List<CheckDetail> cD=checkResultService.selectByMid(cr).getCheckDetailList();
		List<Map> mapList= new ArrayList<Map>();
		List gravidaInfoList= new ArrayList();
		List<HighRiskResultType> h2=highRiskResultTypeMapper.findAll();
		HighRiskRtandard hrr=new HighRiskRtandard();
		hrr.setHospitalid(hospitalid);
		for(CheckDetail c1:cD){
			BigDecimal floor=c1.getCheckindex().getCbegin();
			BigDecimal top=c1.getCheckindex().getCend();
			BigDecimal result=c1.getCheckvalue();
			int a=result.intValue();
			int b=top.intValue();
			int c=floor.intValue();
			List<HighRiskRtandard> h=null;
			hrr.setCid(c1.getCid());
			h=highRiskRtandardService.findByCid(hrr);
			int val=0;
			String hType=null;
			Knowledge knowledge=null;
			for(int i=1;i<h.size();i++){
				if((a<=h.get(i).getCbegin().intValue()&&a>h.get(i-1).getCbegin().intValue())||a>h.get(i).getCbegin().intValue()){
					val=h.get(i-1).getHighriskscore();
					for(HighRiskResultType h3:h2){
						if(h3.getHighriskscore()==val){
							hType=h3.getHighriskresulttype();
							knowledge=knowledgeMapper.selectByCidHType(c1.getCheckindex().getCid(),h3.getHighriskresulttypeid());
						}
					}
				}
			}
			Map<String,String> map=new HashMap<String,String>();
			int no=c1.getCheckindex().getCid();
			String projectName=c1.getCheckindex().getCname();
			String unit=c1.getCheckindex().getCunit();
			String knowledgeku=knowledge.getKnowledge();
			map.put("no", no+"");
			map.put("result", result+"");
			map.put("projectName", projectName);
			map.put("top",top+"");
			map.put("floor",floor+"");
			map.put("unit", unit);
			map.put("knowledgeku", knowledgeku);
			map.put("hType",hType);
			mapList.add(map);
		}
		gravidaInfoList.add(mapList);
		return new JsonResult(gravidaInfoList);
	}	
}
