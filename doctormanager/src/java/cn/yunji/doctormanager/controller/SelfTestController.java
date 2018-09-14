package cn.yunji.doctormanager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import cn.yunji.doctormanager.entity.Abdominalgirth;
import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.Bloodoxygen;
import cn.yunji.doctormanager.entity.Bloodpressure;
import cn.yunji.doctormanager.entity.Bloodsugre;
import cn.yunji.doctormanager.entity.CountQuickening;
import cn.yunji.doctormanager.entity.FetalHeartData;
import cn.yunji.doctormanager.entity.Fundalheight;
import cn.yunji.doctormanager.entity.MyEcg;
import cn.yunji.doctormanager.entity.Reminder;
import cn.yunji.doctormanager.entity.Selfteststatu;
import cn.yunji.doctormanager.entity.Temperature;
import cn.yunji.doctormanager.entity.WeightTest;
import cn.yunji.doctormanager.service.AbdominalgirthService;
import cn.yunji.doctormanager.service.BloodfatService;
import cn.yunji.doctormanager.service.BloodoxygenService;
import cn.yunji.doctormanager.service.BloodpressureService;
import cn.yunji.doctormanager.service.BloodsugreService;
import cn.yunji.doctormanager.service.CountQuickeningService;
import cn.yunji.doctormanager.service.FetalHeartDataService;
import cn.yunji.doctormanager.service.FundalheightService;
import cn.yunji.doctormanager.service.MyEcgService;
import cn.yunji.doctormanager.service.ReminderService;
import cn.yunji.doctormanager.service.SelfteststatuService;
import cn.yunji.doctormanager.service.TemperatureService;
import cn.yunji.doctormanager.service.WeightTestService;
import cn.yunji.doctormanager.util.JsonResult;


@Controller
@RequestMapping("/selfTest")
public class SelfTestController {
	@Resource
	private AbdominalgirthService abdominalgirthService;
	@Resource
	private BloodpressureService bloodpressureService;
	@Resource
	private BloodfatService bloodfatService;
	@Resource
	private BloodsugreService bloodsugreService;
	@Resource
	private CountQuickeningService countQuickeningService;
	@Resource
	private FundalheightService fundalheightService;
	@Resource
	private MyEcgService myEcgService;
	@Resource
	private WeightTestService weightTestService;
	@Resource
	private TemperatureService temperatureService;
	@Resource
	private BloodoxygenService bloodoxygenService;
	@Resource
    private FetalHeartDataService fetalHeartDataService;
	@Resource
	private ReminderService reminderService;
	@Resource
    private SelfteststatuService selfteststatuService;
	//由当前时间往后一周
	Long SEVEN_DAY=7*24*60*60*1000L;
	Date end =new Date();
	Date begin=new Date(end.getTime()-SEVEN_DAY);
	
	/**
	 * web周报——查询最近一周孕妇上传的自测数据
	 * @author luoyc
	 * @param mid
	 * @return
	 */
	@RequestMapping("/findThisWeek.do")
	@ResponseBody
	public JsonResult findThisWeekSelfTest(String mid){
		List totalList=new ArrayList();
		//获取所有孕妇在本周已做的自测项
		Map maplist=findWeeklySelfTestDone(mid);
		Set<String> keys=maplist.keySet();
		//所有已做的自测项目
		List<String> selfTestDoneType=new ArrayList<String>();
		//所有要求而未做的自测项目
		List<String> selfTestNotDoneType=new ArrayList<String>();
		//所有的已做的自测项目和要求做而未做的项目
		List<String> selfTestAllType=new ArrayList<String>();
		for(String done:selfTestDoneType){
			selfTestAllType.add(done);
		}
		//set转List
		selfTestDoneType.addAll(keys);
		List<Reminder> reminderList=reminderService.findByDateRange(mid, begin, end);
		String remindStr;
		for(Reminder reminder:reminderList){
			remindStr=reminder.getSelftestdetails();
			if(remindStr!=null){
    			if(remindStr.contains("血压")){
    				selfTestAllType.add("血压");
    			}if(remindStr.contains("血糖")){
    				selfTestAllType.add("血糖");
    			}if(remindStr.contains("体重")){
    				selfTestAllType.add("体重");
    			}if(remindStr.contains("胎动")){
    				selfTestAllType.add("胎动");
    			}if(remindStr.contains("胎心")){
    				selfTestAllType.add("胎心");
    			}if(remindStr.contains("腹围")){
    				selfTestAllType.add("腹围");
    			}if(remindStr.contains("宫高")){
    				selfTestAllType.add("宫高");
    			}if(remindStr.contains("体温")){
    				selfTestAllType.add("体温");
    			}if(remindStr.contains("血氧")){
    				selfTestAllType.add("血氧");
    			}if(remindStr.contains("心电")){
    				selfTestAllType.add("心电");
    			}if(remindStr.contains("尿液")){
    				selfTestAllType.add("尿液");
    			}
            }
		}
		//删除重复的自测项目,得到所有的自测项目
		selfTestAllType= new ArrayList<String>(new HashSet<String>(selfTestAllType));
		//将All的所有数据复制到NotDone里
		for(String all:selfTestAllType){
			selfTestNotDoneType.add(all);
		}
		selfTestNotDoneType.removeAll(selfTestDoneType);
		totalList.add(selfTestAllType);
		totalList.add(selfTestNotDoneType);
		totalList.add(selfTestDoneType);
		return new JsonResult(totalList);		
	}
	/**
     * web周报——查询指定日期倒后一周孕妇上传的自测数据
     * @author luoyc
     * @param mid
     * @return
     */
    @RequestMapping("/findSpecialWeek.do")
    @ResponseBody
    public JsonResult findSpecialWeekSelfTest(String mid,Date date,Integer week){
        //获取所有孕妇在本周已做的自测项
        Map maplist=findWeeklySelfTestDone(mid,date);
        Set<String> keys=maplist.keySet();
        //所有已做的自测项目
        List<String> selfTestDoneType=new ArrayList<String>();
        selfTestDoneType.addAll(keys);
        List resultlist=new ArrayList();
        List tableList=new ArrayList();
        List<String> tableStr;
        String decription=new String();
        Integer index1;
        Integer index2;
        Integer index3;
        Integer index4;
        Integer index5;
        Integer index6;
        if(maplist.get("血压")!=null){
            tableStr=new ArrayList<String>();
            tableStr.add("血压");
            index1=0;
            index2=0;
            index3=0;
            index4=0;
            index5=0;
            index6=0;
            List<Bloodpressure> bloodsugrelist=(List<Bloodpressure>) maplist.get("血压");
            for(Bloodpressure bp:bloodsugrelist){
                //收缩压，舒张压评判结果，选取严重的结果计算
                decription=selfteststatuService.findByCid(43, Double.parseDouble(bp.getSystolic())).getDescription();
                decription+=selfteststatuService.findByCid(44, Double.parseDouble(bp.getSystolic())).getDescription();
                if(decription.indexOf("3级高血压")!=-1){
                    index1++;
                }else if(decription.indexOf("2级高血压")!=-1){
                    index2++;
                }else if(decription.indexOf("1级高血压")!=-1){
                    index3++;
                }else if(decription.indexOf("正常")!=-1){
                    index4++;
                }else if(decription.indexOf("低血压")!=-1){
                    index6++;
                }else if(decription.indexOf("正常")!=-1){
                    index5++;
                }
            }
            decription="";
            if(index1!=0){
                decription+="3级高血压"+index1+"次"+"</br>";
            }if(index2!=0){
                decription+="2级高血压"+index2+"次"+"</br>";
            }if(index3!=0){
                decription+="1级高血压"+index3+"次"+"</br>";
            }if(index4!=0){
                decription+="正常偏高"+index4+"次"+"</br>";
            }if(index6!=0){
                decription+="低血压"+index6+"次"+"</br>";
            }
            tableStr.add(decription);
            tableStr.add("≤120/90mmHg");
            tableList.add(tableStr);
        }
        if(maplist.get("腹围")!=null){
            tableStr=new ArrayList<String>();
            tableStr.add("腹围");
            List<Abdominalgirth> abdominalgirthlist=(List<Abdominalgirth>) maplist.get("腹围");
            decription=abdominalgirthlist.get(abdominalgirthlist.size()-1).getAbdominalgirth();
            tableStr.add(decription);
            if(week<17){
                week=17;
            }
            if(week>41){
                week=41;
            }
            Selfteststatu selfteststatu=selfteststatuService.findByWeek(week,196);
            tableStr.add(selfteststatu.getCbegin()+"-"+selfteststatu.getCend()+"cm");
            tableList.add(tableStr);
        }
        if(maplist.get("宫高")!=null){
            tableStr=new ArrayList<String>();
            tableStr.add("宫高");
            List<Fundalheight> fundalheightlist=(List<Fundalheight>) maplist.get("宫高");
            decription=fundalheightlist.get(fundalheightlist.size()-1).getFundalheight();
            tableStr.add(decription);
            if(week<20){
                week=20;
            }
            if(week>41){
                week=41;
            }
            Selfteststatu selfteststatu=selfteststatuService.findByWeek(week,195);
            tableStr.add(selfteststatu.getCbegin()+"-"+selfteststatu.getCend()+"cm");
            tableList.add(tableStr);
        }
        resultlist.add(selfTestDoneType);
        resultlist.add(tableList);
        return new JsonResult(resultlist);       
    }
	@RequestMapping("/findWeeklySelfTestDone.do")
	@ResponseBody
	public JsonResult findThisWeekSelfTestDone(String mid,String endDate) throws ParseException{
		//获取所有孕妇在本周已做的自测项
	    Map maplist=new HashMap();
	    if(endDate==null){
	        maplist=findWeeklySelfTestDone(mid);
	    }else{
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        Date endDate2=sdf.parse(endDate);
	        maplist=findWeeklySelfTestDone(mid,endDate2);
	    }
		
		return new JsonResult(maplist);
	}
	/**
	 * 查询指定孕妇最近一周做的所有自测项目
	 * @author luoyc
	 * @param mid
	 * @return
	 */
	public Map findWeeklySelfTestDone(String mid){
		Map maplist=new HashMap();
		//最近一周完成的自测项目的所有数据
		List<Bloodsugre> bloodsugrelist=bloodsugreService.findByDateRange(mid, begin, end);
		if(bloodsugrelist!=null&&bloodsugrelist.size()!=0){
			maplist.put("血糖", bloodsugrelist);
		}
		List<Bloodpressure> bloodpressurelist=bloodpressureService.findByDateRange(mid, begin, end);
		if(bloodpressurelist!=null&&bloodpressurelist.size()!=0){
			maplist.put("血压", bloodpressurelist);
		}
		List<WeightTest> weightTestlist=weightTestService.findByDateRange(mid, begin, end);
		if(weightTestlist!=null&&weightTestlist.size()!=0){
			maplist.put("体重", weightTestlist);
		}
		List<CountQuickening> countQuickeninglist=countQuickeningService.findByDateRange(mid, begin, end);
		if(countQuickeninglist!=null&&countQuickeninglist.size()!=0){
			maplist.put("胎动", countQuickeninglist);
		}
		List<Abdominalgirth> abdominalgirthlist=abdominalgirthService.findByDateRange(mid, begin, end);
		if(abdominalgirthlist!=null&&abdominalgirthlist.size()!=0){
			maplist.put("腹围", abdominalgirthlist);
		}
		List<Fundalheight> fundalheightlist=fundalheightService.findByDateRange(mid, begin, end);
		if(fundalheightlist!=null&&fundalheightlist.size()!=0){
			maplist.put("宫高", fundalheightlist);
		}
		List<FetalHeartData> fetalHeartDatalist=fetalHeartDataService.findByDateRange(mid, begin, end);
        if(fetalHeartDatalist!=null&&fetalHeartDatalist.size()!=0){
            maplist.put("胎心", fetalHeartDatalist);
        }
		/*List<MyEcg>  myEcglist= myEcgService.findByDateRange(mid, begin, end);
		if(myEcglist!=null&&myEcglist.size()!=0){
			maplist.put("心电", myEcglist);
		}*/
		/*List<Temperature> temperaturelist=temperatureService.findByDateRange(mid, begin, end);
		if(temperaturelist!=null&&temperaturelist.size()!=0){
			maplist.put("体温", temperaturelist);
		}*/
		/*List<Bloodfat> bloodfatlist=bloodfatService.findByDateRange(mid, begin, end);
		if(bloodfatlist!=null&&bloodfatlist.size()!=0){
			maplist.put("血脂", bloodfatlist);
		}
		List<Bloodoxygen> bloodoxygenlist=bloodoxygenService.findByDateRange(mid, begin, end);
		if(bloodoxygenlist!=null&&bloodoxygenlist.size()!=0){
			maplist.put("血氧", bloodoxygenlist);
		}*/
		return maplist;	
	}
	/**
     * 查询指定孕妇指定日期倒后一周做的所有自测项目
     * @author luoyc
     * @param mid
     * @return
     */
    public Map findWeeklySelfTestDone(String mid,Date date){
        Map maplist=new HashMap();
        //指定时间倒后一周完成的自测项目的所有数据
        Date begin=new Date(date.getTime()-SEVEN_DAY);
        List<Bloodsugre> bloodsugrelist=bloodsugreService.findByDateRange(mid, begin, date);
        if(bloodsugrelist!=null&&bloodsugrelist.size()!=0){
            maplist.put("血糖", bloodsugrelist);
        }
        List<Bloodpressure> bloodpressurelist=bloodpressureService.findByDateRange(mid, begin, date);
        if(bloodpressurelist!=null&&bloodpressurelist.size()!=0){
            maplist.put("血压", bloodpressurelist);
        }
        List<WeightTest> weightTestlist=weightTestService.findByDateRange(mid, begin, date);
        if(weightTestlist!=null&&weightTestlist.size()!=0){
            maplist.put("体重", weightTestlist);
        }
        List<CountQuickening> countQuickeninglist=countQuickeningService.findByDateRange(mid, begin, date);
        if(countQuickeninglist!=null&&countQuickeninglist.size()!=0){
            maplist.put("胎动", countQuickeninglist);
        }
        List<Abdominalgirth> abdominalgirthlist=abdominalgirthService.findByDateRange(mid, begin, date);
        if(abdominalgirthlist!=null&&abdominalgirthlist.size()!=0){
            maplist.put("腹围", abdominalgirthlist);
        }
        List<Fundalheight> fundalheightlist=fundalheightService.findByDateRange(mid, begin, date);
        if(fundalheightlist!=null&&fundalheightlist.size()!=0){
            maplist.put("宫高", fundalheightlist);
        }
        /*List<MyEcg>  myEcglist= myEcgService.findByDateRange(mid, begin, date);
        if(myEcglist!=null&&myEcglist.size()!=0){
            maplist.put("心电", myEcglist);
        }*/
        List<Temperature> temperaturelist=temperatureService.findByDateRange(mid, begin, date);
        if(temperaturelist!=null&&temperaturelist.size()!=0){
            maplist.put("体温", temperaturelist);
        }
        /*List<Bloodfat> bloodfatlist=bloodfatService.findByDateRange(mid, begin, date);
        if(bloodfatlist!=null&&bloodfatlist.size()!=0){
            maplist.put("血脂", bloodfatlist);
        }*/
        /*List<Bloodoxygen> bloodoxygenlist=bloodoxygenService.findByDateRange(mid, begin, date);
        if(bloodoxygenlist!=null&&bloodoxygenlist.size()!=0){
            maplist.put("血氧", bloodoxygenlist);
        }*/
        return maplist; 
    }
    
    
    /**
	 * 根据医生发送的提醒（最近的 一条）来返回自测的完整度
	 * @author zhagnqt
	 * @param mid
	 * @return
	 */
	@RequestMapping("/findThis.do")
	@ResponseBody
	public Map findThis(String mid){
	    Map result=new HashMap();
		//获取所有孕妇在本周已做的自测项
		Map maplist=findWeeklySelfTestDone(mid);
		Set<String> keys=maplist.keySet();
		//所有要求而未做的自测项目
        List<String> selfTestNotDoneType=new ArrayList<String>();
		//所有已做的自测项目
		List<String> selfTestDoneType=new ArrayList<String>();		
		//所有已经检查的项目
		selfTestDoneType.addAll(keys);
		//需要查的自测项目
		Reminder reminder=reminderService.findByMid(mid);		
		//没有需要做的检查时就返回0%；就是没有提醒要做的自测项目下。
		result.put("selfTestDoneType", selfTestDoneType);
		if(reminder==null||reminder.equals("")){
		    selfTestNotDoneType.add("无");
		    result.put("selfTestNotDoneType",selfTestNotDoneType);
		    result.put("percentage",0);
			return result;
		}
		String[] str = reminder.getSelftestdetails().split("~");
		int num=0;
		for (int i = 0; i < str.length; i++) {
		    if(selfTestDoneType.size()==0){
		       selfTestNotDoneType.add(str[i].replace("检测", ""));
	        }
			for (int j = 0; j < selfTestDoneType.size(); j++) {
				if(selfTestDoneType.get(j).equals(str[i].replace("检测", ""))){
					num++;
					break;
				}
				if(j==(selfTestDoneType.size()-1)&&!selfTestDoneType.get(j).equals(str[i].replace("检测", ""))){
				    selfTestNotDoneType.add(str[i].replace("检测", ""));
				}
			}
		}
		double sum=(double)num/(double)str.length*100;
		result.put("selfTestNotDoneType",selfTestNotDoneType);
		result.put("percentage",(int)Math.rint(sum));
		//采用四舍五入取整方法返回
		return result;		
	
	}
    
    
    
	/** 
     * 高效获取两个List的不同元素 
     * @author luoyc
     * @param list1 
     * @param list2 
     * @return 
     */  
	private static List<String> getDiffrent(List<String> list1, List<String> list2) {  
		list1.retainAll(list2);   
        return list1;  
    }           
}