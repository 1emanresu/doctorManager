package cn.yunji.doctormanager.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Abnormityinfo;
import cn.yunji.doctormanager.entity.CheckProject;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.CheckProjectService;
import cn.yunji.doctormanager.util.JsonResult;

//异常信息
@Controller
@RequestMapping("/abnormityinfo")
public class AbnormityinfoController {
	@Resource
	private AbnormityinfoService abnormityinfoService;
	@Resource
	private CheckProjectService checkProjectService;
	Long SEVEN_DAY = 7 * 24 * 60 * 60 * 1000L;

	/**
	 * web周报——查询最近一周孕妇上传的数据中所有的异常信息。
	 * 
	 * @author luoyc
	 * @param mid
	 * @return
	 */
	@RequestMapping("/findWeeklyAbnormityinfo.do")
	@ResponseBody
	public JsonResult findWeeklyAbnormityinfo(String mid,Date uploaddate) {
		// 所有的异常报告
		List<List<List>> checkReportList = new ArrayList<List<List>>();
		// 一份报告的所有异常数据
		List<List> checkDetailList;
		// 单独的一条异常数据
		List checkDetail;
		Abnormityinfo abnormityinfo = new Abnormityinfo();
		CheckProject checkProject = new CheckProject();
		Integer checkResultId = 0;
		// 当前时间往后7天的范围，搜索异常
		Date end = new Date();
		Date begin = new Date(end.getTime() - SEVEN_DAY);
		if(uploaddate!=null){
		    end=uploaddate;
		    begin=new Date(uploaddate.getTime() - SEVEN_DAY);
		}
		List<Abnormityinfo> abnormityinfoList = abnormityinfoService.findByDateRange(mid, begin, end);
		for (int i = 0; i < abnormityinfoList.size(); i++) {
			// 初始化一个新的异常信息报告List
			checkDetailList = new ArrayList<List>();
			abnormityinfo = abnormityinfoList.get(i);
			// 根据Id获取项目名称
			checkProject = checkProjectService.selectByPrimaryKey(abnormityinfo.getCheckprojectid());
			if (checkProject != null && checkProject.getFroms() == 1) {
				checkDetail = new ArrayList();
				checkResultId = abnormityinfo.getResultid();
				// 报告的类型
				checkDetail.add(checkProject.getRiskname());
				// 前端页面表格的第一个<td>的内容
				checkDetail.add(abnormityinfo.getCheckindex().getCname());
				// 报告存在偏差值的
				if (abnormityinfo.getDeviation() != null
						&& !abnormityinfo.getDeviation().toString().trim().equals("")) {
					// 前端页面表格的第二个<td>的内容，依次类推
					if (abnormityinfo.getDeviation() > 0) {
						checkDetail.add(abnormityinfo.getAbnormity() + "↑");
					} else {
						checkDetail.add(abnormityinfo.getAbnormity() + "↓");
					}
				} else {
					checkDetail.add(abnormityinfo.getAbnormity());
				}
				if (abnormityinfo.getCheckindex().getCunit() != null) {
					checkDetail.add(abnormityinfo.getCheckindex().getCunit());
				} else {
					checkDetail.add("");
				}
				if (abnormityinfo.getCheckindex().getReferencevalue() != null) {
					checkDetail.add(abnormityinfo.getCheckindex().getReferencevalue());
				} else {
					checkDetail.add("");
				}
				checkDetailList.add(checkDetail);
				if (i == abnormityinfoList.size() - 1) {
					checkReportList.add(checkDetailList);
				}
				// 不改变数组长度，将项目ID改为0避免往数组中插入重复的数据。
				abnormityinfo.setCheckprojectid(0);
				abnormityinfoList.set(i, abnormityinfo);
			}
			// 第一个循环没获取到异常报告项目，直接跳过第二个循环
			if (!checkDetailList.isEmpty()) {
				for (int j = abnormityinfoList.size() - 1; j > i; j--) {
					// 来自同一个检查结果的放到一起
					if (checkResultId == abnormityinfoList.get(j).getResultid()) {
						abnormityinfo = abnormityinfoList.get(j);
						checkDetail = new ArrayList();
						// 根据Id获取项目名称
						checkProject = checkProjectService.selectByPrimaryKey(abnormityinfo.getCheckprojectid());
						// 报告的类型
						checkDetail.add(checkProject.getRiskname());
						// 前端页面表格的第一个<td>的内容
						checkDetail.add(abnormityinfo.getCheckindex().getCname());
						// 报告存在偏差值的
						if (abnormityinfo.getDeviation() != null
								&& !abnormityinfo.getDeviation().toString().trim().equals("")) {
							// 前端页面表格的第二个<td>的内容，依次类推
							if (abnormityinfo.getDeviation() > 0) {
								checkDetail.add(abnormityinfo.getAbnormity() + "↑");
							} else {
								checkDetail.add(abnormityinfo.getAbnormity() + "↓");
							}
						} else {
							checkDetail.add(abnormityinfo.getAbnormity());
						}
						if (abnormityinfo.getCheckindex().getCunit() != null) {
							checkDetail.add(abnormityinfo.getCheckindex().getCunit());
						} else {
							checkDetail.add("");
						}
						if (abnormityinfo.getCheckindex().getReferencevalue() != null) {
							checkDetail.add(abnormityinfo.getCheckindex().getReferencevalue());
						} else {
							checkDetail.add("");
						}
						checkDetailList.add(checkDetail);
						// 不改变数组长度，将项目ID改为0避免往数组中插入重复的数据。
						abnormityinfo.setCheckprojectid(0);
						abnormityinfoList.set(j, abnormityinfo);
					}
					if (j == i + 1) {
						checkReportList.add(checkDetailList);
					}
				}
			}
		}
		return new JsonResult(checkReportList);
	}

	/**
	 * 根据上传日期查找指定孕妇的异常数据
	 * @author luoyc
	 * @param mid
	 * @param uploaddate
	 * @return
	 */
	@RequestMapping("/findWeeklyAbnormityinfo2.do")
	@ResponseBody
	public JsonResult findWeeklyAbnormityinfo2(String mid, Date uploaddate) {
		Date begin = new Date(uploaddate.getTime() - SEVEN_DAY);
		List<Abnormityinfo> abnormityinfoList = abnormityinfoService.findByDateRange(mid, begin, uploaddate);
		List<List> resultList = new ArrayList();
		List<Abnormityinfo> selftestList=new ArrayList();
		List<Abnormityinfo> hospitalProjectList=new ArrayList();
		Abnormityinfo abnormityinfo = new Abnormityinfo();
		CheckProject checkProject;
		for (int i = 0; i < abnormityinfoList.size(); i++) {
			abnormityinfo = abnormityinfoList.get(i);
			if(abnormityinfo.getCheckproject().getFroms()==0){
			    selftestList.add(abnormityinfo);
			}else if(abnormityinfo.getCheckproject().getFroms()==1){
			    hospitalProjectList.add(abnormityinfo);
			}
		}
		resultList.add(selftestList);
		resultList.add(hospitalProjectList);
		return new JsonResult(resultList);
	}

	/**
	 * 通用异常信息
	 * @param mid 孕妇ID
	 * @param checkDate 检查时间
	 * @param checkProjectId 检查项目ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/query.do")
	@ResponseBody
	public JsonResult query(String mid, String checkDate, Integer checkProjectId) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(checkDate);
		List<Map<String, Object>> list = abnormityinfoService.queryByCheckProjectId(mid, date, checkProjectId);
		return new JsonResult(list);
	}

	@RequestMapping("/queryByMidAll.do")
	@ResponseBody
	public JsonResult queryByMidAll(String mid) {
		List<Abnormityinfo> list=abnormityinfoService.queryByMidAll(mid);
		return new JsonResult(list);
	}

	// 以时间范围来查找异常信息
	@RequestMapping("/queryByDate.do")
	@ResponseBody
	public JsonResult queryByDate(String mid, Integer checkProjectId, String sDate, String eDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(sDate);
		Date date2 = sdf.parse(eDate);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mid", mid);
		map.put("checkProjectId", checkProjectId);
		map.put("sDate", date1);
		map.put("eDate", date2);
		List<Map<String, Object>> list = abnormityinfoService.queryByDate(map);
		return new JsonResult(list);
	}

	// 以孕周范围来查找异常信息
	@RequestMapping("/queryByWeeks.do")
	@ResponseBody
	public JsonResult queryByWeeks(String mid, Integer checkProjectId, int sWeeks, int eWeeks) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mid", mid);
		map.put("checkProjectId", checkProjectId);
		map.put("sWeeks", sWeeks);
		map.put("eWeeks", eWeeks);
		List<Map<String, Object>> list = abnormityinfoService.queryByWeeks(map);
		return new JsonResult(list);
	}

	// 按孕周查询查询孕妇的所有异常并给出相应的医嘱和判断标准
	@RequestMapping("/findByWeeks.do")
	@ResponseBody
	public JsonResult findByWeeks(String mid, int sWeeks, int eWeeks) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mid", mid);
		map.put("sWeeks", sWeeks);
		map.put("eWeeks", eWeeks);
		List<Map<String, Object>> list = abnormityinfoService.findByWeeks(map);
		return new JsonResult(list);
	}

	@RequestMapping("/queryByMid.do")
	@ResponseBody
	// 以孕妇id 与 时间、指标id查询异常信息
	public JsonResult queryByMid(String mid, String date, int cid) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Abnormityinfo e = abnormityinfoService.queryByMid(mid, sdf.parse(date), cid);
		return new JsonResult(e);
	}

	@RequestMapping("/add.do")
	@ResponseBody
	// 添加异常信息
	public int add(Abnormityinfo abnormityinfo, String checkDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// abnormityinfo.setCheckdate1(sdf.parse(checkDate));
		return abnormityinfoService.addAbnormityinfo(abnormityinfo);
	}

	@RequestMapping("/queryByAll.do")
	@ResponseBody
	public JsonResult queryByAll() {
		List<Map<String, Object>> list = abnormityinfoService.queryByAll();
		StringBuilder builder = new StringBuilder();
		for (Map<String, Object> map : list) {
			builder.append(map.get("cname") + ":" + map.get("score") + ":" + map.get("deviation") + ":"
					+ map.get("cunit") + ":");
		}
		list.get(0).put("highScore", builder.toString());
		return new JsonResult(list);
	}

	/**
	 * @methodName queryByDate @description:查询孕妇 ,腹围，B超，血糖，血压 ，体重，胎心,体重,胎动
	 * 及医嘱 @param mid @return JsonResult @throws
	 */
	@RequestMapping("/queryByAllDate.do")
	@ResponseBody
	public JsonResult queryByDate(String mid) {
		Map<String, Object> map = abnormityinfoService.queryByAllDate(mid);
		List<Map<String, Object>> weightTests = abnormityinfoService.queryByWCheckDate(mid);
		List<Map<String, Object>> countQuickenings = abnormityinfoService.queryByCCheckDate(mid);
		map.put("nowPregnancy", weightTests.get(0).get("pregnancy"));
		map.put("lastPregnancy", weightTests.get(1).get("pregnancy"));
		map.put("tdforenoon", countQuickenings.get(0).get("actualClick"));
		map.put("tdafternoon", countQuickenings.get(1).get("actualClick"));
		map.put("tdevening", countQuickenings.get(2).get("actualClick"));
		int[] cids = { 42, 43, 44, 45, 46, 47, 48 };
		List<Map<String, Object>> list = abnormityinfoService.queryByCids(cids);
		for (Map<String, Object> map1 : list) {
			if (Double.parseDouble(map1.get("abnormity").toString()) == Double
					.parseDouble(map.get("nowPregnancy").toString())) {
				int cid = Integer.parseInt(map1.get("cid").toString());
				int hightTypeId = Integer.parseInt(map1.get("highRiskResultTypeId").toString());
				map.put("weightknowledge", abnormityinfoService.querybyCidHightTypeId(cid, hightTypeId));
			}
			if (Double.parseDouble(map1.get("abnormity").toString()) == Double
					.parseDouble(map.get("systolic").toString())) {
				int cid = Integer.parseInt(map1.get("cid").toString());
				int hightTypeId = Integer.parseInt(map1.get("highRiskResultTypeId").toString());
				map.put("systolicKnowledge", abnormityinfoService.querybyCidHightTypeId(cid, hightTypeId));
			}
			if (Double.parseDouble(map1.get("abnormity").toString()) == Double
					.parseDouble(map.get("diastolic").toString())) {
				int cid = Integer.parseInt(map1.get("cid").toString());
				int hightTypeId = Integer.parseInt(map1.get("highRiskResultTypeId").toString());
				map.put("diastolicKnowledge", abnormityinfoService.querybyCidHightTypeId(cid, hightTypeId));
			}
			if (Double.parseDouble(map1.get("abnormity").toString()) == Double
					.parseDouble(map.get("bflun").toString())) {
				int cid = Integer.parseInt(map1.get("cid").toString());
				int hightTypeId = Integer.parseInt(map1.get("highRiskResultTypeId").toString());
				map.put("bflunKnowledge", abnormityinfoService.querybyCidHightTypeId(cid, hightTypeId));
			}
			if (Double.parseDouble(map1.get("abnormity").toString()) == Double
					.parseDouble(map.get("bfdin").toString())) {
				int cid = Integer.parseInt(map1.get("cid").toString());
				int hightTypeId = Integer.parseInt(map1.get("highRiskResultTypeId").toString());
				map.put("bflunKnowledge", abnormityinfoService.querybyCidHightTypeId(cid, hightTypeId));
			}
		}
		return new JsonResult(map);

	}

	/**
	 * @author wuwj @methodName queryByDate @description:查询风险提醒 @param
	 * mid @return JsonResult @throws
	 */
	@RequestMapping("/findriskbymid.do")
	@ResponseBody
	public JsonResult findriskbymid(String mid) {
		List<Map<String, Object>> list = abnormityinfoService.findrisk(mid);
		List<Map<String, Object>> resultlist = new ArrayList<Map<String, Object>>(list.size());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> tempmap = new HashMap<String, Object>();
			String cname = (String) list.get(i).get("cname");
			double deviation = (double) list.get(i).get("deviation");
			String unit = (String) list.get(i).get("cunit");
			String abnormity = (String) list.get(i).get("abnormity");
			tempmap.put("checkdate", sdf.format((Timestamp) list.get(i).get("checkdate")));
			tempmap.put("weeks", (int) list.get(i).get("weeks"));
			if (deviation > 0) {
				tempmap.put("content", cname + "大于正常范围" + Math.abs(deviation) + unit + "，为" + abnormity + unit);
			} else if (deviation < 0) {
				tempmap.put("content", cname + "小于正常范围" + Math.abs(deviation) + unit + "，为" + abnormity + unit);
			}
			resultlist.add(tempmap);
		}
		return new JsonResult(resultlist);
	}

	/**
	 * 查询最近一周自测项目异常次数
	 * 
	 * @author luoyc
	 * @param mid
	 * @param uploaddate
	 * @return
	 */
	@RequestMapping("/findSelfTestAbnormityinfo.do")
	@ResponseBody
	public JsonResult findSelfTestAbnormityinfo(String mid, Date uploaddate) {
		Date begin = new Date(uploaddate.getTime() - SEVEN_DAY);
		List<List> resultList=new ArrayList();
		List<String> tableStr = new ArrayList();
		List<Integer> countTimeList = selfTestCount(mid, 15, begin, uploaddate);
		String str="";
		if (countTimeList.get(0) != 0) {
		    str+="体重偏高" + countTimeList.get(0) + "次</br>";
		}
		if (countTimeList.get(1) != 0) {
		    str+="体重偏低" + countTimeList.get(1) + "次";
		}
		if(!str.equals("")){
		    tableStr=new ArrayList();
		    tableStr.add("体重");
		    tableStr.add(str);
		    tableStr.add("--");
		    resultList.add(tableStr);
		}
		countTimeList = selfTestCount(mid, 16, begin, uploaddate);
		str="";
        if (countTimeList.get(0) != 0) {
            str+="体温偏高" + countTimeList.get(0) + "次</br>";
        }
        if (countTimeList.get(1) != 0) {
            str+="体温偏低" + countTimeList.get(1) + "次";
        }
        if(!str.equals("")){
            tableStr=new ArrayList();
            tableStr.add("体温");
            tableStr.add(str);
            tableStr.add("36.5-38℃");
            resultList.add(tableStr);
        }
		countTimeList = selfTestCount(mid, 18, begin, uploaddate);
		str="";
        if (countTimeList.get(0) != 0) {
            str+="血糖偏高" + countTimeList.get(0) + "次</br>";
        }
        if (countTimeList.get(1) != 0) {
            str+="血糖偏低" + countTimeList.get(1) + "次";
        }
        if(!str.equals("")){
            tableStr=new ArrayList();
            tableStr.add("血糖");
            tableStr.add(str);
            tableStr.add("≤5.1mmol/L");
            resultList.add(tableStr);
        }
		countTimeList = selfTestCount(mid, 19, begin, uploaddate);
		str="";
        if (countTimeList.get(0) != 0) {
            str+="血脂偏高" + countTimeList.get(0) + "次</br>";
        }
        if (countTimeList.get(1) != 0) {
            str+="血脂偏低" + countTimeList.get(1) + "次";
        }
        if(!str.equals("")){
            tableStr=new ArrayList();
            tableStr.add("血脂");
            tableStr.add(str);
            tableStr.add("--");
            resultList.add(tableStr);
        }
		countTimeList = selfTestCount(mid, 21, begin, uploaddate);
		str="";
        if (countTimeList.get(0) != 0) {
            str+="胎动偏高" + countTimeList.get(0) + "次</br>";
        }
        if (countTimeList.get(1) != 0) {
            str+="胎动偏低" + countTimeList.get(1) + "次";
        }
        if(!str.equals("")){
            tableStr=new ArrayList();
            tableStr.add("胎动");
            tableStr.add(str);
            tableStr.add("3-5次");
            resultList.add(tableStr);
        }
		countTimeList = selfTestCount(mid, 23, begin, uploaddate);
		str="";
        if (countTimeList.get(0) != 0) {
            str+="血氧偏高" + countTimeList.get(0) + "次</br>";
        }
        if (countTimeList.get(1) != 0) {
            str+="血氧偏低" + countTimeList.get(1) + "次";
        }
        if(!str.equals("")){
            tableStr=new ArrayList();
            tableStr.add("血氧");
            tableStr.add(str);
            tableStr.add("--");
            resultList.add(tableStr);
        }
		return new JsonResult(resultList);
	}
	//自测数据偏高偏低次数计算
	private List<Integer> selfTestCount(String mid, Integer cpid, Date begin, Date uploaddate) {
		int over = 0;
		int lower = 0;
		List<Abnormityinfo> abnormityList = abnormityinfoService.findByCpidAndMid(mid, cpid, begin, uploaddate);
		for (Abnormityinfo abnormityinfo : abnormityList) {
			if (abnormityinfo.getDeviation() != null && abnormityinfo.getDeviation() > 0) {
				over++;
			} else if (abnormityinfo.getDeviation() != null && abnormityinfo.getDeviation() < 0) {
				lower++;
			}
		}
		List<Integer> intlist = new ArrayList();
		intlist.add(over);
		intlist.add(lower);
		return intlist;
	}
	@RequestMapping("/selectByWeeks.do")
	@ResponseBody
	public JsonResult selectByWeeks(String mid,String begintime,String endtime){
		List<Abnormityinfo> list = abnormityinfoService.selectByWeeks(mid, begintime, endtime);
		return new JsonResult(list);
		
	}
	@RequestMapping("/findByDateRangeCount.do")
    @ResponseBody
    public JsonResult findByDateRangeCount(String mid,String begintime,String endtime) throws ParseException{
	    List<Map> list=new ArrayList();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    Date end = new Date();
        Date begin = new Date(end.getTime() - SEVEN_DAY);
	    if(begintime!=null&&endtime!=null){
	        end=sdf.parse(begintime);
	        begin=sdf.parse(endtime); 
	    } 
	    list = abnormityinfoService.findByDateRangeCount(mid, begin, end);
        return new JsonResult(list);
        
    }
}
