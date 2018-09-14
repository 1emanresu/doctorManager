package cn.yunji.doctormanager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.yunji.doctormanager.dao.CheckResultMapper;
import cn.yunji.doctormanager.entity.CheckResult;
import cn.yunji.doctormanager.service.CheckResultService;
import cn.yunji.doctormanager.util.JsonResult;

@Service("checkResultService")
public class CheckResultServiceImpl implements CheckResultService {

    @Resource
    private CheckResultMapper checkResultMapper;

    @Override
    public List<Map<String, Object>> queryByProjectId(String mid, Integer projectId) {
        String tableName = null;
        switch (projectId) {
            case 1:// 血常规
            case 2:// 尿常规
                tableName = "checkresult";
                break;
            case 10:// 糖筛
                tableName = "tangscreen";
                break;
            case 11:// NIPT
                tableName = "nipt";
                break;
            case 12:// 羊水穿刺
                tableName = "amniocentesis";
                break;
            case 13:// 心电图
                tableName = "electrocardio";
                break;
            case 14:// B超
                tableName = "bscan";
                break;
            case 26:// 胎心
                tableName = "fetalheart";
                break;
            default:
                return null;
        }
        return checkResultMapper.queryByProjectId(mid, projectId, tableName);
    }

    @Override
    public CheckResult selectByMid(CheckResult record) {

        return checkResultMapper.selectByMid(record);
    }

    @Override
    public List<Map<String, Object>> queryCheckDetail(Integer weeks, Integer checkProjectId) {
        return checkResultMapper.queryCheckDetail(weeks, checkProjectId);
    }

    @Override
    public List<Map<String, Object>> queryCheckDetailByMId(Integer weeks, Integer checkProjectId, String mid) {
        return checkResultMapper.queryCheckDetailByMId(weeks, checkProjectId, mid);
    }

    @Override
    public CheckResult queryByCheckDate(String mid, Date checkDate, Integer projectId) {
        return checkResultMapper.queryByCheckDate(mid, checkDate, projectId);
    }

    @Override
    public List<Map<String, Object>> queryCheckDetailByDate(Date checkDate, Integer projectId) {
        return checkResultMapper.queryCheckDetailByDate(checkDate, projectId);
    }

    @Override
    public List<Map<String, Object>> queryResultByProject(Integer checkResultId, Integer checkProjectId, String mId) {
        return checkResultMapper.queryResultByProject(checkResultId, checkProjectId, mId);
    }

    @Override
    public List<Map<String, Object>> queryCheckResultId(Integer checkProjectId, String mId) {
        return checkResultMapper.queryCheckResultId(checkProjectId, mId);
    }

    @Override
    public List<Map<String, Object>> selectFetalWeightByMid(String mid) {
        return checkResultMapper.selectFetalWeightByMid(mid);
    }

    @Override
    public List<Map<String, Object>> queryHistoByCname(Integer checkProjectId, String mId, String cname) {
        return checkResultMapper.queryHistoByCname(checkProjectId, mId, cname);
    }

    @Override
    public List<CheckResult> findByDateRange(String mid, Date begin, Date end) {
        return checkResultMapper.findByDateRange(mid, begin, end);
    }

    @Override
    public List<CheckResult> findByDateRange2(String mid, Date begin, Date end) {
        return checkResultMapper.findByDateRange2(mid, begin, end);
    }

    @Override
    public List<CheckResult> findByDateRange3(String mid, Date begin, Date end, Integer checkprojectid) {
        return checkResultMapper.findByDateRange3(mid, begin, end, checkprojectid);
    }

    /**
     * @methodName selectCheckDetailByMId
     * @description:
     * @param mid
     * @param checkprojectId
     * @param weeks
     * @return
     * @see cn.yunji.doctormanager.service.CheckResultService#selectCheckDetailByMId(java.lang.String,
     *      java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<Map<String, Object>> selectCheckDetailByMId(String mid, Integer checkProjectId, Integer weeks) {

        return checkResultMapper.selectCheckDetailByMId(mid, checkProjectId, weeks);
    }

    @Override
    public CheckResult selectByPrimaryKey(Integer checkresultid) {
        return checkResultMapper.selectByPrimaryKey(checkresultid);
    }

    @Override
    public  List<Map<String, Object>> getCheckDetailByMid(Integer weeks, String mid) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = checkResultMapper.getCheckDetailByMid(weeks, mid);
        Map<String, List<Map<String, Object>>> resultMap = new HashMap<String, List<Map<String, Object>>>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> tempMap = list.get(i);
                String key = list.get(i).get("checkProjectId").toString();
                if (resultMap.containsKey(key)) {
                    resultMap.get(key).add(tempMap);
                } else {// map中不存在，新建key，用来存放数据
                    List<Map<String, Object>> tmpList = new ArrayList<Map<String, Object>>();
                    tmpList.add(tempMap);
                    resultMap.put(key, tmpList);
                }
            }
        }
        
        return list;
    }
    @Override
    public Map<String, List<Map<String, Object>>> getCheckReportDetailByMid(Integer weeks, String mId) {
        // TODO Auto-generated method stub
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = checkResultMapper.getCheckDetailByMid(weeks, mId);
        Map<String, List<Map<String, Object>>> resultMap = new HashMap<String, List<Map<String, Object>>>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> tempMap = list.get(i);
                String key = list.get(i).get("checkProjectId").toString();
                if (resultMap.containsKey(key)) {
                    resultMap.get(key).add(tempMap);
                } else {// map中不存在，新建key，用来存放数据
                    List<Map<String, Object>> tmpList = new ArrayList<Map<String, Object>>();
                    tmpList.add(tempMap);
                    resultMap.put(key, tmpList);
                }
            }
        }
        return resultMap;
    }
    public String keyToStr(int key) {
        String tableName = "";
        switch (key) {
            case 1:// 血常规
                tableName = "routineBlood";
                break;
            case 2:// 尿常规
                tableName = "routineUrine";
                break;
            case 7:// 优生五项
                tableName = "eugenicsFive";
                break;
            case 29:// 输血八项
                tableName = "bloodTransfusionEight";
                break;
            case 3:// 肝功能
                tableName = "LiverFunction";
                break;
            case 5:// 空腹血糖
                tableName = "bloodSugar";
                break;
            case 31:// HBsAg
                tableName = "hBsAg";
                break;
            case 32:// 梅毒螺旋体
                tableName = "treponemaPallidum";
                break;
            case 33:// HIV
                tableName = "hiv";
                break;
            case 35:// 宫颈细胞学检
                tableName = "cervicalCytology";
                break;
            case 13:// 心电图
                tableName = "ecg";
                break;
            case 14:// B超
                tableName = "bscan";
                break;
            case 26:// 胎心 NST
                tableName = "fetalheart";
                break;
            case 10:// 唐筛
                tableName = "tangSieve";
                break;
            case 11:// NIPT
                tableName = "nipt";
                break;
            case 4:// 肾功能
                tableName = "renalFunction";
                break;
            default:
                return null;
        }
        return tableName;
    }

   

}
