package cn.yunji.doctormanager.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.yunji.doctormanager.entity.Abnormityinfo;
import cn.yunji.doctormanager.entity.CheckResult;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.Templatetitle;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.service.CheckResultService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.TemplatetitleService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 检查结果Controller
 * 
 * @author zhengpl
 */
@Controller
@RequestMapping("/checkResult")
public class CheckResultController {
    @Resource
    private CheckResultService checkResultService;
    @Resource
    private GravidaInfoService gravidaInfoService;
    @Resource
    private TemplatetitleService TemplatetitleService;
    @Resource
    private AbnormityinfoService abnormityinfoService;
    Long SEVEN_DAY = 7 * 24 * 60 * 60 * 1000L;

    /**
     * 根据checkresultid查询结果
     * 
     * @param checkresultid
     * @return
     * @author luoyc
     * @createDate 2017年11月20日 下午8:12:18
     */
    @RequestMapping("/selectByPrimaryKey.do")
    @ResponseBody
    public JsonResult selectByPrimaryKey(Integer resultid) {
        CheckResult checkResult = checkResultService.selectByPrimaryKey(resultid);
        return new JsonResult(checkResult);
    }

    /**
     * 查询检查时间通用接口 （仅支持血常规、尿常规、糖筛、NIPT、羊水穿刺、心电图、B超、胎心）
     * 
     * @param mid
     *            孕妇id
     * @param checkProjectId
     *            检查项目id
     * @return
     */
    @RequestMapping("/queryCheckDate.do")
    @ResponseBody
    public JsonResult queryCheckDate(String mid, Integer checkProjectId) {
        List<Map<String, Object>> list = checkResultService.queryByProjectId(mid, checkProjectId);
        if (null != list) {
            return new JsonResult(list);
        }
        return new JsonResult("");
    }

    @RequestMapping("/selectCheckDetailByMId.do")
    @ResponseBody
    public JsonResult selectCheckDetailByMId(String mid, Integer checkProjectId, Integer weeks) {
        List<Map<String, Object>> list = checkResultService.selectCheckDetailByMId(mid, checkProjectId, weeks);
        if (list != null) {
            return new JsonResult(list);
        }
        return new JsonResult("");
    }

    /**
     * 查询检查明细数据
     * 
     * @param weeks
     *            孕周
     * @param checkProjectId
     *            检查项目id
     * @return
     */
    @RequestMapping("/queryCheckDetail.do")
    @ResponseBody
    public JsonResult queryCheckDetail(Integer weeks, Integer checkProjectId) {
        List<Map<String, Object>> list = checkResultService.queryCheckDetail(weeks, checkProjectId);
        if (null != list) {
            return new JsonResult(list);
        }
        return new JsonResult("");
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
    @RequestMapping("/queryCheckDetailByWeeks.do")
    @ResponseBody
    public JsonResult queryCheckDetailByWeeks(Integer startWeek, Integer endWeek, Integer checkProjectId, String mId) {
        List<Object> list = new ArrayList<>();
        for (int i = startWeek; i <= endWeek; i++) {
            List<Map<String, Object>> clist = checkResultService.queryCheckDetailByMId(i, checkProjectId, mId);
            if (clist.size() > 0) {
                list.add(clist);
            }

        }
        return new JsonResult(list);
    }

    
    
  /**
   * 
   * 根据孕周、mid 查询孕程的检查明细及检查指标
   * @param weeks
   * @param checkProjectId
   * @param mId
   * @return JsonResult(List<Map<String, Object>>)
   * @author wanghp
   * @createDate 2018年1月3日 上午9:46:35
   */
    @RequestMapping("/getCheckDetailByMid.do")
    @ResponseBody
    public JsonResult getCheckDetailByMid(Integer weeks,String mId) {
        List<Map<String, Object>> clist = null;
        try {
            clist = checkResultService.getCheckDetailByMid(weeks,mId);
        } catch (NullPointerException e) {
            throw new NullPointerException("空指针异常"+e.getMessage());
        }
        return clist == null ? null : new JsonResult(clist);
    }
    /**
     * 
     * 根据孕周、mid 查询孕程的检查明细及检查指标
     * @param weeks
     * @param checkProjectId
     * @param mId
     * @return JsonResult(List<Map<String, Object>>)
     * @author yinzx
     * @createDate 2018年1月3日 上午9:46:35
     */
      @RequestMapping("/getCheckReportDetailByMid.do")
      @ResponseBody
      public JsonResult getCheckReportDetailByMid(Integer weeks,String mId) {
          Map<String, List<Map<String, Object>>> map = null;
          try {
              map = checkResultService.getCheckReportDetailByMid(weeks,mId);
          } catch (NullPointerException e) {
              throw new NullPointerException("空指针异常"+e.getMessage());
          }
          return map == null ? null : new JsonResult(map);
      }
    /**
     * 根据孕周、mid、 检查项目id查询检查明细数据
     * 
     * @param weeks
     *            孕周
     * @param checkProjectId
     *            检查项目id
     * @param mId
     *            孕妇id
     * @return
     */
    @RequestMapping("/queryCheckDetailByMId.do")
    @ResponseBody
    public JsonResult queryCheckDetailByMId(Integer weeks, Integer checkProjectId, String mId) {
        List<Map<String, Object>> list = checkResultService.queryCheckDetailByMId(weeks, checkProjectId, mId);
        Templatetitle templatetitle = TemplatetitleService.queryCheckDetail(weeks, checkProjectId, mId);
        // System.out.println(templatetitle);
        Map<String, Object> map = new HashMap<>();
        map.put("templatetitle", templatetitle);
        if (null != list) {
            list.add(map);
            return new JsonResult(list);
        }
        return new JsonResult("");
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
        List<Map<String, Object>> resultlist = checkResultService.queryCheckResultId(checkProjectId, mId);
        Integer resultId;
        Date checkDate;
        Map<String, Object> map = new HashMap<>();
        if (count != 0) {
            if (resultlist.size() >= count) {
                resultId = (Integer) resultlist.get(count - 1).get("checkResultId");
                checkDate = (Date) resultlist.get(count - 1).get("checkDate");
            } else {
                resultId = (Integer) resultlist.get(0).get("checkResultId");
                checkDate = (Date) resultlist.get(0).get("checkDate");
            }

            // System.out.println(resultlist.size());
            // System.out.println("resultId="+resultId+" checkDate="+checkDate);
            List<Map<String, Object>> list = checkResultService.queryResultByProject(resultId, checkProjectId, mId);
            Templatetitle templatetitle = TemplatetitleService.queryCheckDetailByDate(checkDate, checkProjectId, mId);

            List<Map<String, Object>> abnormityinfo = abnormityinfoService.queryByCheckProjectId(mId, checkDate,
                    checkProjectId);
            map.put("checkResult", list);
            if (templatetitle != null) {
                map.put("templatetitle", templatetitle);
            }
            if (abnormityinfo.size() > 0) {
                map.put("abnormityinfo", abnormityinfo);// 异常信息
            }
        }
        return new JsonResult(map);
    }

    @RequestMapping("/queryHistoByCname.do")
    @ResponseBody
    public JsonResult queryHistoByCname(Integer checkProjectId, String mId, String[] cnamelist) {
        Map<String, Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        if (cnamelist.length != 0) {
            for (int i = 0; i < cnamelist.length; i++) {
                List<Map<String, Object>> resultlist = checkResultService.queryHistoByCname(checkProjectId, mId,
                        cnamelist[i]);
                list.add(resultlist);
            }
        }
        map.put("checkResult", list);
        return new JsonResult(map);
    }

    @RequestMapping("/checkReportftl.do")
    public String checkReport(Model model, String mid, @DateTimeFormat(pattern = "yyyy/MM/dd") Date checkDate,
            Integer projectId) {
        GravidaInfo gravidaInfo = gravidaInfoService.find(mid);
        CheckResult checkResult = checkResultService.queryByCheckDate(mid, checkDate, projectId);
        List<Map<String, Object>> list = checkResultService.queryCheckDetailByDate(checkDate, projectId);
        model.addAttribute("hospital", "东莞医院");
        model.addAttribute("name", gravidaInfo.getGname());
        for (Map<String, Object> result : list) {
            String flag = "";
            BigDecimal checkValue = (BigDecimal) result.get("checkValue");
            BigDecimal cbegin = (BigDecimal) result.get("cbegin");
            BigDecimal cend = (BigDecimal) result.get("cend");
            if (checkValue.compareTo(cbegin) == -1) {
                flag = " ↓";
            } else if (checkValue.compareTo(cend) == 1) {
                flag = " ↑";
            }
            result.put("checkValue", checkValue + flag);
            result.put("cbegin", cbegin + "");
            result.put("cend", cend + "");
        }
        model.addAttribute("list", list);
        return "checkReport.ftl";
    }

    /**
     * 根据孕妇id获取B超报告中腹围、双顶径和股骨长的值计算胎儿体重
     * 
     * @author luoyc
     * @param mid
     * @return 对应孕周的胎儿体重
     * @throws ParseException
     * @throws NumberFormatException
     */
    // luoyc 2017-9-29注释，B超报告必须包含某三个指标才能进行计算，b超不一定有这些指标，无实际意义。
    /*
     * @RequestMapping("/queryFetalWeight.do")
     * 
     * @ResponseBody public JsonResult queryFetalWeight(String mid) throws
     * NumberFormatException, ParseException { //根据孕妇id获取B超报告中腹围、双顶径和股骨长
     * List<Map<String, Object>> Bscanlist =
     * checkResultService.selectFetalWeightByMid(mid); GravidaInfo
     * gravidaInfo=gravidaInfoService.find(mid); //获取孕妇预产期 Date
     * expectedconfinement=gravidaInfo.getExpectedconfinement(); Long
     * expected=expectedconfinement.getTime(); //孕一周起点的long值 Long
     * start=expected-SEVEN_DAY*40; DecimalFormat df = new DecimalFormat("0.0");
     * SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); int
     * index=0; double BPDSum=0.0; double FLSum=0.0; double ACSum=0.0; double
     * BPDAve=0.0; double FLAve=0.0; double ACAve=0.0; List<Integer>
     * gestationalWeeksList=new ArrayList(); List<String> fetalWeightList=new
     * ArrayList(); double fetalWeight=0.0; for(int j=1;j<43;j++){ //每次循环先把值归0
     * index=0; BPDSum=0.0; FLSum=0.0; ACSum=0.0; BPDAve=0.0; FLAve=0.0;
     * ACAve=0.0; fetalWeight=0.0; //判断插入数据日期属于哪个孕周 for(int
     * i=0;i<Bscanlist.size();i++){
     * if(sdf.parse(Bscanlist.get(i).get("checkDate").toString()).getTime()>=
     * start+SEVEN_DAY*(j-1)&&sdf.parse(Bscanlist.get(i).get("checkDate").
     * toString()).getTime()<start+SEVEN_DAY*j){
     * //System.out.println("i:"+i+"j:"+j); //记录次数 index++;
     * gestationalWeeksList.add(j); //将每周提交的B超报告值都加起来 BPDSum
     * +=Double.parseDouble(Bscanlist.get(i).get("BPD").toString()); FLSum
     * +=Double.parseDouble(Bscanlist.get(i).get("FL").toString()); ACSum
     * +=Double.parseDouble(Bscanlist.get(i).get("AC").toString()); } }
     * if(index!=0){ BPDAve=BPDSum/index; FLAve=FLSum/index; ACAve=ACSum/index;
     * fetalWeight=(1.07*BPDAve*BPDAve*BPDAve+0.3*ACAve*ACAve*FLAve)/1000;
     * fetalWeightList.add(df.format(fetalWeight)); } } //删除重复的孕周 for(int
     * i=0;i<gestationalWeeksList.size()-1;i++){ for(int
     * j=gestationalWeeksList.size()-1;j>i;j--){
     * if(gestationalWeeksList.get(j).equals(gestationalWeeksList.get(i))){
     * gestationalWeeksList.remove(j); } } } List list= new ArrayList();
     * list.add(gestationalWeeksList); list.add(fetalWeightList); return new
     * JsonResult(list); }
     */
    /**
     * 查询这一周内所有的检查结果
     * 
     * @author luoyc
     * @param mid
     * @return
     */
    @RequestMapping("/queryWeeklyUploadReport.do")
    @ResponseBody
    public JsonResult queryWeeklyUploadReport(String mid) {
        Date end = new Date();
        Date begin = new Date(end.getTime() - SEVEN_DAY);
        List<CheckResult> checkResulList = checkResultService.findByDateRange(mid, begin, end);
        return new JsonResult(checkResulList);
    }

    /**
     * 查询指定范围内所有的检查结果——包含指标和结果详情。
     * 
     * @author luoyc
     * @param mid
     * @return
     */
    @RequestMapping("/queryResultByDateRange.do")
    @ResponseBody
    public JsonResult queryResultByDateRange(String mid, Integer sWeeks, Integer eWeeks) {
        GravidaInfo gravidaInfo = gravidaInfoService.find(mid);
        Date expectedconfinement = gravidaInfo.getExpectedconfinement();
        Long expected = expectedconfinement.getTime();
        Date end = new Date(expected - SEVEN_DAY * (40 - eWeeks));
        Date begin = new Date(expected - SEVEN_DAY * (40 - sWeeks));
        List<CheckResult> checkResulList = checkResultService.findByDateRange(mid, begin, end);
        return new JsonResult(checkResulList);
    }

    /**
     * 查询指定范围内所有的检查结果——包含指标和结果详情。
     * 
     * @author luoyc
     * @param mid
     * @return
     */
    @RequestMapping("/queryResultByDateRange2.do")
    @ResponseBody
    public JsonResult queryResultByDateRange2(String mid, Date end) {
        Date begin = new Date(end.getTime() - SEVEN_DAY);
        List<CheckResult> checkResulList = checkResultService.findByDateRange(mid, begin, end);
        return new JsonResult(checkResulList);
    }

    /**
     * 根据周报上传时间查询检查报告结果
     * 
     * @author luoyc
     * @param mid
     * @param uploaddate
     * @return
     */
    @RequestMapping("/queryResultByUploadDate.do")
    @ResponseBody
    public JsonResult queryResultByDateRange(String mid, Date uploaddate) {
        List<List> resultList = new ArrayList();
        List<String> tableStr;
        GravidaInfo gravidaInfo = gravidaInfoService.find(mid);
        Date expectedconfinement = gravidaInfo.getExpectedconfinement();
        Long expected = expectedconfinement.getTime();
        Date begin = new Date(uploaddate.getTime() - SEVEN_DAY);
        List<CheckResult> checkResulList = checkResultService.findByDateRange2(mid, begin, uploaddate);
        for (CheckResult checkResult : checkResulList) {
            tableStr = new ArrayList();
            tableStr.add(checkResult.getCheckProject().getRiskname());
            if (checkResult.getAbnormityinfo().size() == 0) {
                tableStr.add("正常");
            } else {
                tableStr.add(checkResult.getAbnormityinfo().size() + 1 + "项异常");
            }
            resultList.add(tableStr);
        }
        return new JsonResult(resultList);
    }
}