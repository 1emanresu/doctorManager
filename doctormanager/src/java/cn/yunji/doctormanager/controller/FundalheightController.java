package cn.yunji.doctormanager.controller;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.Fundalheight;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.service.FundalheightService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.util.JsonResult;
@Controller
@RequestMapping("/fundalheight")
public class FundalheightController {
	@Resource
	private FundalheightService fundalheightService;
	@Resource
	private GravidaInfoService gravidaInfoService;
	
	Long SEVEN_DAY=7*24*60*60*1000L;
	Date end =new Date();
	Date begin=new Date(end.getTime()-SEVEN_DAY);
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult find(String mid,Integer eWeeks,Integer sWeeks){
		GravidaInfo gravidaInfo=gravidaInfoService.find(mid);
		if(gravidaInfo==null||gravidaInfo.getExpectedconfinement()==null){
		    return null;
		}
		Date expectedconfinement=gravidaInfo.getExpectedconfinement();
		Long expected=expectedconfinement.getTime();
		//孕一周起点的long值
		Long start=expected-SEVEN_DAY*40;
		List list=new ArrayList();
		List<String> fundalheightList=new ArrayList();
		List<Integer> gestationalWeeks=new ArrayList();
		List<String> referenceList=new ArrayList();
		int index=0;
		Double fundalheightAve;
		double fundalheightSum;
		DecimalFormat df = new DecimalFormat("0.0");
		try {
			List<Fundalheight> fundalheightTestList=new ArrayList();
			if(eWeeks==null||sWeeks==null){
				fundalheightTestList=fundalheightService.findByMid(mid);
			}else{
				fundalheightTestList=findByWeekly(mid, eWeeks, sWeeks);
			}
			for(int j=1;j<43;j++){
				//每次循环先把值归0
				index=0;
				fundalheightAve=0.0;
				fundalheightSum=0.0;
				//判断插入数据日期属于哪个孕周
				for(int i=0;i<fundalheightTestList.size();i++){
						if(fundalheightTestList.get(i).getFdate().getTime()>=start+SEVEN_DAY*(j-1)&&fundalheightTestList.get(i).getFdate().getTime()<start+SEVEN_DAY*j){
							//System.out.println("i:"+i+"j:"+j);
							//记录次数
							index++;
							gestationalWeeks.add(j);
							//将每周提交的腹围值都加起来
							fundalheightSum +=Double.parseDouble(fundalheightTestList.get(i).getFundalheight());
						}
				}
				if(index!=0){			
					fundalheightAve=fundalheightSum/index;
					fundalheightList.add(df.format(fundalheightAve));
				}
			}
			//删除重复的孕周
			for(int i=0;i<gestationalWeeks.size()-1;i++){ 
			    for(int j=gestationalWeeks.size()-1;j>i;j--){ 
			      if(gestationalWeeks.get(j).equals(gestationalWeeks.get(i))){ 
			    	 gestationalWeeks.remove(j); 
			      } 
			    } 
			}
			for(Integer i:gestationalWeeks){
				if(i==42){
					referenceList.add("31-37");
				}else if(i==41){
					referenceList.add("31-37");
				}else if(i==40){
					referenceList.add("31-37");
				}else if(i==39){
					referenceList.add("30.5-37");
				}else if(i==38){
					referenceList.add("30.5-36.5");
				}else if(i==37){
					referenceList.add("30-36");
				}else if(i==36){
					referenceList.add("29.5-35");
				}else if(i==35){
					referenceList.add("28.5-34.5");
				}else if(i==34){
					referenceList.add("28-34");
				}else if(i==33){
					referenceList.add("27-33.5");
				}else if(i==32){
					referenceList.add("26-32.5");
				}else if(i==31){
					referenceList.add("25-31.5");
				}else if(i==30){
					referenceList.add("24-30.5");
				}else if(i==29){
					referenceList.add("23.5-29.5");
				}else if(i==28){
					referenceList.add("23-28.5");
				}else if(i==27){
					referenceList.add("22.5-27.5");
				}else if(i==26){
					referenceList.add("21.5-26.5");
				}else if(i==25){
					referenceList.add("21-25.5");
				}else if(i==24){
					referenceList.add("20-24.5");
				}else if(i==23){
					referenceList.add("19-23.5");
				}else if(i==22){
					referenceList.add("18-22.5");
				}else if(i==21){
					referenceList.add("17-21.5");
				}else if(i==20){
					referenceList.add("16-20.5");
				}else{
					referenceList.add(" ");
				}
			}
			list.add(fundalheightList);
			list.add(gestationalWeeks);
			list.add(referenceList);
			return new JsonResult(list);
		} catch (Exception e) {
			return new JsonResult(e);
		}	
	}
	
	public List<Fundalheight> findByWeekly(String mid,Integer eWeeks,Integer sWeeks){
		GravidaInfo gravidaInfo=gravidaInfoService.find(mid);
		Date expectedconfinement=gravidaInfo.getExpectedconfinement();
		Long expected=expectedconfinement.getTime();
		Date end=new Date(expected-SEVEN_DAY*(40-eWeeks));
		Date begin=new Date(expected-SEVEN_DAY*(40-sWeeks));
		List<Fundalheight> list=fundalheightService.findByDateRange(mid, begin, end);
		return list;
	}
	@RequestMapping("/findByDateRange.do")
	@ResponseBody
	public JsonResult findByDateRange(String mid){
		List<Fundalheight> list=fundalheightService.findByDateRange(mid, begin, end);
		return new JsonResult(list);	
	}

}
