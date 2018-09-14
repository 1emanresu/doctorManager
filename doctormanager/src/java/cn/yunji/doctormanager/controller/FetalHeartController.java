package cn.yunji.doctormanager.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.FetalException;
import cn.yunji.doctormanager.entity.Fetalheart;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.TangScreen;
import cn.yunji.doctormanager.entity.Templatetitle;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.FetalExceptionService;
import cn.yunji.doctormanager.service.FetalHeartService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.TemplatetitleService;
import cn.yunji.doctormanager.util.JsonResult;
import cn.yunji.doctormanager.util.FetalDemo;
import cn.yunji.doctormanager.util.FetalMethod;
import cn.yunji.doctormanager.util.Fischer;
import cn.yunji.doctormanager.util.Krebs;
import cn.yunji.doctormanager.util.NSTscore;

//胎心
@Controller
@RequestMapping("/fetalHeart")
public class FetalHeartController {

	@Resource
	private FetalHeartService fetalHeartService;
	/*
	 * @Resource private CheckindexService checkindexService;
	 * 
	 * @Resource private HighRiskRtandardService highRiskRtandardService;
	 */
	@Resource
	private AbnormityinfoService abnormityinfoService;
	@Resource
	private GravidaInfoService gravidaInfoService;
	@Resource
	private FetalExceptionService fetalExceptionService;
	@Resource
	private TemplatetitleService TemplatetitleService;

	@RequestMapping("/search.do")
	@ResponseBody
	public JsonResult search(Fetalheart fetalheart) {
		// Integer checkProjectId = new Integer(15);
		Fetalheart e = fetalHeartService.search(fetalheart);
		if (null != e) {
			/*
			 * List<Map<String, Object>> list =
			 * abnormityinfoService.queryByCheckProjectId(fetalheart.getMid(),
			 * fetalheart.getCheckdate(),checkProjectId); Map<String, Object>
			 * map = new HashMap<String, Object>(); map.put("result", e);
			 * map.put("list", list);
			 */
			return new JsonResult(e);
		}
		return new JsonResult("");
	}

	@RequestMapping("/checkReportftl.do")
	public String checkReport(Model model) {
		Fetalheart fetalHeart = fetalHeartService.findByMid("dg000001", null);
		GravidaInfo gravidaInfo = gravidaInfoService.find("dg000001");
		if (gravidaInfo != null && fetalHeart != null) {
			model.addAttribute("hospital", "胎心检测结果");
			model.addAttribute("name", gravidaInfo.getGname());
			model.addAttribute("sBloodPressure", fetalHeart.getSbloodpressure());
			model.addAttribute("dBloodPressure", fetalHeart.getDbloodpressure());
			model.addAttribute("aBloodPressure", fetalHeart.getAbloodpressure());
			model.addAttribute("oxygenSaturation", fetalHeart.getOxygensaturation());
			model.addAttribute("frateline", fetalHeart.getFrateline());
			model.addAttribute("fetalMovements", fetalHeart.getFetalmovements());
			model.addAttribute("aperiodicAcceleration", fetalHeart.getAperiodicacceleration());
			model.addAttribute("periodicAcceleration", fetalHeart.getPeriodicacceleration());
			model.addAttribute("apparentAcceleration", fetalHeart.getApparentacceleration());
			model.addAttribute("ED", fetalHeart.getEd());
			model.addAttribute("LD", fetalHeart.getLd());
			model.addAttribute("PD", fetalHeart.getPd());
			model.addAttribute("SVD", fetalHeart.getSvd());
			model.addAttribute("MVD", fetalHeart.getMvd());
			model.addAttribute("cytometaplasia", fetalHeart.getCytometaplasia());
			model.addAttribute("contractions", fetalHeart.getContractions());
			model.addAttribute("famplitude", fetalHeart.getFamplitude());
			model.addAttribute("facceltim", fetalHeart.getFacceltim());
			model.addAttribute("faccelamplitude", fetalHeart.getFaccelamplitude());
			return "FetalHeartCheckReport.ftl";
		}
		return null;
	}

	/**
	 * 按项目查询： 根据检查项目id、mid、检查结果id 查询检查明细及指标 @yinzx
	 * 
	 * @param count
	 *            第几次产检
	 * @param checkProjectId
	 *            检查项目id
	 * @param mId
	 *            孕妇id
	 * @return 查询检查明细及指标
	 */
	@RequestMapping("/queryResultByProject.do")
	@ResponseBody
	public JsonResult queryResultByProject(Integer count, Integer checkProjectId, String mId) {
		List<Fetalheart> flist = fetalHeartService.findByMidAndProject(checkProjectId, mId);
		Date checkDate;
		Fetalheart fetalheart;	    
        Map<String, Object> map = new HashMap<>();
		if(count!=0){    		
    		if (flist.size() >= count) {
    			fetalheart = flist.get(count - 1);
    			List<FetalException> fetalException = fetalExceptionService.queryByFetalheartid(fetalheart.getFid(), mId);
    			if (fetalException != null) {
    				fetalheart.setFlList(fetalException);
    			}
    			checkDate = fetalheart.getCheckdate();
    		} else {
    			fetalheart = flist.get(0);
    			List<FetalException> fetalException = fetalExceptionService.queryByFetalheartid(fetalheart.getFid(), mId);
    			if (fetalException != null) {
    				fetalheart.setFlList(fetalException);
    			}
    			checkDate = fetalheart.getCheckdate();
    		}
    		Templatetitle templatetitle = TemplatetitleService.queryCheckDetailByDate(checkDate, checkProjectId, mId);
    		map.put("fetalheart", fetalheart);
    		if (templatetitle != null) {
    			map.put("templatetitle", templatetitle);
    		}
    		List<Map<String, Object>> list = abnormityinfoService.queryByCheckProjectId(mId, checkDate, checkProjectId);
    		if (list != null) {
    			map.put("abnormityinfo", list);// 异常信息
    		}
		}
		return new JsonResult(map);
	}

	/**
	 * 按孕周查询： 根据检查项目id、mid、孕周 查询检查明细及指标 @yinzx
	 * 
	 * @param weeks
	 *            孕周
	 * @param checkProjectId
	 *            检查项目id
	 * @param mId
	 *            孕妇id
	 * @return 查询检查明细及指标
	 */
	@RequestMapping("/queryResultByWeek.do")
	@ResponseBody
	public JsonResult queryResultByWeek(Integer weeks, Integer checkProjectId, String mId) {
		List<Fetalheart> flist = fetalHeartService.findByMidAndWeek(checkProjectId, mId, weeks);
		if (flist.size() != 0) {
			Fetalheart fetalheart = flist.get(0);

			List<FetalException> fetalException = fetalExceptionService.queryByFetalheartid(fetalheart.getFid(), mId);
			if (fetalException != null) {
				fetalheart.setFlList(fetalException);
			}
			Map<String, Object> map = new HashMap<>();
			map.put("fetalheart", fetalheart);
			return new JsonResult(map);
		}
		return new JsonResult();
	}

	/**
	 * 给定孕周范围、mid、 检查项目id查询检查明细数据
	 * 
	 * @param startWeek
	 *            起始孕周
	 * @param endWeek
	 *            结束孕周
	 * @param checkProjectId
	 *            检查项目id
	 * @param mId
	 *            孕妇id
	 * @return
	 */
	@RequestMapping("/findResultByWeeks.do")
	@ResponseBody
	public JsonResult findResultByWeeks(Integer startWeek, Integer endWeek, Integer checkProjectId, String mId) {
		List<Object> list = new ArrayList<>();
		for (int i = endWeek; i >= startWeek; i--) {
			List<Fetalheart> flist = fetalHeartService.findByMidAndWeek(checkProjectId, mId, i);
			if (flist.size() > 0) {
				Fetalheart fetalheart = flist.get(0);
				if (fetalheart != null) {
					List<FetalException> fetalException = fetalExceptionService.queryByFetalheartid(fetalheart.getFid(),
							mId);
					if (fetalException != null) {
						fetalheart.setFlList(fetalException);
					}
					list.add(fetalheart);
				}
			}

		}

		return new JsonResult(list);
	}

	/**
	 * 根据胎心曲线的坐标集合进行分析 （小孕周胎心分析）
	 * 
	 * @author yinzx
	 * @param ylist
	 *            胎心数据集
	 * @param fMlist
	 *            胎动数据集
	 * @param t
	 *            表示1秒 t个点
	 * @param speedUpTimes
	 *            加速时长（秒） 默认传 15
	 * @param declareTimes
	 *            减速时长（秒） 默认传 15
	 * @param mode
	 *            评分方式 0：NST评分，1：Fischer评分，2：改良Fischer评分，3：Krebs评分
	 * @return Msglist 分析得出的具体信息集 nst NST评分法评分结果
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/analysisFHR.do")
	public JsonResult analysisFHR(int[] ylist, int[] datelist, int[] fMlist, int t, int speedUpTimes, int declareTimes,
			int mode) throws ParseException {
//		System.out.println("*************************　　　　analysisFHR　　　　*************************　");

		List<Integer> yList = new ArrayList<>();

		List<Integer> FMList = new ArrayList<>();
		List<Integer> dateList = new ArrayList<>();
		try {
			yList = FetalMethod.changeToList(ylist);
			dateList = FetalMethod.changeToList(datelist);

			FMList = FetalMethod.changeToList(fMlist);
//			System.out.println("ylist=" + yList.size());
//			System.out.println("datelist=" + dateList.get(0));
//			System.out.println("fMlist=" + FMList.size());

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 存储胎心曲线的相关信息
		FetalDemo demo = new FetalDemo();
		// xlist 索引值 的集合
		List<Integer> xlist = FetalMethod.getList(yList.size());
		// 数据预处理
		List<Double> prelist = FetalMethod.pretreatment(yList);
		prelist = FetalMethod.pretreatment2(prelist, 4);
		// 赋值
		demo.setList(xlist);
		// demo.setxList(dateList);
		demo.setyList(yList);
		demo.setPrelist(prelist);
		List<Double> ret = null;
		try {
			ret = FetalMethod.deepCopy(prelist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		// 计算胎心基线
		demo.setBaseFHR(FetalMethod.getBaseFHR(ret));

		// 获取胎心详细分析信息
		List<FetalException> exceptions = new ArrayList<>();
		if (speedUpTimes != 0 && declareTimes != 0) {
			exceptions = FetalMethod.getFetalMsg(demo, t, speedUpTimes, declareTimes);
		} else if (speedUpTimes != 0 && declareTimes == 0) {
			exceptions = FetalMethod.getFetalMsg(demo, t, speedUpTimes, 15);
		} else if (speedUpTimes == 0 && declareTimes != 0) {
			exceptions = FetalMethod.getFetalMsg(demo, t, 15, declareTimes);
		} else {
			exceptions = FetalMethod.getFetalMsg(demo, t, 15, 15);
		}

		// 获取异常项的峰值
		exceptions = FetalMethod.getMaxAndMin(exceptions, yList, t);
		// 去除‘内含’异常项
		exceptions = FetalMethod.distinct(exceptions);
		if (fMlist.length > 0) {
			exceptions = FetalMethod.addFMMsg(FMList, exceptions);
		}
		// 分析异常项，增添描述
		List<FetalException> Msg1 = FetalMethod.analysis(exceptions, t);
		// 增加胎动
		List<FetalException> Msglist = FetalMethod.addFMMsg(FMList, Msg1);
		if (Msglist.size() > 0) {
			demo.setExceptions(Msglist);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("Msglist", Msglist); // 分析得出的具体信息集
		// 按对应的评分方式计分
		switch (mode) {
		case 0:
			NSTscore nst = FetalMethod.getNST(Msglist);
			map.put("nst", nst); // 分析得出的评分结果
			break;
		case 1:
			Fischer pastFischer = FetalMethod.getPastFischer(Msglist, prelist, t);
			map.put("pastFischer", pastFischer); // 分析得出的评分结果
			break;
		case 2:
			Fischer Fischer = FetalMethod.getFischer(Msglist, prelist, t);
			map.put("Fischer", Fischer); // 分析得出的评分结果
			break;
		case 3:
			Krebs krebs = FetalMethod.getKrebs(Msglist, prelist, t);
			map.put("krebs", krebs); // 分析得出的评分结果
			break;

		}
		return new JsonResult(map);
	}

	/**
	 * 根据胎心曲线、宫缩曲线的坐标集合进行分析 （大孕周胎心分析）
	 * 
	 * @author yinzx
	 * @param ylist
	 *            胎心率纵坐标集合
	 * @param datelist
	 *            横轴时间
	 * @param fMlist
	 *            胎动数据集
	 * @param uclist
	 *            宫缩纵坐标集合
	 * @param t
	 *            表示1秒 t个点
	 * @param speedUpTimes
	 *            加速时长（秒） 默认传 15
	 * @param declareTimes
	 *            减速时长（秒） 默认传 15
	 * @param mode
	 *            评分方式 0：NST评分，1：Fischer评分，2：改良Fischer评分，3：Krebs评分
	 * @return Msglist 分析得出的具体信息集，评分结果
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/analysisFHRandUC.do")
	public JsonResult analysisFHRandUC(int[] ylist, int[] datelist, int[] fMlist, int[] uclist, int t, int speedUpTimes,
			int declareTimes, int mode) throws ParseException {
//		System.out.println("*************************　　　　　　　　　　　analysisFHRandUC　　　　　　　　　　*************************　");

		List<Integer> yList = new ArrayList<>();
		List<Integer> ucList = new ArrayList<>();
		List<Integer> FMList = new ArrayList<>();

		yList = FetalMethod.changeToList(ylist);
		List<Integer> dateList = FetalMethod.changeToList(datelist);
		ucList = FetalMethod.changeToList(uclist);
		try {
			FMList = FetalMethod.changeToList(fMlist);
//			System.out.println("ylist=" + yList.size());
//			System.out.println("datelist=" + dateList.get(0));
//			System.out.println("fMlist=" + FMList.size());
//			System.out.println("uclist=" + ucList.size());
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 存储胎心曲线的相关信息
		FetalDemo demo = new FetalDemo();
		// xlist 索引值 的集合
		List<Integer> xlist = FetalMethod.getList(yList.size());
		// 数据预处理
		List<Double> prelist = FetalMethod.pretreatment(yList);
		prelist = FetalMethod.pretreatment2(prelist, 4);
		// 赋值
		demo.setList(xlist);
		// demo.setxList(datelist);
		demo.setyList(yList);
		demo.setPrelist(prelist);
		List<Double> ret = null;
		try {
			ret = FetalMethod.deepCopy(prelist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		// 计算胎心基线
		int base = FetalMethod.getBaseFHR(ret);
		demo.setBaseFHR(base);

		// 获取胎心详细分析信息
		List<FetalException> exceptions = new ArrayList<>();
		if (speedUpTimes != 0 && declareTimes != 0) {
			exceptions = FetalMethod.getFetalMsg(demo, t, speedUpTimes, declareTimes);
		} else if (speedUpTimes != 0 && declareTimes == 0) {
			exceptions = FetalMethod.getFetalMsg(demo, t, speedUpTimes, 15);
		} else if (speedUpTimes == 0 && declareTimes != 0) {
			exceptions = FetalMethod.getFetalMsg(demo, t, 15, declareTimes);
		} else {
			exceptions = FetalMethod.getFetalMsg(demo, t, 15, 15);
		}
		if (fMlist != null) {
			exceptions = FetalMethod.addFMMsg(FMList, exceptions);
		}

		// 获取异常项的峰值
		exceptions = FetalMethod.getMaxAndMin(exceptions, yList, t);
		// 去除‘内含’异常项
		// exceptions=FetalMethod.distinct(exceptions);
//		System.out.println("exceptions=" + exceptions.size());

		// 分析异常项，增添描述
		List<FetalException> Msg1 = FetalMethod.analysis(exceptions, t);
		// 结合宫缩曲线对 减速项进一步分析
		List<FetalException> Msg = FetalMethod.classifyFHRR(Msg1, fetalHeartService.analysisUC(xlist, ucList, t), t);
		Map<String, Object> map = new HashMap<>();
		map.put("Msglist", Msg); // 分析得出的具体信息集
//		System.out.println("Msglist=" + Msg.size());
		// 按对应的评分方式计分
		switch (mode) {
		case 0:
			NSTscore nst = FetalMethod.getNST(Msg);
			map.put("nst", nst); // 分析得出的评分结果
			break;
		case 1:
			Fischer pastFischer = FetalMethod.getPastFischer(Msg, prelist, t);
			map.put("pastFischer", pastFischer); // 分析得出的评分结果
			break;
		case 2:
			Fischer Fischer = FetalMethod.getFischer(Msg, prelist, t);
			map.put("Fischer", Fischer); // 分析得出的评分结果
			break;
		case 3:
			Krebs krebs = FetalMethod.getKrebs(Msg, prelist, t);
			map.put("krebs", krebs); // 分析得出的评分结果
			break;

		}
		return new JsonResult(map);
	}
}