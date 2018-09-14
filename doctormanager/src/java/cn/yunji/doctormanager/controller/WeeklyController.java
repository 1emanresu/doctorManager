package cn.yunji.doctormanager.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Antenatal_Item;
import cn.yunji.doctormanager.entity.Antenatalcaretime;
import cn.yunji.doctormanager.entity.CheckDetail;
import cn.yunji.doctormanager.entity.CheckProject;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.PageModel;
import cn.yunji.doctormanager.service.AbnormityinfoService;    
import cn.yunji.doctormanager.service.Antenatal_ItemService;
import cn.yunji.doctormanager.service.AntenatalcaretimeService;
import cn.yunji.doctormanager.service.CheckDetailService;
import cn.yunji.doctormanager.service.CheckProjectService;
import cn.yunji.doctormanager.service.CheckindexService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.MyCheckResultService;
import cn.yunji.doctormanager.util.DateFormat;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 
 * @author wangzw 周报控制器
 */
@Controller
@RequestMapping("/weekly")
public class WeeklyController {
	@Resource
	private GravidaInfoService gravidaInfoService;
	@Resource
	private AbnormityinfoService abnormityinfoService;
	@Resource
	private CheckindexService checkindexService;
	@Resource
	private CheckDetailService checkDetailService;
	@Resource
	private CheckProjectService checkProjectService;
	@Resource
	private Antenatal_ItemService antenatal_itemservice;
	@Resource
	private AntenatalcaretimeService antenatalcaretimeservice;
	@Resource
	private MyCheckResultService myCheckResultService;

	/**
	 * @author wangzw
	 * @param mid
	 * @return 全部异常
	 */
	@RequestMapping("/queryAbnormityinAll.do")
	@ResponseBody
	public JsonResult queryAbnormityinAll(String mid) {
		List<Map<String, Object>> abnormityinAll = null;
		abnormityinAll = abnormityinfoService.findByMid(mid);
		return new JsonResult(abnormityinAll);
	}

	/**
	 * @author wangzw
	 * @param mid
	 * @return 报告完整
	 */
	@RequestMapping("/findCheckProjectAll.do")
	@ResponseBody
	public JsonResult findCheckProjectAll(String mid,Integer weeks) {
		Map<String, Object> map = new HashMap<String, Object>();
		//当前孕周需要检查的项目
		if(weeks==null){
			map.put("sum", 0);
			return new JsonResult(map);
		}
		List<Map<String, Object>> list = antenatal_itemservice.findallcheckprojectbyweeks(weeks);
		//该孕周没有要做的检查
		if(list.size()==0){
			map.put("sum", 0);
			return new JsonResult(map);
		}
		// 检查过的 项目list
		List<Map<String, Object>> checkedlist = antenatal_itemservice.findcheckedprojectbyweeks(weeks, mid, "1",
				"0769fy001");
		double num=0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < checkedlist.size(); j++) {
				if(list.get(i).get("checkprojectid")==checkedlist.get(j).get("checkProjectId")){
					num++;
				}
			}
		}
		double sum= num/list.size()*100;
		map.put("sum", sum);
		return new JsonResult(map);
	}

	/**
	 * @author wangzw
	 * @param mid
	 * @return 检查过的
	 */
	@RequestMapping("/findCheckProject.do")
	@ResponseBody
	public JsonResult findallCheckProjectbymidandweek(String mid, Integer week) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(week==null){
			return new JsonResult();
		}
		//当前孕周需要检查的项目
		List<Map<String, Object>> list = antenatal_itemservice.findallcheckprojectbyweeks(week);
		//改孕周没有要做的检查
		if(list.size()==0){
			return new JsonResult();
		}
		// 检查过的 项目list
		List<Map<String, Object>> checkedlist = antenatal_itemservice.findcheckedprojectbyweeks(week, mid, "1",
				"0769fy001");
		for (Map<String, Object> lis2t : list) {
		}
		GravidaInfo gravidaInfo = gravidaInfoService.find(mid);
		Calendar ca = Calendar.getInstance();
		ca.setTime(gravidaInfo.getEnddate());
		String senddate = (String) list.get(0).get("antenatalEndWeeks");
		ca.set(Calendar.DATE, Integer.parseInt(senddate) * 7);
		Antenatalcaretime antenatalcaretime = new Antenatalcaretime();
		String extendproject = null;
		if (senddate.equals("13")) {
			antenatalcaretime = antenatalcaretimeservice.findfirstExtendCheckprojectId(DateFormat.yMd(ca.getTime()),
					mid);
			if (antenatalcaretime != null) {
				extendproject = antenatalcaretime.getFirstExtendCheckprojectId();
			}
		}
		if (senddate.equals("20")) {
			antenatalcaretime = antenatalcaretimeservice.findsecondExtendCheckprojectId(DateFormat.yMd(ca.getTime()),
					mid);
			if (antenatalcaretime != null) {
				extendproject = antenatalcaretime.getSecondExtendCheckprojectId();
			}
		}
		if (senddate.equals("24")) {
			antenatalcaretime = antenatalcaretimeservice.findthirdExtendCheckprojectId(DateFormat.yMd(ca.getTime()),
					mid);
			if (antenatalcaretime != null) {
				extendproject = antenatalcaretime.getThirdExtendCheckprojectId();
			}
		}
		if (senddate.equals("28")) {
			antenatalcaretime = antenatalcaretimeservice.findfourthExtendCheckprojectId(DateFormat.yMd(ca.getTime()),
					mid);
			if (antenatalcaretime != null) {
				extendproject = antenatalcaretime.getFourthExtendCheckprojectId();
			}
		}
		if (senddate.equals("32")) {
			antenatalcaretime = antenatalcaretimeservice.findfifthExtendCheckprojectId(DateFormat.yMd(ca.getTime()),
					mid);
			if (antenatalcaretime != null) {
				extendproject = antenatalcaretime.getFifthExtendCheckprojectId();
			}
		}
		if (senddate.equals("36")) {
			antenatalcaretime = antenatalcaretimeservice.findsixthExtendCheckprojectId(DateFormat.yMd(ca.getTime()),
					mid);
			if (antenatalcaretime != null) {
				extendproject = antenatalcaretime.getSixthExtendCheckprojectId();
			}
		}
		if (senddate.equals("41")) {
			antenatalcaretime = antenatalcaretimeservice.findsevenExtendCheckprojectId(DateFormat.yMd(ca.getTime()),
					mid);
			if (antenatalcaretime != null) {
				extendproject = antenatalcaretime.getSevenExtendCheckprojectId();
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				try {
					if (!list.get(i).get("checkprojectid").equals("")
							|| !list.get(i).get("checkprojectid").equals(null)) {
						sb.append(list.get(i).get("checkprojectid"));
					}
				} catch (Exception e) {
					break;
				}
			} else if (i != 0) {
				sb.append("," + list.get(i).get("checkprojectid"));
			}
		}
		if (extendproject != null) {
			if (sb.length() == 0) {
				sb.append(extendproject);
			} else {
				sb.append("," + extendproject);
			}
		}
		String allchecklist = sb.toString();
		// 建议检查的项目数组
		String[] checkstringtolist = {};
		if (allchecklist.length() != 0) {
			checkstringtolist = allchecklist.split(",");
		}
		List<CheckProject> risknamelist = new ArrayList<CheckProject>();
		List<String> checkedrisknamelist = new ArrayList<String>();
		StringBuffer checkresult1 = new StringBuffer();
		StringBuffer checkresult2 = new StringBuffer();
		StringBuffer checkresult3 = new StringBuffer();
		StringBuffer checkresult4 = new StringBuffer();
		StringBuffer checkresult5 = new StringBuffer();
		StringBuffer checkresult6 = new StringBuffer();
		List<Map<String, Object>> maplist=new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> maplist2=new ArrayList<Map<String, Object>>();
		if (checkstringtolist.length != 0) {
			for (int i = 0; i < checkstringtolist.length; i++) {
				risknamelist.add(checkProjectService.selectByPrimaryKey(Integer.parseInt(checkstringtolist[i])));
			}

			for (int i = 0; i < checkedlist.size(); i++) {
				checkedrisknamelist.add(checkProjectService
						.selectByPrimaryKey(
								Integer.parseInt(Long.toString((long) checkedlist.get(i).get("checkProjectId"))))
						.getRiskname());
			}
			for (int i = 0; i < risknamelist.size(); i++) {
				if (checkedrisknamelist.size() == 0) {
					Map<String,Object> mp2=new HashMap<String,Object>();
					mp2.put("name",risknamelist.get(i).getRiskname());
					mp2.put("pid",risknamelist.get(i).getCheckprojectid());
					maplist2.add(mp2);
					/*if (risknamelist.get(i).getCheckType() == 1) {
						checkresult4
								.append(risknamelist.get(i).getRiskname());
					}

					if (risknamelist.get(i).getCheckType() == 2) {
						checkresult5
								.append(risknamelist.get(i).getRiskname());
					}

					if (risknamelist.get(i).getCheckType() == 3) {
						checkresult6
								.append(risknamelist.get(i).getRiskname());
					}*/
				}

				for (int j = 0; j < checkedrisknamelist.size(); j++) {
					if (risknamelist.get(i).getRiskname().equals(checkedrisknamelist.get(j))) {
						Map<String,Object> mp1=new HashMap<String,Object>();
						mp1.put("name",risknamelist.get(i).getRiskname());
						mp1.put("pid",risknamelist.get(i).getCheckprojectid());
						maplist.add(mp1);
						/*if (risknamelist.get(i).getCheckType() == 1) {
							checkresult1.append("<span>" +risknamelist.get(i).getRiskname() + "</span>、");
						}
						if (risknamelist.get(i).getCheckType() == 2) {
							checkresult2.append("<span>" +risknamelist.get(i).getRiskname() + "</span>、");
						}
						if (risknamelist.get(i).getCheckType() == 3) {
							checkresult3.append("<span>" +risknamelist.get(i).getRiskname() + "</span>、");
						}*/
						checkedrisknamelist.remove(j);
						break;
					} else if (j == (checkedrisknamelist.size() - 1)) {
						Map<String,Object> mp2=new HashMap<String,Object>();
						mp2.put("name",risknamelist.get(i).getRiskname());
						mp2.put("pid",risknamelist.get(i).getCheckprojectid());
						maplist2.add(mp2);
						/*if (risknamelist.get(i).getCheckType() == 1) {
							checkresult4.append(
									risknamelist.get(i).getRiskname());
						}

						if (risknamelist.get(i).getCheckType() == 2) {
							checkresult5.append(risknamelist.get(i).getRiskname());
						}

						if (risknamelist.get(i).getCheckType() == 3) {
							checkresult6.append(risknamelist.get(i).getRiskname());
						}*/
					}
				}
			}
		}
		map.put("in", maplist);
		map.put("not", maplist2);
		return new JsonResult(map);
	}

	/**
	 * @author wangzw
	 * @param mid
	 * @return 全部检查
	 */
	@RequestMapping("/findCheckProjectAlls.do")
	@ResponseBody
	public JsonResult findCheckProjectAlls(String mid) {
		List<Map<String, Object>> allFind = checkProjectService.allFind(1);
		return new JsonResult(allFind);
	}

	/**
	 * @author wangzw
	 * @param mid
	 * @return 家庭自测
	 */
	@RequestMapping("/findHomeAll.do")
	@ResponseBody
	public JsonResult findHomeAll(String mid,Integer weeks) {
		/*
		 * List<Map<String, Object>> checkAll =
		 * checkProjectService.findCheckProjectAll(mid); List<Map<String,
		 * Object>> allFind = checkProjectService.allFind(0);
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map> mapList = new ArrayList<Map>();
		/*
		 * double cAll = checkAll.size(); double allF = allFind.size(); double
		 * sum = (cAll / allF * 100);
		 */
		Antenatal_Item antenatal_item = antenatal_itemservice.findbeginandendweeks(weeks);
		List<Map<String, Object>> mychecklist = checkProjectService.allFind(0);
		String beginweeks = antenatal_item.getAntenatalbeginweeks();
		String endweeks = antenatal_item.getAntenatalendweeks();
		List<Map<String, Object>> mycheckedlist = myCheckResultService.findmycheckedByweeks(mid,
				Integer.parseInt(beginweeks), Integer.parseInt(endweeks));
		int sum = (int) ((float) mycheckedlist.size() / (float) mychecklist.size() * 100);
		map.put("sum", sum);
		mapList.add(map);
		return new JsonResult(mapList);
	}

	/**
	 * @author wangzw
	 * @return 查找孕妇的摘要
	 */
	// 2017-09-20 luoyc注释
	/*
	 * @RequestMapping("/queryAbstractAll.do")
	 * 
	 * @ResponseBody public JsonResult queryAbstractAll(String mids) {
	 * List<Map<String, Object>> gravidaInfo =
	 * gravidaInfoService.selectGravidainfoAll(mids); Map<String, Object>
	 * checkindex = checkindexService.queryShouAll(17, 43); Map<String, Object>
	 * checkindex2 = checkindexService.queryShouAll(17, 44); Map<String, Object>
	 * checkindex3 = checkindexService.queryShouAll(2, 1); Map<String, Object>
	 * map = new HashMap<String, Object>(); List<Map> mapList = new
	 * ArrayList<Map>(); for (int i = 0; i < gravidaInfo.size(); i++) { String
	 * check = null; String checkShu = null; String checkPiss = null; String mid
	 * = gravidaInfo.get(i).get("mId").toString(); List<Map<String, Object>>
	 * shou = abnormityinfoService.findShouAll(43, mid); List<Map<String,
	 * Object>> shu = abnormityinfoService.findShouAll(44, mid); CheckDetail
	 * checkDetail = checkDetailService.selectByCid(mid, 1); if
	 * (mid.trim().equals(mids.trim())) { if (shou != null && shu != null &&
	 * checkDetail != null) { if
	 * (Double.parseDouble(shou.get(0).get("abnormity").toString()) <= (double)
	 * Double .parseDouble(checkindex.get("cbegin").toString())) { check =
	 * "收缩压<90mmHg"; } else if
	 * (Double.parseDouble(shou.get(0).get("abnormity").toString()) >= (double)
	 * Double .parseDouble(checkindex.get("cend").toString())) { check =
	 * "收缩压≥140mmHg"; } if
	 * (Double.parseDouble(shu.get(0).get("abnormity").toString()) <= (double)
	 * Double .parseDouble(checkindex2.get("cbegin").toString())) { checkShu =
	 * "舒张压<60mmHg"; } else if
	 * (Double.parseDouble(shu.get(0).get("abnormity").toString()) >= (double)
	 * Double .parseDouble(checkindex2.get("cend").toString())) { checkShu =
	 * "舒张压≥90mmHg"; }
	 * 
	 * if (Double.parseDouble(checkDetail.getCheckvalue().toString()) <=
	 * (double) Double .parseDouble(checkindex3.get("cbegin").toString())) {
	 * checkPiss = "尿蛋白<20mg/L"; } else if
	 * (Double.parseDouble(checkDetail.getCheckvalue().toString()) >= (double)
	 * Double .parseDouble(checkindex3.get("cend").toString())) { checkPiss =
	 * "尿蛋白≥30mg/L"; } map.put("mid", mid); map.put("gname",
	 * gravidaInfo.get(i).get("gName")); map.put("age",
	 * gravidaInfo.get(i).get("age")); map.put("highRiskResultType",
	 * shou.get(0).get("highRiskResultType")); map.put("shu", checkShu);
	 * map.put("check", check); map.put("check", checkPiss);
	 * map.put("medicalRecordNo", gravidaInfo.get(i).get("medicalRecordNo"));
	 * map.put("age", gravidaInfo.get(i).get("age"));
	 * map.put("expectedConfinement",
	 * gravidaInfo.get(i).get("expectedConfinement"));
	 * map.put("patientTypeName", gravidaInfo.get(i).get("patientTypeName"));
	 * map.put("vipGradeName", gravidaInfo.get(i).get("vipGradeName"));
	 * mapList.add(map); } } } return new JsonResult(mapList); }
	 */
	/**
	 * @author wangzw
	 * @return 查询孕妇的个人信息
	 */
	@RequestMapping("/selectGravidaInfo.do")
	@ResponseBody
	public JsonResult selectGravidaInfo(String mids) {
		List<Map<String, Object>> gravidaInfo = gravidaInfoService.selectGravidainfoAll(mids);
		// System.out.println(gravidaInfo);
		return new JsonResult(gravidaInfo);
	}

	/**
	 * @author wangzw
	 * @return 查找所有妊娠高血压患者信息 待处理的患者
	 */
	@RequestMapping("/conditionsQuery.do")
	@ResponseBody
	public JsonResult conditionsQuery(int ifdispose, String vipGrade, String medicalNo) {
		List<Map<String, Object>> gravidaInfo = gravidaInfoService.findGravidainfoAll(1, ifdispose);
		Map<String, Object> checkindex = checkindexService.queryShouAll(17, 43);
		Map<String, Object> checkindex2 = checkindexService.queryShouAll(17, 44);
		Map<String, Object> checkindex3 = checkindexService.queryShouAll(2, 1);
		List<Map> mapList = new ArrayList<Map>();
		for (int i = 0; i < gravidaInfo.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String check = null;
			String checkShu = null;
			String checkPiss = null;
			String mid = gravidaInfo.get(i).get("mId").toString();
			List<Map<String, Object>> shou = abnormityinfoService.findShouAll(43, "dg000001");
			List<Map<String, Object>> shu = abnormityinfoService.findShouAll(44, "dg000001");
			CheckDetail checkDetail = checkDetailService.selectByCid("dg000001", 1);
			String vipgradeid = null;
			if ((long) gravidaInfo.get(i).get("vipGradeid") == 100) {
				vipgradeid = "VIP";
			} else if ((long) gravidaInfo.get(i).get("vipGradeid") == 101) {
				vipgradeid = "VIP2";
			} else {
				vipgradeid = "VIP3";
			}
			if (vipGrade.equals(vipgradeid) || medicalNo.equals(gravidaInfo.get(i).get("medicalRecordNo").toString())) {
				map.put("mid", mid);
				map.put("gname", gravidaInfo.get(i).get("gName").toString());
				map.put("medicalRecordNo", gravidaInfo.get(i).get("medicalRecordNo").toString());
				map.put("expectedConfinement", gravidaInfo.get(i).get("expectedConfinement").toString());
				map.put("vipGradeName", vipgradeid);
				map.put("age", "25");
				if (shou != null && shu != null && checkDetail != null) {
					if (Double.parseDouble(shou.get(0).get("abnormity").toString()) <= (double) Double
							.parseDouble(checkindex.get("cbegin").toString())) {
						check = "收缩压<90mmHg";
					} else if (Double.parseDouble(shou.get(0).get("abnormity").toString()) >= (double) Double
							.parseDouble(checkindex.get("cend").toString())) {
						check = "收缩压≥140mmHg";
					}
					if (Double.parseDouble(shu.get(0).get("abnormity").toString()) <= (double) Double
							.parseDouble(checkindex2.get("cbegin").toString())) {
						checkShu = "舒张压<60mmHg";
					} else if (Double.parseDouble(shu.get(0).get("abnormity").toString()) >= (double) Double
							.parseDouble(checkindex2.get("cend").toString())) {
						checkShu = "舒张压≥90mmHg";
					}
					if (Double.parseDouble(checkDetail.getCheckvalue().toString()) <= (double) Double
							.parseDouble(checkindex3.get("cbegin").toString())) {
						checkPiss = "尿蛋白<20mg/L";
					} else if (Double.parseDouble(checkDetail.getCheckvalue().toString()) >= (double) Double
							.parseDouble(checkindex3.get("cend").toString())) {
						checkPiss = "尿蛋白≥30mg/L";
					}
					map.put("highRiskResultType", shou.get(0).get("highRiskResultType").toString());
					map.put("shu", checkShu);
					map.put("check", check);
					map.put("check", checkPiss);
				}
				mapList.add(map);
			}
		}
		// System.out.println("map@:" + mapList);
		return new JsonResult(mapList);
	}

}
