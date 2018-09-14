package cn.yunji.doctormanager.controller;

import java.sql.Timestamp;
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

import cn.yunji.doctormanager.entity.PageModel;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.CheckDetailService;
import cn.yunji.doctormanager.service.CheckindexService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/weekly2")
public class GetListController {
	@Resource
	private GravidaInfoService gravidaInfoService;

    @Resource
    private AbnormityinfoService abnormityinfoService;
    @Resource
    private CheckindexService checkindexService;
    @Resource
    private CheckDetailService checkDetailService;
    
 // 七天的long值
    Long SEVEN_DAY = 7 * 24 * 60 * 60 * 1000L;
    
	@ResponseBody
	@RequestMapping("/getFirstDiagonse.do")
	public JsonResult getFirstDiagonse() {
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> ListMap = new ArrayList<Map<String, Object>>();
		return new JsonResult(map);
	}
	/*@ResponseBody
	@RequestMapping("/getFirstDiagonse.do")
	public JsonResult getGravidaList() {
		List<Map<String,Object>> list=gravidaInfoService.findAllList();
		return new JsonResult(list);
	}*/
	/**
	 * 查询医嘱管理  患者列表     
     * @author yinzx   2017/09/18
     * @param medicalNo 病历号
     * @param sweeks 起始孕周
     * @param eweeks 结束孕周
     * @param highTypeId 高危类型id
     * @param vipgradeid   服务等级
     * @param doctor   医生编号
     * @param patienttypeid 高危编号
     * @param adviceState  处理状态
     * @param checkprojectid  检查项目
     * @param pageNo 初始页数
     * @param pageSize  每页条目数量
     * @return 不同高危类型的列表
     */
    @RequestMapping("/HighRiskQuery.do")
    @ResponseBody
    public JsonResult HighRiskQuery(String medicalNo,Integer sweeks,Integer eweeks,Integer highTypeId,Integer vipgradeid,
            Integer doctor, Integer patienttypeid, Integer adviceState , Integer pageNo, Integer pageSize) {
        if (vipgradeid == 0) vipgradeid = null;
        if (highTypeId == 0) highTypeId = null;
        if (medicalNo == "") medicalNo = null;
        if (sweeks == 0) sweeks = null;
        if (eweeks == 0) eweeks = null;
        if (patienttypeid == null) patienttypeid = 0;
        if (pageNo == null) pageNo = 0;
        if (pageSize == null)pageSize = 10;
        Date expectedconfinement=new Date();
        Long expected = expectedconfinement.getTime();
        Date end=null;
        Date begin=null;
        if(sweeks!=null){
             begin = new Date(expected - SEVEN_DAY * (eweeks));
             end = new Date(expected - SEVEN_DAY * (sweeks));
        }
      
//        System.out.println("------------------HighRiskQuery------------------");
        PageModel pageModel = findlistModel(medicalNo,begin,end,highTypeId,doctor, vipgradeid, patienttypeid,adviceState, pageNo, pageSize);
        List<Map> maplist = pageModel.getList();
//       System.out.println("size="+maplist.size());

//        System.out.println("maplist@:" + maplist);
        return new JsonResult(maplist);
    }
    /**
     * 查询周报管理  患者列表     
     * @author yinzx   2017/09/18
     * @param medicalNo 病历号
     * @param sweeks 起始孕周
     * @param eweeks 结束孕周
     * @param highTypeId 高危类型id
     * @param vipgradeid   服务等级
     * @param doctor   医生编号
     * @param patienttypeid 高危编号
     * @param adviceState  处理状态
     * @param checkprojectid  检查项目
     * @param pageNo 初始页数
     * @param pageSize  每页条目数量
     * @return 不同高危类型的列表
     */
    @RequestMapping("/queryWeeklyList.do")
    @ResponseBody
    public JsonResult queryWeeklyList(String medicalNo,Integer sweeks,Integer eweeks,Integer highTypeId,Integer vipgradeid, 
            Integer doctor, Integer patienttypeid, Integer weeklyState , Integer pageNo, Integer pageSize) {
        if (vipgradeid == 0) vipgradeid = null;
        if (highTypeId == 0) highTypeId = null;
        if (medicalNo == "") medicalNo = null;
        if (sweeks == 0) sweeks = null;
        if (eweeks == 0) eweeks = null;
        if (patienttypeid == null) patienttypeid = 0;
        if (pageNo == null) pageNo = 0;
        if (pageSize == null)pageSize = 10;
        Date expectedconfinement=new Date();
        Long expected = expectedconfinement.getTime();
        Date end=null;
        Date begin=null;
        if(sweeks!=null){
             begin = new Date(expected - SEVEN_DAY * (eweeks));
             end = new Date(expected - SEVEN_DAY * (sweeks));
        }
//        System.out.println("------------------queryWeeklyList------------------");
        PageModel pageModel = findWeeklylistModel(medicalNo,begin, end, highTypeId,doctor, vipgradeid, patienttypeid,weeklyState, pageNo, pageSize);
        List<Map> maplist = pageModel.getList();
//        System.out.println("size="+maplist.size());

//        System.out.println("maplist@:" + maplist);
        return new JsonResult(maplist);
    }
    
   /**
    *  获取医嘱管理患者的总数量
    * @param vipgradeid   服务等级
     * @param doctor   医生编号
     * @param patienttypeid 高危编号
     * @param adviceState  处理状态
    * @return
    */
    @RequestMapping("/getListCount1.do")
    @ResponseBody
    public int getListCount1(String medicalNo,Integer sweeks,Integer eweeks,Integer highTypeId,Integer vipgradeid,
            Integer doctor, Integer patienttypeid, Integer adviceState ) {
//        System.out.println(" doctor="+doctor+" patienttypeid="+patienttypeid+" adviceState"+adviceState);
        if (vipgradeid == 0) vipgradeid = null;
        if (highTypeId == 0) highTypeId = null;
        if (medicalNo == "") medicalNo = null;
        if (sweeks == 0) sweeks = null;
        if (eweeks == 0) eweeks = null;
        if (patienttypeid == null) patienttypeid = 0;
       
        Date expectedconfinement=new Date();
        Long expected = expectedconfinement.getTime();
        Date end=null;
        Date begin=null;
        if(sweeks!=null){
             begin = new Date(expected - SEVEN_DAY * (eweeks));
             end = new Date(expected - SEVEN_DAY * (sweeks));
        }
      
        int count= abnormityinfoService.getListCount1(medicalNo,begin,end, highTypeId,doctor,vipgradeid, patienttypeid, adviceState);
       
        return count;
    }
    /**
     *  获取周报管理患者的总数量
     * @param vipgradeid   服务等级
      * @param doctor   医生编号
      * @param patienttypeid 高危编号
      * @param weeklyState  处理状态
     * @return
     */
     @RequestMapping("/getListCount2.do")
     @ResponseBody
     public int getListCount2(Integer vipgradeid, Integer doctor, Integer patienttypeid, Integer weeklyState ) {
         int count= abnormityinfoService.getListCount2(vipgradeid,doctor,patienttypeid,weeklyState);
        
         return count;
     }
    //获取医嘱管理 患者信息
    public PageModel findlistModel(String medicalNo,Date sweeks,Date eweeks,Integer highTypeId,Integer doctor, Integer vipgradeid, Integer patienttypeid,Integer adviceState,Integer pageNo,
            Integer pageSize) {
        List<Map<String, Object>> gravidaInfo = null;       
            //1.查询出有那些患者
            gravidaInfo = abnormityinfoService.findPatientList(medicalNo,sweeks, eweeks, highTypeId,doctor,vipgradeid, patienttypeid, adviceState, pageNo, pageSize);
            for (int i = 0; i < gravidaInfo.size(); i++) {
                //2.该患者有多少项指标异常
                String mid=(String) gravidaInfo.get(i).get("mid");
                if (patienttypeid != 2) {
                   
                    List<Map<String, Object>> xylist = abnormityinfoService.findCidByMid(mid);
                    gravidaInfo.get(i).put("cidlist", xylist);
                }else{
                    //非高危患者  
                    List<Map<String, Object>> xylist =  findriskbymid(mid);
                    gravidaInfo.get(i).put("cidlist", xylist);
                }
               
            }
        
        int total = gravidaInfoService.countAll(1);
        PageModel pageModel = new PageModel();
        pageModel.setPageNo(pageNo);
        pageModel.setPageSize(pageSize);
        pageModel.setTotalRecords(total);
        pageModel.setList(gravidaInfo);
        return pageModel;
    }
   //获取周报管理 患者信息
    public PageModel findWeeklylistModel(String medicalNo,Date sweeks,Date eweeks,Integer highTypeId,Integer doctor, 
            Integer vipgradeid, Integer patienttypeid,Integer weeklyState,Integer pageNo, Integer pageSize) {
        List<Map<String, Object>> gravidaInfo = null;       
            //1.查询出有那些患者
            gravidaInfo = abnormityinfoService.findWeeklyList(medicalNo,sweeks, eweeks, highTypeId,doctor,vipgradeid, patienttypeid, weeklyState, pageNo, pageSize);
            for (int i = 0; i < gravidaInfo.size(); i++) {
                //2.该患者有多少项指标异常
                String mid=(String) gravidaInfo.get(i).get("mid");
                if (patienttypeid != 2) {
                   
                    List<Map<String, Object>> xylist = abnormityinfoService.findCidByMid(mid);
                    gravidaInfo.get(i).put("cidlist", xylist);
                }else{
                    //非高危患者  
                    List<Map<String, Object>> xylist =  findriskbymid(mid);
                    gravidaInfo.get(i).put("cidlist", xylist);
                }
               
            }
        
        int total = gravidaInfoService.countAll(1);
        PageModel pageModel = new PageModel();
        pageModel.setPageNo(pageNo);
        pageModel.setPageSize(pageSize);
        pageModel.setTotalRecords(total);
        pageModel.setList(gravidaInfo);
        return pageModel;
    }
    
    public List<Map<String, Object>> findriskbymid(String mid) {
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
            try{
            tempmap.put("weeks", (int) list.get(i).get("weeks"));
            }catch(NullPointerException e){
            	
            }
            
            if (deviation > 0) {
                tempmap.put("content", cname + "大于正常范围" + Math.abs(deviation) + unit + "，为" + abnormity + unit);
            } else if (deviation < 0) {
                tempmap.put("content", cname + "小于正常范围" + Math.abs(deviation) + unit + "，为" + abnormity + unit);
            }
            resultlist.add(tempmap);
        }
        return resultlist;
    }
}
