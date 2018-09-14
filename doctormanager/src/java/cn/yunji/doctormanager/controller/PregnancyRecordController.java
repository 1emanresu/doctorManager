package cn.yunji.doctormanager.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Record1_3;
import cn.yunji.doctormanager.entity.Record4_7;
import cn.yunji.doctormanager.entity.Record8_10;
import cn.yunji.doctormanager.service.Record1_3Service;
import cn.yunji.doctormanager.service.Record4_7Service;
import cn.yunji.doctormanager.service.Record8_10Service;
import cn.yunji.doctormanager.util.JsonResult;
/**
 * 产前访问Controller
 * @author ZPL
 * 2017年7月13日 16:24:31
 */
@Controller
@RequestMapping("/pregnancyRecord")
public class PregnancyRecordController {

	@Resource
	private Record1_3Service record1_3Service;
	@Resource
	private Record4_7Service record4_7Service;
	@Resource
	private Record8_10Service record8_10Service;
	

	@RequestMapping("/findByWeek.do")
	@ResponseBody
	public JsonResult queryCheckDetail(String mid,Integer weeks) {
		List<String> symptoms=new ArrayList();
		List<Record1_3> record13List=record1_3Service.findByWeeks(weeks,mid);
		for(Record1_3 record1_3:record13List){
		    if(record1_3.getColporrhagia()==1){
		        symptoms.add("阴道流血");
		    }if(record1_3.getFever()==1){
		        symptoms.add("发热");
		    }if(record1_3.getBellyache()==1){
                symptoms.add("腹痛");
            }if(record1_3.getEmesis()==1){
                symptoms.add("恶心，呕吐");
            }if(record1_3.getHavahighrisk()==1){
                symptoms.add("本时期有高危因素存在");
            }
		}
		List<Record4_7> record47List=record4_7Service.findByWeeks(weeks,mid);
		for(Record4_7 record4_7:record47List){
            if(record4_7.getColporrhagia()==1){
                symptoms.add("阴道流血");
            }if(record4_7.getFever()==1){
                symptoms.add("发热");
            }if(record4_7.getBellyache()==1){
                symptoms.add("腹痛");
            }if(record4_7.getEmesis()==1){
                symptoms.add("心慌，气短，夜间不能平卧");
            }if(record4_7.getHavahighrisk()==1){
                symptoms.add("本时期有高危因素存在");
            }if(record4_7.getBeflustered()==1){
                symptoms.add("恶心，呕吐");
            }if(record4_7.getHeadswirl()==1){
                symptoms.add("头晕，头痛，视物不清");
            }if(record4_7.getFever1()==1){
                symptoms.add("心慌，憋气");
            }if(record4_7.getBlood()==1){
                symptoms.add("血压≥140/90mmHg");
            }if(record4_7.getShortweightnimiety()==1){
                symptoms.add("短时间体重增加过多");
            }
        }
		List<Record8_10> record810List=record8_10Service.findByWeeks(weeks,mid);
        for(Record8_10 record8_10:record810List){
            if(record8_10.getColporrhagia()==1){
                symptoms.add("阴道流血");
            }if(record8_10.getFever()==1){
                symptoms.add("头晕，头痛，视物不清");
            }if(record8_10.getBellyache()==1){
                symptoms.add("腹痛");
            }if(record8_10.getEdema()==1){
                symptoms.add("浮肿");
            }if(record8_10.getHavahighrisk()==1){
                symptoms.add("本时期有高危因素存在");
            }if(record8_10.getBeflustered()==1){
                symptoms.add("心慌，气短，夜间不能平卧");
            }if(record8_10.getHeadswirl()==1){
                symptoms.add("阴道流水");
            }if(record8_10.getBlood()==1){
                symptoms.add("血压≥140/90mmHg");
            }if(record8_10.getSabnormalfetalirrirability()==1){
                symptoms.add("胎动异常");
            }/*if(record8_10.getGestationalweeks()==1){
                symptoms.add("孕周≥41");
            }*/
        }
        //删除重复字段
        for (int i = 0; i < symptoms.size() - 1; i++) {
            for (int j = symptoms.size() - 1; j > i; j--) {
                if (symptoms.get(j).equals(symptoms.get(i))) {
                    symptoms.remove(j);
                }
            }
        }
		return new JsonResult(symptoms);
	}
	@RequestMapping("/queryCheckDetail.do")
    @ResponseBody
    public JsonResult queryCheckDetail2(String mid,Integer weeks) {
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    List result=new ArrayList();
        List<String> symptoms=new ArrayList();
        List<String> time=new ArrayList();
        List<String> description=new ArrayList();
        List<Record1_3> record13List=record1_3Service.findByWeeks(weeks,mid);
        for(Record1_3 record1_3:record13List){
            if(record1_3.getColporrhagia()==1){
                symptoms.add("阴道流血");
                if(record1_3.getColporrhagiadate()!=null){
                    time.add(sdf.format(record1_3.getColporrhagiadate())); 
                }else{
                    time.add("无");
                }
                if(record1_3.getColporrhagiacon()!=null&&record1_3.getColporrhagiacon()!=""){
                    description.add(record1_3.getColporrhagiacon());
                }else{
                    description.add("无");
                }
            }if(record1_3.getFever()==1){
                symptoms.add("发热");
                if(record1_3.getFeverdate()!=null){
                    time.add(sdf.format(record1_3.getFeverdate()));
                }else{
                    time.add("无");
                }
                if(record1_3.getFevercon()!=null&&record1_3.getFevercon()!=""){
                    description.add(record1_3.getFevercon());
                }else{
                    description.add("无");
                }
            }if(record1_3.getBellyache()==1){
                symptoms.add("腹痛");
                if(record1_3.getBellyachedate()!=null){
                    time.add(sdf.format(record1_3.getBellyachedate()));
                }else{
                    time.add("无");
                }
                if(record1_3.getBellyachecon()!=null&&record1_3.getBellyachecon()!=""){
                    description.add(record1_3.getBellyachecon());
                }else{
                    description.add("无");
                }
            }if(record1_3.getEmesis()==1){
                symptoms.add("恶心，呕吐");
                if(record1_3.getEmesisdate()!=null){
                    time.add(sdf.format(record1_3.getEmesisdate()));
                }else{
                    time.add("无");
                }
                if(record1_3.getEmesisnoeatcon()!=null&&record1_3.getEmesisnoeatcon()!=""){
                    description.add(record1_3.getEmesisnoeatcon());
                }else{
                    description.add("无");
                }
            }if(record1_3.getHavahighrisk()==1){
                symptoms.add("本时期有高危因素存在");
                if(record1_3.getHavahighriskdate()!=null){
                    time.add(sdf.format(record1_3.getHavahighriskdate()));
                }else{
                    time.add("无");
                }
                if(record1_3.getHavahighriskcon()!=null&&record1_3.getHavahighriskcon()!=""){
                    description.add(record1_3.getHavahighriskcon());
                }else{
                    description.add("无");
                }
            }
        }
        List<Record4_7> record47List=record4_7Service.findByWeeks(weeks,mid);
        for(Record4_7 record4_7:record47List){
            if(record4_7.getColporrhagia()==1){
                symptoms.add("阴道流血");
                if(record4_7.getColporrhagiadate()!=null){
                    time.add(sdf.format(record4_7.getColporrhagiadate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getColporrhagiacon()!=null&&record4_7.getColporrhagiacon()!=""){
                    description.add(record4_7.getColporrhagiacon());
                }else{
                    description.add("无");
                }
            }if(record4_7.getFever()==1){
                symptoms.add("发热");
                if(record4_7.getFeverdate()!=null){
                    time.add(sdf.format(record4_7.getFeverdate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getFevercon()!=null&&record4_7.getFevercon()!=""){
                    description.add(record4_7.getFevercon());
                }else{
                    description.add("无");
                }
            }if(record4_7.getBellyache()==1){
                symptoms.add("腹痛");
                if(record4_7.getBellyachedate()!=null){
                    time.add(sdf.format(record4_7.getBellyachedate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getBellyachecon()!=null&&record4_7.getBellyachecon()!=""){
                    description.add(record4_7.getBellyachecon());
                }else{
                    description.add("无");
                }
            }if(record4_7.getEmesis()==1){
                symptoms.add("心慌，气短，夜间不能平卧");
                if(record4_7.getEmesisdate()!=null){
                    time.add(sdf.format(record4_7.getEmesisdate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getEmesisnoeatcon()!=null&&record4_7.getEmesisnoeatcon()!=""){
                    description.add(record4_7.getEmesisnoeatcon());
                }else{
                    description.add("无");
                }
            }if(record4_7.getHavahighrisk()==1){
                symptoms.add("本时期有高危因素存在");
                if(record4_7.getHavahighriskdate()!=null){
                    time.add(sdf.format(record4_7.getHavahighriskdate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getHavahighriskcon()!=null&&record4_7.getHavahighriskcon()!=""){
                    description.add(record4_7.getHavahighriskcon());
                }else{
                    description.add("无");
                }
            }if(record4_7.getBeflustered()==1){
                symptoms.add("恶心，呕吐");
                if(record4_7.getBeflustereddate()!=null){
                    time.add(sdf.format(record4_7.getBeflustereddate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getBeflusteredcon()!=null&&record4_7.getBeflusteredcon()!=""){
                    description.add(record4_7.getBeflusteredcon());
                }else{
                    description.add("无");
                }
            }if(record4_7.getHeadswirl()==1){
                symptoms.add("头晕，头痛，视物不清");
                if(record4_7.getHeadswirldate()!=null){
                    time.add(sdf.format(record4_7.getHeadswirldate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getHeadswirlcon()!=null&&record4_7.getHeadswirlcon()!=""){
                    description.add(record4_7.getHeadswirlcon());
                }else{
                    description.add("无");
                }
            }if(record4_7.getFever1()==1){
                symptoms.add("心慌，憋气");
                if(record4_7.getFever1date()!=null){
                    time.add(sdf.format(record4_7.getFever1date()));
                }else{
                    time.add("无");
                }
                if(record4_7.getFever1con()!=null&&record4_7.getFever1con()!=""){
                    description.add(record4_7.getFever1con());
                }else{
                    description.add("无");
                }
            }if(record4_7.getBlood()==1){
                symptoms.add("血压≥140/90mmHg");
                if(record4_7.getBlooddate()!=null){
                    time.add(sdf.format(record4_7.getBlooddate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getBloodcon()!=null&&record4_7.getBloodcon()!=""){
                    description.add(record4_7.getBloodcon());
                }else{
                    description.add("无");
                }
            }if(record4_7.getShortweightnimiety()==1){
                symptoms.add("短时间体重增加过多");
                if(record4_7.getShortweightnimietydate()!=null){
                    time.add(sdf.format(record4_7.getShortweightnimietydate()));
                }else{
                    time.add("无");
                }
                if(record4_7.getShortweightnimietycon()!=null&&record4_7.getShortweightnimietycon()!=""){
                    description.add(record4_7.getShortweightnimietycon());
                }else{
                    description.add("无");
                }
            }
        }
        List<Record8_10> record810List=record8_10Service.findByWeeks(weeks,mid);
        for(Record8_10 record8_10:record810List){
            if(record8_10.getColporrhagia()==1){
                symptoms.add("阴道流血");
                if(record8_10.getColporrhagiadate()!=null){
                    time.add(sdf.format(record8_10.getColporrhagiadate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getColporrhagiacon()!=null&&record8_10.getColporrhagiacon()!=""){
                    description.add(record8_10.getColporrhagiacon());
                }else{
                    description.add("无");
                }
            }if(record8_10.getFever()==1){
                symptoms.add("头晕，头痛，视物不清");
                if(record8_10.getFeverdate()!=null){
                    time.add(sdf.format(record8_10.getFeverdate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getFevercon()!=null&&record8_10.getFevercon()!=""){
                    description.add(record8_10.getFevercon());
                }else{
                    description.add("无");
                }
            }if(record8_10.getBellyache()==1){
                symptoms.add("腹痛");
                if(record8_10.getBellyachedate()!=null){
                    System.out.println(record8_10.getBellyachedate());
                    time.add(sdf.format(record8_10.getBellyachedate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getBellyachecon()!=null&&record8_10.getBellyachecon()!=""){
                    description.add(record8_10.getBellyachecon());
                }else{
                    description.add("无");
                }
            }if(record8_10.getEdema()==1){
                symptoms.add("浮肿");
                if(record8_10.getEdemadate()!=null){
                    time.add(sdf.format(record8_10.getEdemadate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getEdemacon()!=null&&record8_10.getEdemacon()!=""){
                    description.add(record8_10.getEdemacon());
                }else{
                    description.add("无");
                }
            }if(record8_10.getHavahighrisk()==1){
                symptoms.add("本时期有高危因素存在");
                if(record8_10.getHavahighriskdate()!=null){
                    time.add(sdf.format(record8_10.getHavahighriskdate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getHavahighriskcon()!=null&&record8_10.getHavahighriskcon()!=""){
                    description.add(record8_10.getHavahighriskcon());
                }else{
                    description.add("无");
                }
            }if(record8_10.getBeflustered()==1){
                symptoms.add("心慌，气短，夜间不能平卧");
                if(record8_10.getBeflustereddate()!=null){
                    time.add(sdf.format(record8_10.getBeflustereddate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getBeflusteredcon()!=null&&record8_10.getBeflusteredcon()!=""){
                    description.add(record8_10.getBeflusteredcon());
                }else{
                    description.add("无");
                }
            }if(record8_10.getHeadswirl()==1){
                symptoms.add("阴道流水");
                if(record8_10.getHavahighriskdate()!=null){
                    time.add(sdf.format(record8_10.getHavahighriskdate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getHeadswirlcon()!=null&&record8_10.getHeadswirlcon()!=""){
                    description.add(record8_10.getHeadswirlcon());
                }else{
                    description.add("无");
                }
            }if(record8_10.getBlood()==1){
                symptoms.add("血压≥140/90mmHg");
                if(record8_10.getBlooddate()!=null){
                    time.add(sdf.format(record8_10.getBlooddate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getBloodcon()!=null&&record8_10.getBloodcon()!=""){
                    description.add(record8_10.getBloodcon());
                }else{
                    description.add("无");
                }
            }if(record8_10.getSabnormalfetalirrirability()==1){
                symptoms.add("胎动异常");
                if(record8_10.getSabnormalfetalirrirabilitydate()!=null){
                    time.add(sdf.format(record8_10.getSabnormalfetalirrirabilitydate()));
                }else{
                    time.add("无");
                }
                if(record8_10.getAbnormalfetalirrirabilitycon()!=null&&record8_10.getAbnormalfetalirrirabilitycon()!=""){
                    description.add(record8_10.getAbnormalfetalirrirabilitycon());
                }else{
                    description.add("无");
                }
            }/*if(record8_10.getGestationalweeks()==1){
                symptoms.add("孕周≥41");
            }*/
        }
        //删除重复字段
        for (int i = 0; i < symptoms.size() - 1; i++) {
            for (int j = symptoms.size() - 1; j > i; j--) {
                if (symptoms.get(j).equals(symptoms.get(i))) {
                    symptoms.remove(j);
                    System.out.println(description.get(j));
                    description.remove(j);
                    time.remove(j);
                }
            }
        }
        result.add(symptoms);
        result.add(time);
        result.add(description);
        return new JsonResult(result);
    }
}