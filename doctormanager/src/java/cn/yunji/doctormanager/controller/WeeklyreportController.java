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
import java.util.TimeZone;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Abdominalgirth;
import cn.yunji.doctormanager.entity.Abnormityinfo;
import cn.yunji.doctormanager.entity.Bloodpressure;
import cn.yunji.doctormanager.entity.Bloodsugre;
import cn.yunji.doctormanager.entity.CheckDetail;
import cn.yunji.doctormanager.entity.CheckProject;
import cn.yunji.doctormanager.entity.CheckResult;
import cn.yunji.doctormanager.entity.DoctorAdvice;
import cn.yunji.doctormanager.entity.Exercise;
import cn.yunji.doctormanager.entity.Fetalheart;
import cn.yunji.doctormanager.entity.Fundalheight;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.KeyAttention;
import cn.yunji.doctormanager.entity.NursingEssentials;
import cn.yunji.doctormanager.entity.PsychologyEssentials;
import cn.yunji.doctormanager.entity.Symptom;
import cn.yunji.doctormanager.entity.WeeklyFood;
import cn.yunji.doctormanager.entity.WeeklyReportBasic;
import cn.yunji.doctormanager.entity.Weeklyreport;
import cn.yunji.doctormanager.entity.WeightTest;
import cn.yunji.doctormanager.service.AbdominalgirthService;
import cn.yunji.doctormanager.service.BloodpressureService;
import cn.yunji.doctormanager.service.BloodsugreService;
import cn.yunji.doctormanager.service.CheckDetailService;
import cn.yunji.doctormanager.service.CheckProjectService;
import cn.yunji.doctormanager.service.CheckResultService;
import cn.yunji.doctormanager.service.DoctorAdviceService;
import cn.yunji.doctormanager.service.ExerciseService;
import cn.yunji.doctormanager.service.FetalHeartService;
import cn.yunji.doctormanager.service.FundalheightService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.InquiryRecordService;
import cn.yunji.doctormanager.service.KeyAttentionService;
import cn.yunji.doctormanager.service.NursingEssentialsService;
import cn.yunji.doctormanager.service.PsychologyEssentialsService;
import cn.yunji.doctormanager.service.SelfTestJudgmentService;
import cn.yunji.doctormanager.service.SymptomService;
import cn.yunji.doctormanager.service.WeeklyFoodService;
import cn.yunji.doctormanager.service.WeeklyNursingService;
import cn.yunji.doctormanager.service.WeeklyReportBasicService;
import cn.yunji.doctormanager.service.WeeklyreportService;
import cn.yunji.doctormanager.service.WeightTestService;
import cn.yunji.doctormanager.util.JsonResult;


@Controller
@RequestMapping("/weeklyReport")
public class WeeklyreportController {
    
    
    @Resource
    private GravidaInfoService gravidaInfoService;
	@Resource
	private WeeklyreportService weeklyreportService;
	@Resource
	private DoctorAdviceService doctorAdviceService;
	@Resource
	private WeeklyReportBasicService weeklyReportBasicService;
	@Resource
    private WeeklyFoodService weeklyFoodService;
	@Resource
    private WeeklyNursingService weeklyNursingService;
	@Resource
	private KeyAttentionService keyAttentionService;
	@Resource
    private CheckProjectService checkProjectService;
	@Resource
	private SymptomService symptomService;
	@Resource
    private ExerciseService exerciseService;
	@Resource
    private NursingEssentialsService nursingEssentialsService;
	@Resource
    private PsychologyEssentialsService psychologyEssentialsService;
	@Resource
    private WeightTestService weightTestService;
	@Resource
	private BloodpressureService bloodpressureService;
	@Resource
    private BloodsugreService bloodsugreService;
	@Resource
    private CheckResultService checkResultService;
	@Resource
    private FetalHeartService fetalHeartService;
	@Resource
	private AbdominalgirthService abdominalgirthService;
	@Resource
    private FundalheightService fundalheightService;
	DecimalFormat df = new DecimalFormat("0.0");

	//七天Long值
	Long SEVEN_DAY=7*24*60*60*1000L;
	/**
	 * 周报查询特定指标数据。
	 * @param mid
	 * @param date
	 * @return
	 * @throws ParseException
	 * @author luoyc
	 * @createDate 2017年10月19日 下午7:46:26
	 */
	@RequestMapping("/findSpecialDataByMid.do")
    @ResponseBody
    public JsonResult findSpecialDataByMid(String mid,String date) throws ParseException{
	    List result=new ArrayList();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Weeklyreport weeklyreport=new Weeklyreport();
        Date wdate=sdf.parse(date);
        weeklyreport.setMid(mid);
        weeklyreport.setWdate(wdate);
        List<Weeklyreport> weeklyreportList=weeklyreportService.findByDate(weeklyreport);
        //获取周报的上传时间
        if(weeklyreportList.size()!=0){ 
            wdate=weeklyreportList.get(weeklyreportList.size()-1).getUploaddate();
        }
        GravidaInfo gravidinfo=gravidaInfoService.find(mid);
        Integer height=gravidinfo.getGhigh();
        //根据上传时间查询最近七天内的数据
        Date begin=new Date(wdate.getTime()-SEVEN_DAY);
        List<WeightTest> weightTestList=weightTestService.findByDateRange(mid, begin, wdate);
        //bmi
        if(weightTestList.size()!=0&&height!=null){
           Double bmi= Double.parseDouble(weightTestList.get(weightTestList.size()-1).getPregnancy())/(height*height/10000);
           result.add(df.format(bmi));
        }else{
            result.add("无");
        }
        //收缩压
        List<Bloodpressure> bloodpressureList=bloodpressureService.findByDateRange(mid, begin, wdate);
        if(bloodpressureList.size()!=0){
            result.add(bloodpressureList.get(bloodpressureList.size()-1).getSystolic());
        }else{
             result.add("无");
        }
        //空腹血糖
        List<Bloodsugre> bloodsugreList=bloodsugreService.findByDateRange(mid, begin, wdate);
        if(bloodsugreList.size()!=0){
            result.add(bloodsugreList.get(bloodsugreList.size()-1).getBbreakfast());
        }else{
             result.add("无");
        }
        //血红蛋白
        List<CheckResult> checkResultList=checkResultService.findByDateRange3(mid, begin, wdate, 1);
        if(checkResultList.size()!=0){
            Integer index=0;
            List<CheckDetail> checkDetailresult=checkResultList.get(checkResultList.size()-1).getCheckDetailList();
            for(CheckDetail cd:checkDetailresult){
                if(cd.getCheckindex().getCname().equals("血红蛋白")){
                    result.add(cd.getCheckvalue());
                    index++;
                    break;
                }
                if(index==0){
                    result.add("无");
                }
            }
        }else{
             result.add("无");
        }
        //胎心率基线
        List<Fetalheart> fetalheartList=fetalHeartService.findByDateRange(mid, begin, wdate);
        if(fetalheartList.size()!=0){
            result.add(fetalheartList.get(fetalheartList.size()-1).getFrateline());
        }else{
            result.add("无"); 
        }
        //宫高
        List<Fundalheight> fundalheightList=fundalheightService.findByDateRange(mid, begin, wdate);
        if(fundalheightList.size()!=0){
            result.add(fundalheightList.get(fundalheightList.size()-1).getFundalheight());
        }else{
            result.add("无"); 
        }
        //腹围
        List<Abdominalgirth> abdominalgirthList=abdominalgirthService.findByDateRange(mid, begin, wdate);
        if(abdominalgirthList.size()!=0){
            result.add(abdominalgirthList.get(abdominalgirthList.size()-1).getAbdominalgirth());
        }else{
            result.add("无"); 
        }
        return new JsonResult(result);  
    }
	/**
	 * 插入医嘱记录
	 * @author luoyc
	 * @param weeklyreport
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/insert.do")
	@ResponseBody
	public JsonResult insert1(Weeklyreport weeklyreport) throws ParseException{
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Calendar now =Calendar.getInstance();
		int month=now.get(2)+1;
		String mon=month+"";
		if(month<10){
			mon="0"+mon;
		}
		int day=now.get(5);
		String dd=""+day;
		if(day<10){
			dd="0"+dd;
		}
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=now.get(1)+"-"+mon+"-"+dd;
		Date wdate=sdf.parse(dateStr);
		weeklyreport.setWdate(wdate);
		weeklyreportService.insert(weeklyreport);
		DoctorAdvice doctorAdvice=new DoctorAdvice();
		doctorAdvice.setMid(weeklyreport.getMid());
		doctorAdvice.setDoctorid(weeklyreport.getDoctorid());
		doctorAdvice.setAdvicedate(wdate);
		doctorAdvice.setMyknowledge(weeklyreport.getDoctoradvice());
		doctorAdviceService.insertDoctorAdvice(doctorAdvice);
		return new JsonResult(0);	
	}
	/**
	 * 查询出当月所有记录
	 * @author luoyc
	 * @param mid
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/findMonthlyAllRecord.do")
	@ResponseBody
	public JsonResult findAllRecord(String mid) throws ParseException{
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Calendar now =Calendar.getInstance();
		int month=now.get(2)+1;
		String mon=month+"";
		if(month<10){
			mon="0"+mon;
		}
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=now.get(1)+"-"+mon+"-"+"01";
		Date start=sdf.parse(dateStr);
		Date end=now.getTime();
		List<Weeklyreport> weeklyreportList=weeklyreportService.findByDateRange(mid, start, end);
		List<Date> dateList=new ArrayList();
		for(Weeklyreport weeklyreport:weeklyreportList){
			dateList.add(weeklyreport.getWdate());
		}
		//删除重复日期
		for(int i=0;i<dateList.size()-1;i++){ 
		    for(int j=dateList.size()-1;j>i;j--){ 
		      if(dateList.get(j).equals(dateList.get(i))){ 
		    	  dateList.remove(j); 
		      } 
		    } 
		}
		return new JsonResult(dateList);	
	}
	/**
	 * 根据日期查询指定孕妇周报记录
	 * @author luoyc
	 * @param mid
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/findRecordByDate.do")
	@ResponseBody
	public JsonResult findRecordByDate(String mid,String date) throws ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date qdate=sdf.parse(date);
		Weeklyreport ir=new Weeklyreport();
		ir.setMid(mid);
		ir.setWdate(qdate);
		List<Weeklyreport> weeklyreportList=weeklyreportService.findByDate(ir);
		List<Date> dateList=new ArrayList();
		ir=weeklyreportList.get(weeklyreportList.size()-1);
		return new JsonResult(ir);	
	}
	/**
     * 根据孕周生成周报通用模板
     * @author luoyc
     * @param mid
     * @param date
     * @return
     * @throws ParseException
     */
    @RequestMapping("/findWeeklyTemplate.do")
    @ResponseBody
    public JsonResult findWeeklyTemplate(Integer week){
        WeeklyReportBasic weeklyReportBasic=weeklyReportBasicService.findByWeek(week);
        List<KeyAttention> keyAttentionList=keyAttentionService.selectByPrimaryKeys(listChangeType(weeklyReportBasic.getKeyattention()));
        List<CheckProject> checkProjectList=checkProjectService.selectByPrimaryKeys(listChangeType(weeklyReportBasic.getAntenatalitem()));
        List<Symptom> symptomList=symptomService.selectByPrimaryKeys(listChangeType(weeklyReportBasic.getSymptom()));
        WeeklyFood weeklyFood=weeklyFoodService.findByWeek(week);
        List<Exercise> exerciseYesList=exerciseService.selectByPrimaryKeys(listChangeType(weeklyReportBasic.getExerciseyes()));
        List<Exercise> exerciseNoList=exerciseService.selectByPrimaryKeys(listChangeType(weeklyReportBasic.getExerciseno()));
        List<NursingEssentials> nursingEssentialsList=nursingEssentialsService.selectByPrimaryKeys(listChangeType(weeklyReportBasic.getNursingessentials()));
        List<PsychologyEssentials> psychologyEssentialsList=psychologyEssentialsService.selectByPrimaryKeys(listChangeType(weeklyReportBasic.getPsycholoyessentials()));
        List result=new ArrayList();
        result.add(keyAttentionList);
        result.add(checkProjectList);
        result.add(symptomList);
        result.add(weeklyFood);
        result.add(exerciseYesList);
        result.add(exerciseNoList);
        result.add(nursingEssentialsList);
        result.add(psychologyEssentialsList);
        return new JsonResult(result);  
    }
    /**
     * 
     * 将数字字符串转换成数组
     * @param ids
     * @return integerList
     * @author luoyc
     * @createDate 2017年10月19日 下午2:16:29
     */
    public List<Integer> listChangeType(String ids){
        List<Integer> integerList=new ArrayList();
        String[] list=ids.split(",");
        for(String str:list){
            integerList.add(Integer.valueOf(str));
        }
        return integerList; 
    }
    
    /**
	 * @author zhangqt
	 * @param mid,
	 * @return
	 */
	@RequestMapping("/findByMid.do")
	@ResponseBody
	public Map findDoctorAdvices(String mid,String keyword,String sdate,String edate, Integer pageIndex,Integer pageSize) {
		List<Weeklyreport> list=weeklyreportService.findByMid(mid,keyword,sdate,edate,pageIndex,pageSize);
		Map map=new HashMap();
		map.put("total", 10);
		map.put("rows", list);
		return map;
	}
    
}