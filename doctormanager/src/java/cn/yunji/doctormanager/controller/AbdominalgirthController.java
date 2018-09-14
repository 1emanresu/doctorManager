package cn.yunji.doctormanager.controller;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.yunji.doctormanager.entity.Abdominalgirth;
import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.service.AbdominalgirthService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.util.JsonResult;
@Controller
@RequestMapping("/abdominalgirth")
public class AbdominalgirthController {
	@Resource
	private AbdominalgirthService abdominalgirthService;
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
		List<String> abdominalgirthList=new ArrayList();
		List<Integer> gestationalWeeks=new ArrayList();
		List<String> referenceList=new ArrayList();
		int index=0;
		Double abdominalgirthAve;
		double abdominalgirthSum;
		DecimalFormat df = new DecimalFormat("0.0");
		try {
			List<Abdominalgirth> abdominalgirthTestList=new ArrayList();
			if(eWeeks==null||sWeeks==null){
				abdominalgirthTestList=abdominalgirthService.findByMid(mid);
			}else{
				abdominalgirthTestList=findByWeekly(mid, eWeeks, sWeeks);
			}
			for(int j=1;j<43;j++){
				//每次循环先把值归0
				index=0;
				abdominalgirthAve=0.0;
				abdominalgirthSum=0.0;
				//判断插入数据日期属于哪个孕周
				for(int i=0;i<abdominalgirthTestList.size();i++){
						if(abdominalgirthTestList.get(i).getAgdate().getTime()>=start+SEVEN_DAY*(j-1)&&abdominalgirthTestList.get(i).getAgdate().getTime()<start+SEVEN_DAY*j){
							//System.out.println("i:"+i+"j:"+j);
							//记录次数
							index++;
							gestationalWeeks.add(j);
							//将每周提交的腹围值都加起来
							abdominalgirthSum +=Double.parseDouble(abdominalgirthTestList.get(i).getAbdominalgirth());
						}
				}
				if(index!=0){			
					abdominalgirthAve=abdominalgirthSum/index;
					abdominalgirthList.add(df.format(abdominalgirthAve));
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
				if(i==43){
					referenceList.add("89-100");
				}else if(i==42){
					referenceList.add("89-100");
				}else if(i==41){
					referenceList.add("89-100");
				}else if(i==40){
					referenceList.add("89-100");
				}else if(i==39){
					referenceList.add("86-98");
				}else if(i==38){
					referenceList.add("86-98");
				}else if(i==37){
					referenceList.add("86-98");
				}else if(i==36){
					referenceList.add("86-98");
				}else if(i==35){
					referenceList.add("86-98");
				}else if(i==34){
					referenceList.add("84-95");
				}else if(i==33){
					referenceList.add("84-95");
				}else if(i==32){
					referenceList.add("84-95");
				}else if(i==31){
					referenceList.add("84-95");
				}else if(i==30){
					referenceList.add("82-94");
				}else if(i==29){
					referenceList.add("82-94");
				}else if(i==28){
					referenceList.add("82-94");
				}else if(i==27){
					referenceList.add("82-94");
				}else if(i==26){
					referenceList.add("82-94");
				}else if(i==25){
					referenceList.add("80-91");
				}else if(i==24){
					referenceList.add("80-91");
				}else if(i==23){
					referenceList.add("80-91");
				}else if(i==22){
					referenceList.add("80-91");
				}else if(i==21){
					referenceList.add("76-89");
				}else if(i==20){
					referenceList.add("76-89");
				}else if(i==19){
					referenceList.add("76-89");
				}else if(i==18){
					referenceList.add("76-89");
				}else if(i==17){
					referenceList.add("76-89");
				}else{
					referenceList.add(" ");
				}
			}
			list.add(abdominalgirthList);
			list.add(gestationalWeeks);
			list.add(referenceList);
			return new JsonResult(list);
		} catch (Exception e) {
			return new JsonResult(e);
		}	
	}
	
	public List<Abdominalgirth> findByWeekly(String mid,Integer eWeeks,Integer sWeeks){
		GravidaInfo gravidaInfo=gravidaInfoService.find(mid);
		Date expectedconfinement=gravidaInfo.getExpectedconfinement();
		Long expected=expectedconfinement.getTime();
		Date end=new Date(expected-SEVEN_DAY*(40-eWeeks));
		Date begin=new Date(expected-SEVEN_DAY*(40-sWeeks));
		List<Abdominalgirth> list=abdominalgirthService.findByDateRange(mid, begin, end);
		return list;	
	}
	@RequestMapping("/findByDateRange.do")
	@ResponseBody
	public JsonResult findByDateRange(String mid){
		List<Abdominalgirth> list=abdominalgirthService.findByDateRange(mid, begin, end);
		return new JsonResult(list);	
	}
}
