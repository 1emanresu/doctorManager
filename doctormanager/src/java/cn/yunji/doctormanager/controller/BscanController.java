package cn.yunji.doctormanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Bscan;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.Templatetitle;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.BscanService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.TemplatetitleService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/bscan")
public class BscanController {
	@Resource
	private BscanService bscanService;
	/*private CheckindexService checkindexService;
	private HighRiskRtandardService highRiskRtandardService;
	private AbnormityinfoService abnormityinfoService;
	@Resource
	private KnowledgeService knowledgeService;*/
	@Resource
	private GravidaInfoService gravidaInfoService;
	@Resource
    private TemplatetitleService TemplatetitleService;
	@Resource
	private AbnormityinfoService abnormityinfoService;

    //获取最新B超报告
    @ResponseBody
    @RequestMapping("getNewReport")
    public Bscan getNewReport(String mid) {
//      String mid = (String)request.getSession().getAttribute("mid");
        Bscan bscan = bscanService.getNewReport(mid);
        /*int fatehreatrate = bscan.getFetalheartrate();
        HighRiskRtandard highRiskRtandard = getIndex("胎心率");
        String sfatehreatrate = highRiskRtandard.getCbegin().toString();
        int ifatehreatrate = (int)Double.parseDouble(sfatehreatrate);
        if(fatehreatrate < ifatehreatrate) {
            //插入异常信息
            Abnormityinfo abnormityinfo = new Abnormityinfo();
            abnormityinfo.setHighriskresulttypeid(2);
            abnormityinfo.setCid(highRiskRtandard.getCid());
            abnormityinfo.setMid("dg000001");
            abnormityinfo.setHospitalid("0769fy001");
            abnormityinfo.setCheckdate(bscan.getCheckdate());
            abnormityinfo.setScore(highRiskRtandard.getHighriskscore());
            abnormityinfo.setAbnormity(fatehreatrate);
            abnormityinfo.setDeviation((double)(ifatehreatrate-fatehreatrate));
            abnormityinfo.setFroms(1);
            //System.out.println(abnormityinfoService.insert(abnormityinfo));
            
        }*/
        return bscan;
    }
    
    @ResponseBody
    @RequestMapping("/findByMid.do")
    public JsonResult findByMid(String mid){
        Bscan Bscan = bscanService.findByMid(mid);
        return new JsonResult(Bscan);
    }
	
	@ResponseBody
	@RequestMapping("/queryTips.do")
	public Bscan queryTips(String mid, int week) {
		return bscanService.selectTipByMidandWeek(mid, week);
	}

	@RequestMapping("/checkReportftl.do")
	public String checkReport(Model model, String mid, @DateTimeFormat(pattern="yyyy/MM/dd") Date checkDate) {
		Bscan bscan = bscanService.findByMid(mid);
		GravidaInfo gravidaInfo = gravidaInfoService.find(mid);
		if(gravidaInfo != null && bscan != null){
			model.addAttribute("hospital","B超结果");
			model.addAttribute("name",gravidaInfo.getGname());
			model.addAttribute("BPD",bscan.getBpd());
			model.addAttribute("CRL",bscan.getCrl());
			model.addAttribute("femurL",bscan.getFemurl());
			model.addAttribute("humerusL",bscan.getHumerusl());
			model.addAttribute("fetalHeartRate",bscan.getFetalheartrate());
			model.addAttribute("fetalMovement",bscan.getFetalmovement());
			model.addAttribute("fetalHeart",bscan.getFetalheart());
			model.addAttribute("amnioticFluid",bscan.getAmnioticfluid());
			model.addAttribute("placentalThickness",bscan.getPlacentalthickness());
			model.addAttribute("placentalPosition",bscan.getPlacentalposition());
			model.addAttribute("leftOvary",bscan.getLeftovary());
			model.addAttribute("rightOvary",bscan.getRightovary());
			model.addAttribute("NT",bscan.getNt());
			model.addAttribute("NF",bscan.getNf());
			model.addAttribute("nasalBone",bscan.getNasalbone());
			model.addAttribute("fetusNumber",bscan.getFetusnumber());
			model.addAttribute("weeks",bscan.getWeeks());
			model.addAttribute("bdescription",bscan.getBdescription());
			model.addAttribute("btip",bscan.getBtip());
			return "BScanCheckReport.ftl";
		}
		return null;
	}
	 /**
	  * 按孕周查询： 根据孕周、mid、 检查项目id查看B超报告  yinzx
	  * @param mid
	  * @param weeks
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/findByMidAndWeeks.do")
	 public JsonResult findByMidAndWeeks(Integer weeks, Integer checkProjectId,String mId){
	        Bscan Bscan = bscanService.findByMidAndWeeks(weeks, checkProjectId, mId);
	        Map<String, Object> map=new HashMap<>();
	        map.put("bscan", Bscan);
	        Templatetitle templatetitle = TemplatetitleService.queryCheckDetail(weeks, checkProjectId, mId);
	        if(templatetitle!=null){
	        	map.put("templatetitle", templatetitle);
	        }
	        return new JsonResult(map);
	    }
	 /**
		 * 按项目查询： 根据检查项目id、mid、检查结果id 查询检查明细及指标  @yinzx
		 * @param count 第几次产检
		 * @param checkProjectId 检查项目id
		 * @param mId 孕妇id
		 * @return 查询检查明细及指标  
		 */
	 @RequestMapping("/queryResultByProject.do")
	 @ResponseBody
	public JsonResult queryResultByProject(Integer count, Integer checkProjectId, String mId) {
		List<Bscan> bscanlist = bscanService.findByMidAndProject(checkProjectId, mId);
		Date checkDate;
		Bscan bscan;
		Map<String, Object> map = new HashMap<>();
		if(count!=0){
		    if (bscanlist.size() >= count) {
	            bscan = bscanlist.get(count - 1);
	            checkDate = bscan.getCheckdate();
	        } else {
	            bscan = bscanlist.get(0);
	            checkDate = bscan.getCheckdate();
	        }	        
	        map.put("bscan", bscan);
	        Templatetitle templatetitle = TemplatetitleService.queryCheckDetailByDate(checkDate, checkProjectId, mId);
	        List<Map<String, Object>> list = abnormityinfoService.queryByCheckProjectId(mId,checkDate,checkProjectId);
	        if (templatetitle != null) {
	            map.put("templatetitle", templatetitle);
	        }
	        if(list.size()>0){
	            map.put("abnormityinfo", list);//异常信息
	        }
		}
		return new JsonResult(map);
	}
}
