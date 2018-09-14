package cn.yunji.doctormanager.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Abnormityinfo;
import cn.yunji.doctormanager.entity.FamilyMember;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.OrderDetails;
import cn.yunji.doctormanager.entity.WeightTest;
import cn.yunji.doctormanager.entity.vipOrder;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.FamilyMemberService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.HighriskTestService;
import cn.yunji.doctormanager.service.OrderDetailsService;
import cn.yunji.doctormanager.service.VipOrderService;
import cn.yunji.doctormanager.service.WeightTestService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 
 * 孕妇信息 Controller，
 * 
 * @author zhangqt
 * @CreateDate 2017年10月13日 下午4:47:19
 */
@Controller
@RequestMapping("/gravidainfo")
public class GravidaInfoController {

	@Resource
	private GravidaInfoService gravidaInfoService;
	@Resource
	private FamilyMemberService familyMemberService;
	@Resource
	private WeightTestService weightTestService;
	@Resource
	private VipOrderService vipOrderService;
	@Resource
	private OrderDetailsService orderDetailsService;

	/**
	 * 查询指定孕妇的信息 访问地址：doctormanager/gravidainfo/find.do
	 * 
	 * @param mid
	 *            孕妇id
	 * @return JsonResult(gravidainfo对象)
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@ResponseBody
	@RequestMapping("/find.do")
	public JsonResult find(String mid) {
		GravidaInfo gravidainfo = gravidaInfoService.find(mid);
		return new JsonResult(gravidainfo);
	}

	/**
	 * 以账号（手机号码）查询出 mid 访问地址：doctormanager/gravidainfo/queryByUserPhone.do
	 * 
	 * @param phone
	 *            账号（手机号码）手机号码
	 * @return mid 孕妇id
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@ResponseBody
	@RequestMapping("/queryByUserPhone.do")
	public String queryByUserPhone(String phone) {
		String mid = gravidaInfoService.queryByUserPhone(phone);
		return mid;
	}
	
	@ResponseBody
	@RequestMapping("/selectByPrimaryKey2.do")
	public JsonResult selectByPrimaryKey2(Integer userid) {
		GravidaInfo record = gravidaInfoService.selectByPrimaryKey2(userid);
		return new JsonResult(record);
	}

	/**
	 * 以孕妇id查询出建档医院 访问地址：doctormanager/gravidainfo/queryHospitalByMid.do
	 * 
	 * @param mid
	 *            孕妇id
	 * @return JsonResult(Map<String, Object>)
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@ResponseBody
	@RequestMapping("/queryHospitalByMid.do")
	public JsonResult findByMid(String mid) {
		Map<String, Object> map = gravidaInfoService.findByMid(mid);
		return new JsonResult(map);
	}

	/**
	 * 查询出开通了vip的孕妇列表 访问地址：doctormanager/gravidainfo/queryByVip.do
	 * 
	 * @param vipGradeid
	 *            vip等级id(可选)，作为条件，如填写，则返回指定等级的vip用户
	 * @param medicalrecordno
	 *            病历号(可选)，作为条件，如填写，则返回指定的用户
	 * @return JsonResult(Map<String, Object>)
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@ResponseBody
	@RequestMapping("/queryByVip.do")
	public Map queryByVip(String gname, String medicalrecordno, Integer vipGrade, Integer sweeks, Integer eweeks, Integer pageIndex, Integer pageSize) {
		if (medicalrecordno == "")
			medicalrecordno = null;
		if (vipGrade != null) {
			if (vipGrade == -1) {
				vipGrade = null;
			}
		}
		if (sweeks == -1) sweeks = null;
		Date expectedconfinement = new Date();
		Long expected = expectedconfinement.getTime();
		Date end = null;
		Date begin = null;
		if (sweeks != null) {
			begin = new Date(expected - SEVEN_DAY * (eweeks));
			end = new Date(expected - SEVEN_DAY * (sweeks));
		}
		Date cur = new Date();
		List<Map<String, Object>> gravidaInfos = gravidaInfoService.queryByVip(gname, medicalrecordno, vipGrade, begin, end, pageIndex, pageSize,cur);
		for (Map<String, Object> map : gravidaInfos) {
			map.put("risklist", getabnormity(map.get("mId").toString()));
		}
		Map s = new HashMap();
		int i = gravidaInfoService.getVipCount(gname, medicalrecordno, vipGrade, begin, end ,cur);
		s.put("total", i);
		s.put("rows", gravidaInfos);
		JsonResult jr = new JsonResult(s);
		return s;
	}

	// 七天的long值
	Long SEVEN_DAY = 7 * 24 * 60 * 60 * 1000L;

	/**
	 * 以孕周范围、孕妇id查询出体重的数据 访问地址：doctormanager/gravidainfo/findWeight.do
	 * 
	 * @param mid
	 *            孕妇id
	 * @param eWeeks
	 *            结束孕周
	 * @param sWeeks
	 *            开始孕周
	 * @return JsonResult(List)
	 * @author luoyc
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@RequestMapping("/findWeight.do")
	@ResponseBody
	public JsonResult findWeight(String mid, Integer eWeeks, Integer sWeeks) {
		GravidaInfo gravidaInfo = gravidaInfoService.find(mid);
		Date expectedconfinement = gravidaInfo.getExpectedconfinement();
		if(expectedconfinement==null){
			return null;
		}
		Integer height = gravidaInfo.getGhigh();
		Long expected = expectedconfinement.getTime();
		// 孕一周起点的long值
		Long start = expected - SEVEN_DAY * 40;
		// System.out.println(firstWeek);
		List<WeightTest> AllweightTestList = gravidaInfo.getWeightTestList();
		List<WeightTest> weightTestList = new ArrayList<WeightTest>();
		if (eWeeks == null || sWeeks == null) {
			weightTestList = AllweightTestList;
		} else {
			weightTestList = findByWeekly(mid, eWeeks, sWeeks);
		}

		// System.out.println(weightTestList.size());
		// System.out.println(weightTestList.get(4).getWdate().getTime());
		// System.out.println(expected-SEVEN_DAY*40);
		// System.out.println(expected-SEVEN_DAY*(40-1));
		List<Integer> gestationalWeeks = new ArrayList();
		List<String> weightAdd = new ArrayList();
		// 体重增加上限
		List<String> weightAddLimit = new ArrayList();
		int index = 0;
		Double weightAve;
		double weightSum;
		DecimalFormat df = new DecimalFormat("0.0");
		// 孕前体重
		double bgw = 45;
		if (AllweightTestList.size() != 0) {
			bgw = Double.parseDouble(AllweightTestList.get(0).getPregnancy());
		}
		for (int j = 1; j < 43; j++) {
			// 每次循环先把值归0
			index = 0;
			weightAve = 0.0;
			weightSum = 0.0;
			// 判断插入数据日期属于哪个孕周
			for (int i = 1; i < weightTestList.size(); i++) {
				if (weightTestList.get(i).getWdate().getTime() >= start + SEVEN_DAY * (j - 1)
						&& weightTestList.get(i).getWdate().getTime() < start + SEVEN_DAY * j) {
					// System.out.println("i:"+i+"j:"+j);
					// 记录次数
					index++;
					gestationalWeeks.add(j - 1);
					// 将每周提交的体重值都加起来
					weightSum += Double.parseDouble(weightTestList.get(i).getPregnancy());
				}
			}
			if (index != 0) {
				weightAve = weightSum / index;
				weightAdd.add(df.format(weightAve));
			}
		}
		// System.out.println(weightAdd);
		// System.out.println(gestationalWeeks);
		// 删除重复的孕周
		for (int i = 0; i < gestationalWeeks.size() - 1; i++) {
			for (int j = gestationalWeeks.size() - 1; j > i; j--) {
				if (gestationalWeeks.get(j).equals(gestationalWeeks.get(i))) {
					gestationalWeeks.remove(j);
				}
			}
		}
		// 孕妇体重增加上限
		for (Integer i : gestationalWeeks) {
			if (i == 8) {
				weightAddLimit.add(0.5 + bgw + "");
			} else if (i == 9) {
				weightAddLimit.add(0.7 + bgw + "");
			} else if (i == 10) {
				weightAddLimit.add(0.9 + bgw + "");
			} else if (i == 11) {
				weightAddLimit.add(1.1 + bgw + "");
			} else if (i == 12) {
				weightAddLimit.add(1.4 + bgw + "");
			} else if (i == 13) {
				weightAddLimit.add(1.7 + bgw + "");
			} else if (i == 14) {
				weightAddLimit.add(2.0 + bgw + "");
			} else if (i == 15) {
				weightAddLimit.add(2.3 + bgw + "");
			} else if (i == 16) {
				weightAddLimit.add(2.7 + bgw + "");
			} else if (i == 17) {
				weightAddLimit.add(3.0 + bgw + "");
			} else if (i == 18) {
				weightAddLimit.add(3.4 + bgw + "");
			} else if (i == 19) {
				weightAddLimit.add(3.8 + bgw + "");
			} else if (i == 20) {
				weightAddLimit.add(4.3 + bgw + "");
			} else if (i == 21) {
				weightAddLimit.add(4.7 + bgw + "");
			} else if (i == 22) {
				weightAddLimit.add(5.1 + bgw + "");
			} else if (i == 23) {
				weightAddLimit.add(5.5 + bgw + "");
			} else if (i == 24) {
				weightAddLimit.add(5.9 + bgw + "");
			} else if (i == 25) {
				weightAddLimit.add(6.4 + bgw + "");
			} else if (i == 26) {
				weightAddLimit.add(6.8 + bgw + "");
			} else if (i == 27) {
				weightAddLimit.add(7.2 + bgw + "");
			} else if (i == 28) {
				weightAddLimit.add(7.4 + bgw + "");
			} else if (i == 29) {
				weightAddLimit.add(7.7 + bgw + "");
			} else if (i == 30) {
				weightAddLimit.add(8.1 + bgw + "");
			} else if (i == 31) {
				weightAddLimit.add(8.4 + bgw + "");
			} else if (i == 32) {
				weightAddLimit.add(8.8 + bgw + "");
			} else if (i == 33) {
				weightAddLimit.add(9.1 + bgw + "");
			} else if (i == 34) {
				weightAddLimit.add(9.5 + bgw + "");
			} else if (i == 35) {
				weightAddLimit.add(10.0 + bgw + "");
			} else if (i == 36) {
				weightAddLimit.add(10.4 + bgw + "");
			} else if (i == 37) {
				weightAddLimit.add(10.5 + bgw + "");
			} else if (i == 38) {
				weightAddLimit.add(11 + bgw + "");
			} else if (i == 39) {
				weightAddLimit.add(11.3 + bgw + "");
			} else if (i == 40) {
				weightAddLimit.add(11.4 + bgw + "");
			} else if (i == 41) {
				weightAddLimit.add(11.5 + bgw + "");
			} else {
				weightAddLimit.add(0.0 + bgw + "");
			}
		}
		// System.out.println(gestationalWeeks);
		List weightoringinlist = new ArrayList();
		for (int i = 0; i < weightTestList.size(); i++) {
			weightoringinlist.add(weightTestList.get(i).getPregnancy());
		}
		List list = new ArrayList();
		list.add(gestationalWeeks);
		list.add(weightAdd);
		list.add(weightAddLimit);
		list.add(weightoringinlist);
		list.add(height);
		return new JsonResult(list);
	}

	/**
	 * 查询所有的孕妇 访问地址：doctormanager/gravidainfo/findAll.do
	 * 
	 * @return JsonResult(gravidaInfo)
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@RequestMapping("/findAll.do")
	@ResponseBody
	public JsonResult findAll() {
		List<GravidaInfo> gravidaInfo = gravidaInfoService.findAll();
		return new JsonResult(gravidaInfo);
	}

	/**
	 * 返回备孕人数 访问地址：doctormanager/gravidainfo/getPregnancyCount.do
	 * 
	 * @param state(int类型)
	 *            1 为备孕 2为怀孕 3为育儿
	 * @return int
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	// 获取备孕人员的数量
	@RequestMapping("/getPregnancyCount.do")
	@ResponseBody
	public int getPregnancyCount(int state) {
		int count;
		if (state == 0) {
			count = gravidaInfoService.getPregnancyCount1();
		} else {
			count = gravidaInfoService.getPregnancyCount2();
		}

		return count;
	}

	/**
	 * 查询孕妇列表，medicalrecordno(病历号)、vipGrade(vip等级)、sweeks(开始孕周)、eweeks(结束孕周)
	 * 、Integer(医生id)、pageIndex(*页码)、pageSize(*显示条数)可以作为条件查询
	 * 访问地址：doctormanager/gravidainfo/findByPage.do
	 * 
	 * @param medicalrecordno(病历号)
	 *            vipGrade(vip等级) sweeks(开始孕周) eweeks(结束孕周) Integer(医生id)
	 *            pageIndex(*页码) pageSize(*显示条数)
	 * @return JsonResult(List<Map<String, Object>>)
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@RequestMapping("/findByPage.do")
	@ResponseBody
	public Map findByPage(String gname,String birthYears, String medicalrecordno, Integer vipGrade, Integer sweeks, Integer eweeks,
			Integer doctor, Integer pageIndex, Integer pageSize, String sortName, String sortOrder,
			String patientTypeId, String adviceState, String weeklyState, String processingState,String edate, String serviceType) {
		
		String sbirth = null;
		String ebirth = null;
		if(birthYears != null){
			sbirth = (Integer.parseInt(birthYears)-1) + "-06-01";
			ebirth = birthYears + "-06-01";
		}
		if (medicalrecordno == "")
			medicalrecordno = null;
		if (vipGrade != null) {
			if (vipGrade == -1) {
				vipGrade = null;
			}
		}
		if (sweeks == -1)
			sweeks = null;
		Date expectedconfinement = new Date();
		Long expected = expectedconfinement.getTime();
		Date end = null;
		Date begin = null;
		if (sweeks != null) {
			begin = new Date(expected - SEVEN_DAY * (eweeks));
			end = new Date(expected - SEVEN_DAY * (sweeks));
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String, Object>> gravidaInfos = gravidaInfoService.findByPage(gname,sbirth,ebirth, medicalrecordno, vipGrade, begin,
				end, doctor, pageIndex, pageSize, sortName, sortOrder, patientTypeId, adviceState, weeklyState,
				processingState,edate, serviceType);

		for (Map<String, Object> map : gravidaInfos) {
			map.put("risklist", getabnormity(map.get("mId").toString()));
		}
		Map s = new HashMap();
		int i = gravidaInfoService.getDateCount1(gname,sbirth,ebirth, medicalrecordno, vipGrade, begin, end, doctor, patientTypeId,
				adviceState, weeklyState, processingState,edate , serviceType);
		s.put("total", i);
		s.put("rows", gravidaInfos);
		JsonResult jr = new JsonResult(s);
		return s;
	}

	/*
	 * @author zhangqt 
	 * 
	 * @p
	 */
	@Resource
	private HighriskTestService highriskTestService;
	@Resource
	private AbnormityinfoService abnormityinfoService;

	@RequestMapping("/getabnormity.do")
	@ResponseBody
	public List<Map<String, Object>> getabnormity(String mid) {
		// 声明返回的类型
		Map<String, Object> map1;

		// 自评的异常
		List<Map<String, Object>> list1 = highriskTestService.findByMid(mid);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : list1) {
			map1 = new HashMap<String, Object>();
			map1.put("abnormity", map.get("highRiskProblem"));
			map1.put("checkDate", map.get("ResultDate"));
			map1.put("riskscore", map.get("ProblemScore"));
			map1.put("cname", "");
			map1.put("factortype", 3);
			list.add(map1);
		}
		List<Abnormityinfo> list2 = abnormityinfoService.queryByMidAll(mid);
		for (Abnormityinfo ab : list2) {
			map1 = new HashMap<String, Object>();
			String cunit = ab.getCheckindex().getCunit();
			map1.put("abnormity", ab.getAbnormity() + cunit);
			map1.put("checkDate", ab.getCheckdate());
			Integer score = ab.getScore();
			// 分数为空时，默认给五分
			if (score == null) {
				score = 5;
			}
			map1.put("riskscore", score);
			String cname = ab.getCheckindex().getCname();
			cname = cname.replace("自测", "");
			map1.put("cname", cname);
			if (ab.getCheckproject() != null) {
				map1.put("factortype", ab.getCheckproject().getCheckType());
			} else {
				map1.put("factortype", 4);
			}
			list.add(map1);
		}
		System.out.println(list);
		return list;
	}

	/**
	 * 查询孕妇列表，medicalrecordno(病历号)、vipGrade(vip等级)、sweeks(开始孕周)、eweeks(结束孕周)
	 * 、Integer(医生id)可以作为条件查询 访问地址：doctormanager/gravidainfo/findByPage.do
	 * 
	 * @param state(int类型)
	 *            1 为备孕 2为怀孕 3为育儿
	 * @return 孕妇sum
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@RequestMapping("/getDateCount1.do")
	@ResponseBody
	public int getDateCount1(String gname,String birthYears, String medicalrecordno, Integer vipGrade, Integer sweeks, Integer eweeks,
			Integer doctor, String patientTypeId, String adviceState, String weeklyState, String processingState,String edate, String serviceType) {
		String sbirth = null;
		String ebirth = null;
		if(birthYears != null){
			sbirth = birthYears + "01-01";
			ebirth = birthYears + "12-30";
		}
		if (doctor != null) {
			if (doctor == -1) {
				doctor = null;
			}
		}
		if (medicalrecordno == "")
			medicalrecordno = null;
		if (vipGrade != null) {
			if (vipGrade == -1) {
				vipGrade = null;
			}
		}
		if (sweeks == -1)
			sweeks = null;
		Date expectedconfinement = new Date();
		Long expected = expectedconfinement.getTime();
		Date end = null;
		Date begin = null;
		if (sweeks != null) {
			begin = new Date(expected - SEVEN_DAY * (eweeks));
			end = new Date(expected - SEVEN_DAY * (sweeks));
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		int i = gravidaInfoService.getDateCount1(gname,sbirth,ebirth,medicalrecordno, vipGrade, begin, end, doctor, patientTypeId,
				adviceState, weeklyState, processingState,edate, serviceType);
		return i;
	}

	@ResponseBody
	@RequestMapping("/addBase.do")
	public void addBase(GravidaInfo gravidainfo, FamilyMember familyMember) {
		// System.out.println(gravidainfo);
		// System.out.println(familyMember);
		gravidaInfoService.addGravidainfo(gravidainfo);
		familyMemberService.addFamilyMember(familyMember);
	}

	@ResponseBody
	@RequestMapping("/addGravidaInfo.do")
	public int addGravidaInfo(GravidaInfo gravidainfo) {
		// gravidainfo=getWeeks(gravidainfo);
		// System.out.println(gravidainfo);
		return gravidaInfoService.addGravidainfo(gravidainfo);
	}

	@ResponseBody
	@RequestMapping("/update.do")
	public int update(GravidaInfo gravidainfo) throws ParseException {
		// gravidainfo=getWeeks(gravidainfo);
		// System.out.println(gravidainfo);

		return gravidaInfoService.updateGravidainfo(gravidainfo);
	}

	// 计算建档孕周
	public GravidaInfo getWeeks(GravidaInfo gravidainfo) {
		// 建档日期
		java.util.Date recordDate = gravidainfo.getRecorddate();
		// 末次月经期
		java.util.Date endDate = gravidainfo.getEnddate();
		Calendar calendar = Calendar.getInstance();
		if (endDate != null && recordDate != null) {
			calendar.setTime(endDate);
			int cnt = 0;// 相差天数,建档时怀孕天数
			while (calendar.getTime().compareTo(recordDate) != 0) {
				calendar.add(Calendar.DATE, 1);
				cnt++;
			}

			// 计算建档孕周
			int weeks = (int) ((cnt - 1) / 7) + (cnt - 1) % 7;
			gravidainfo.setWeeks(weeks);
		}
		return gravidainfo;
	}

	public List<WeightTest> findByWeekly(String mid, Integer eWeeks, Integer sWeeks) {
		GravidaInfo gravidaInfo = gravidaInfoService.find(mid);
		Date expectedconfinement = gravidaInfo.getExpectedconfinement();
		Long expected = expectedconfinement.getTime();
		Date end = new Date(expected - SEVEN_DAY * (40 - eWeeks));
		Date begin = new Date(expected - SEVEN_DAY * (40 - sWeeks));
		List<WeightTest> list = weightTestService.findByDateRange(mid, begin, end);
		return list;
	}

	@ResponseBody
	@RequestMapping("/updateGravida.do")
	public JsonResult updateGravida(String mid, String gname, String hospitalid, String bhospitalid,
			String monthpresidenceaddress, String monthpresentaddress, Integer medicalcardtype,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date expectedconfinement,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date recorddate, String recordno, Integer registertype,
			Integer attribution, Integer doctor, @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthYears, String distance, Integer husband_condition,
			Integer poor, Integer family_gdp, Integer postalcode, Integer household_register, Integer town,
			String domicile, String wedlock, Integer marry_age, Integer inoculation_history, String medical_insurance,
			String agricultural) {
		int n = gravidaInfoService.updateGra(mid, gname, hospitalid, bhospitalid, monthpresidenceaddress,
				monthpresentaddress, medicalcardtype, expectedconfinement, recorddate, recordno, registertype,
				attribution, doctor, enddate, birthYears, distance, husband_condition, poor, family_gdp, postalcode,
				household_register, town, domicile, wedlock, marry_age, inoculation_history, medical_insurance,
				agricultural);
		return new JsonResult(n);
	}

	// 查询建档的信息
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/findMessage.do") public JsonResult findMessage(String
	 * mid) { GravidaInfo gravidainfo = gravidaInfoService.findMessage(mid);
	 * 
	 * return new JsonResult(gravidainfo); }
	 */

	// 添加或者更新孕妇信息
	@ResponseBody
	@RequestMapping("/addOrUpdateInfo.do")
	public int addOrUpdateInfo(GravidaInfo gravidainfo, int vipid, String phone) throws ParseException {
		int i = gravidaInfoService.addOrUpdateInfo(gravidainfo);
		String mid = gravidaInfoService.getMid(phone);
		// 添加信息到家庭成员中
		FamilyMember f = new FamilyMember();
		f.setMid(mid);
		f.setRelationid(1);
		f.setPhone(phone);
		f.setName(gravidainfo.getGname());
		f.setBirthYears(gravidainfo.getBirthYears());
		familyMemberService.addFamilyMember(f);
		//开通
		createOrder(mid,vipid);
		return i;
	}

	/**
	 * 开通套餐
	 * @param mid 孕妇id vipid
	 * @return int
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	public void createOrder(String mid, int vipid) throws ParseException {
		// 创建订单vipOrder
		vipOrder vip = new vipOrder();
		vip.setMid(mid);// 孕妇id
		vip.setVodername("vip");// 套餐名称
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String str1 = s.format(date);// 当前的时间
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 30);// 计算30天后的时间
		String str2 = s.format(c.getTime());
		vip.setSdate(s.parse(str1));// 套餐开始时间
		vip.setEdate(s.parse(str2));// 套餐结束时间
		vip.setVipid(vipid);// 套餐id
		vip.setVoderdate(s.parse(str1));// 订单创建时间
		vipOrderService.addOrder(vip);

		// 创建订单明细
		OrderDetails od;
		if (vipid == 100) {// 套餐A
			od = new OrderDetails();
			od.setOvipid(vip.getOvipid());// 套餐编号
			od.setProcessingstate(0);// 处理状态，默认为未处理
			od.setServicetype(3);// 服务类型，，3为周报
			String str4 = str1;
			Calendar c1 = Calendar.getInstance();
			for (int j = 1; j < 5; j++) {// 默认创建4个周报
				c1.add(Calendar.DATE, 7);// 默认每周发送一次报告
				String str3 = s.format(c1.getTime());
				if (j == 4) {
					str3 = str2;
				}
				od.setStartdate(s.parse(str4));// 远程周报开始时间
				str4 = str3;
				od.setExpiredate(s.parse(str3));// 远程周报结束时间
				orderDetailsService.insert(od);
			}
		}

		if (vipid == 101) {// 套餐B
			// 创建一个发送医嘱明细
			od = new OrderDetails();
			od.setOvipid(vip.getOvipid());// 套餐编号
			od.setProcessingstate(0);// 处理状态，默认为未处理
			// 默认每月发送一次医嘱
			od.setStartdate(s.parse(str1));// 医嘱发送开始时间
			od.setExpiredate(s.parse(str2));// 医嘱发送结束时间
			od.setServicetype(1);// 服务类型，，1为医嘱
			orderDetailsService.insert(od);

			// 创建3个远程问诊明细
			od = new OrderDetails();
			od.setOvipid(vip.getOvipid());// 套餐编号
			od.setProcessingstate(0);// 处理状态，默认为未处理
			String str4 = str1;
			od.setServicetype(2);// 服务类型，，2为问诊
			Calendar c1 = Calendar.getInstance();
			for (int j = 1; j < 4; j++) {// 默认创建3次远程问诊
				c1.add(Calendar.DATE, j * 7);// 默认每周可以预约一次问诊
				String str3 = s.format(c1.getTime());
				if (j == 3) {
					str3 = str2;
				}
				od.setStartdate(s.parse(str4));// 远程问诊开始时间
				str4 = str3;
				od.setExpiredate(s.parse(str3));// 远程问诊预约结束时间
				orderDetailsService.insert(od);
			}
		}
	}

	/**
	 * 医生审核建档信息
	 * 
	 * @param mid孕妇id
	 * @param did医生id
	 * @return int
	 * @author zhangqt
	 * @createDate 2017年10月26日 下午4:48:50
	 */
	@ResponseBody
	@RequestMapping("/examineInfo.do")
	public int examineInfo(String mid, Integer did) {
		int i = gravidaInfoService.examineInfo(mid, did);
		return i;
	}
	/*
	 * @author hongwx
	 * 根据孕周查询相对应的自测信息等
	 * @p
	 */
	@RequestMapping("/getabnormitybyweeks.do")
	@ResponseBody
	public List<Map<String, Object>> getabnormitybyweeks(String mid,String begintime,String endtime) {
		// 声明返回的类型
		Map<String, Object> map1;
		//factortype: 0:化验，1：基因，2：症状，3：高危自评，4：自测
		// 自评的异常
		List<Map<String, Object>> list1 = highriskTestService.findByMidandweeks(mid, begintime, endtime);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : list1) {
			map1 = new HashMap<String, Object>();
			map1.put("abnormity", map.get("highRiskProblem"));
			map1.put("checkDate", map.get("ResultDate"));
			map1.put("riskscore", map.get("ProblemScore"));
			map1.put("cname", "");
			map1.put("factortype", 3);
			list.add(map1);
		}
		List<Abnormityinfo> list2 = abnormityinfoService.selectByWeeks(mid, begintime, endtime);
		for (Abnormityinfo ab : list2) {
			map1 = new HashMap<String, Object>();
			String cunit = ab.getCheckindex().getCunit();
			map1.put("abnormity", ab.getAbnormity() + cunit);
			map1.put("checkDate", ab.getCheckdate());
			Integer score = ab.getScore();
			// 分数为空时，默认给五分
			if (score == null) {
				score = 5;
			}
			map1.put("riskscore", score);
			String cname = ab.getCheckindex().getCname();
			cname = cname.replace("自测", "");
			map1.put("cname", cname);
			if (ab.getCheckproject() != null) {
				map1.put("factortype", ab.getCheckproject().getCheckType());
			} else {
				map1.put("factortype", 4);
			}
			list.add(map1);
		}
		return list;
	}


}
