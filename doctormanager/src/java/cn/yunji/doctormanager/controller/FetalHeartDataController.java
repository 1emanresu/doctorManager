package cn.yunji.doctormanager.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.FetalHeartData;
import cn.yunji.doctormanager.service.FetalHeartDataService;
import cn.yunji.doctormanager.util.BaseUtil;
import cn.yunji.doctormanager.util.JsonResult;
/**
 * 胎心监护曲线数据
 * @author yinzx
 *
 */

@Controller
@RequestMapping("/fetalHeartData")
public class FetalHeartDataController {

	@Resource
	private FetalHeartDataService fetalHeartDataService;
	@ResponseBody
	@RequestMapping("/insert.do")
	public JsonResult insert(FetalHeartData fetalData) {
//		System.out.println("******************       insert.do         *****************");
		fetalHeartDataService.insertSelective(fetalData);
		return new JsonResult();
	}
	@ResponseBody
	@RequestMapping("/findByMid.do")
	public JsonResult findByMid(String mid) {
//		System.out.println("******************       findByMid.do         *****************");
		
		return new JsonResult(fetalHeartDataService.findByMid(mid));
	}
	/**
     * 按mid查询最新一条  小孕周胎心数据
     * @param mid
     * @return
     */
	@ResponseBody
    @RequestMapping("/findSmallByMid.do")
    public JsonResult findSmallByMid(String mid) {
//        System.out.println("******************       findSmallByMid.do         *****************");
        FetalHeartData fhData = fetalHeartDataService.findSmallByMid(mid);
       
        String fmString=fhData.getFmlist();
        if(fmString!=null&&fmString.indexOf("[")>=0){
            String[] fmlist=toStringArr(fmString);
           
            fhData.setFMlistArr(toIntArr(fmlist));
        }
        String[] fhrlist=toStringArr(fhData.getFhrlist());
        fhData.setFHlistArr(toIntArr(fhrlist));
      
        return new JsonResult(fhData);
    }
	/**
	 * 按mid查询最新一条  大孕周胎心数据
	 * @param mid
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/findLargeByMid.do")
    public JsonResult findLargeByMid(String mid) {
//        System.out.println("******************       findLargeByMid.do         *****************");
        FetalHeartData fhData = fetalHeartDataService.findLargeByMid(mid);
        String ucString;
        if(fhData.getUclist()!=null){
            ucString=fhData.getUclist();
            String[] uclist=toStringArr(ucString);
            fhData.setUClistArr(toIntArr(uclist));
        }
        String fmString=fhData.getFmlist();
       
        if(fmString!=null&&fmString.indexOf("[")>=0){
            String[] fmlist=toStringArr(fmString);
           
            fhData.setFMlistArr(toIntArr(fmlist));
        }
        String[] fhrlist=toStringArr(fhData.getFhrlist());
        fhData.setFHlistArr(toIntArr(fhrlist));
       
        return new JsonResult(fhData);
    }
	/**
	 * 查询所有胎心监护数据 （胎心工作站 列表）
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/findAll.do")
	public JsonResult findAll() throws ParseException {
//		System.out.println("******************       findAll.do         *****************");
		List<Map<String, Object>> list = fetalHeartDataService.findAll();
		for (int i = 0; i < list.size(); i++) {
			String ucString=(String) list.get(i).get("UClist");
			if(ucString!=null){
				String[] uclist=toStringArr(ucString);
				list.get(i).put("uclist",uclist);
			}
			String[] fhrlist=toStringArr((String) list.get(i).get("FHRlist"));
			list.get(i).put("fhrlist",fhrlist);
			String fmString=(String) list.get(i).get("FMlist");
			if(fmString!=null){
				String[] fmlist=toStringArr(fmString);
				list.get(i).put("fmlist",fmlist);
			}
			Date enddate=(Date) list.get(i).get("enddate");
			if (enddate!=null) {
				String weeks=BaseUtil.getWeeks(enddate);
				list.get(i).put("weeks", weeks);
			}
		}
		return new JsonResult(list);
	}
	public String[] toStringArr(String str) {
		String str2 = str.substring(1, str.length()-1);
		String[] arr=str2.split(",");
		return arr;
	}
	public int[] toIntArr(String[] str) {
       int length=str.length;
       int[] intArr=new int[length];
       for (int i = 0; i < str.length; i++) {
          intArr[i]=Integer.parseInt(str[i]);
       }
        return intArr;
    }
}
