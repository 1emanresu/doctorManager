package cn.yunji.doctormanager.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.event.CaretListener;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.AbnormityinfoMapper;
import cn.yunji.doctormanager.dao.BloodpressureMapper;
import cn.yunji.doctormanager.dao.CheckDetailMapper;
import cn.yunji.doctormanager.dao.HighriskTestMapper;
import cn.yunji.doctormanager.dao.WeightTestMapper;
import cn.yunji.doctormanager.entity.Abnormityinfo;
import cn.yunji.doctormanager.entity.Bloodpressure;
import cn.yunji.doctormanager.entity.WeightTest;
import cn.yunji.doctormanager.service.AbnormityinfoService;
import cn.yunji.doctormanager.util.BaseUtil;
@Service("abnormityinfoService")
public class AbnormityinfoServiceImpl implements AbnormityinfoService {
	@Resource
	private AbnormityinfoMapper abnormityinfoMapper;
	@Resource
    private CheckDetailMapper checkDetailDAO;
	@Resource
    private WeightTestMapper WeightTestDAO;
	@Resource
	private BloodpressureMapper bloodpressureDAO;
	@Resource
    private HighriskTestMapper highriskTestMapper;
	@Override
	public Abnormityinfo queryByMid(String mid, Date checkDate,int cid) {
		return abnormityinfoMapper.queryByMid(mid,checkDate,cid);
	} 
	@Override
	public int addAbnormityinfo(Abnormityinfo abnormityinfo) {
		return abnormityinfoMapper.insert(abnormityinfo);
	}
	@Override
	public List<Map<String, Object>> queryByCheckProjectId(String mid, Date checkdate, Integer checkProjectId) {
		return abnormityinfoMapper.queryByCheckProjectId(mid, checkdate, checkProjectId);
	}
	@Override
	public List<Map<String, Object>> queryByDate(Map<String,Object> map) {
		return abnormityinfoMapper.queryByDate(map);
	}
	@Override
	public List<Map<String, Object>> queryByWeeks(Map<String, Object> map) {
		return abnormityinfoMapper.queryByWeeks(map);
	}
	
	public List<Map<String, Object>> queryByAll() {
		return abnormityinfoMapper.queryByAll();
	}
	public Map<String, Object> queryByAllDate(String mid) {
		return abnormityinfoMapper.queryByAllDate(mid);
	}
	public List<Map<String, Object>> queryByWCheckDate(String mid) {
		return abnormityinfoMapper.queryByWCheckDate(mid);
	}
	public List<Map<String, Object>> queryByCCheckDate(String mid) {
		return abnormityinfoMapper.queryByCCheckDate(mid);
	}
	public List<Map<String, Object>> queryByCids(int... cids) {
		return abnormityinfoMapper.queryByCids(cids);
	}
	public Map<String, Object> querybyCidHightTypeId(int cid, int hightTypeId) {
		return abnormityinfoMapper.querybyCidHightTypeId(cid, hightTypeId);
	}
	@Override
	public List<Map<String, Object>> findShouAll(int cid,String mid) {
		return abnormityinfoMapper.findShouAll(cid,mid); 
	}
	@Override
	public List<Map<String, Object>> findByMid(String mid) {
		return abnormityinfoMapper.findByMid(mid);
	}
	@Override
	public List<Map<String, Object>> findByWeeks(Map<String, Object> map) {
		return abnormityinfoMapper.findByWeeks(map);
	}
	@Override
	public List<Abnormityinfo> findByDateRange(String mid, Date begin, Date end) {
		return abnormityinfoMapper.findByDateRange(mid, begin, end);
	}
	@Override
	public List<Map<String, Object>> findrisk(String mid) {
		return abnormityinfoMapper.findrisk(mid);
	}
	@Override
	public List<Abnormityinfo> findByCpidAndMid(String mid, Integer cpid, Date begin, Date end) {
		return abnormityinfoMapper.findByCpidAndMid(mid, cpid, begin, end);
	}
	@Override
	public List<Abnormityinfo> queryByMidAll(String mid) {
		return abnormityinfoMapper.queryByMidAll(mid);
	}
    @Override
    public List<Map<String, Object>> findPatientList(String medicalNo, Date sweeks, Date eweeks,Integer highTypeId,
            Integer doctor,Integer vipgradeid,Integer patientTypeId,Integer adviceState,Integer pageNo,Integer pageSize) {
        List<Map<String, Object>> list = abnormityinfoMapper.findPatientList(medicalNo,sweeks, eweeks, highTypeId,doctor, vipgradeid,patientTypeId, adviceState, pageNo, pageSize);
        for(int i=0;i<list.size();i++){
            String mid=(String) list.get(i).get("mid");
            List<Map<String, Object>> hlist = highriskTestMapper.findByMid(mid);
            list.get(i).put("highRiskList", hlist);
           try {
            int weeks=BaseUtil.getWeeks2((Date)list.get(i).get("endDate"));
            list.get(i).put("weeks", weeks);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
           switch (patientTypeId) {
               case 1:
               { //妊娠高血压
                   //血压 
                   Bloodpressure b = bloodpressureDAO.findNewPressure(mid);
                    if(b!=null ){
                        //收缩压
                         list.get(i).put("spressure","收缩压:"+b.getSystolic()+"mmHg");
                         //舒张压
                         list.get(i).put("dpressure","舒张压:"+b.getDiastolic()+"mmHg");
                    }
                    //尿蛋白
                    Map<String, Object> uplist = checkDetailDAO.queryNewByCid(1,mid);
                    if(uplist!=null && uplist.size()>0){
                        String UProtein=(String) uplist.get("cname")+uplist.get("checkvalue")+ "mg/L";
                        list.get(i).put("UProtein", UProtein);
                    }
                   break;
               }   
               case 3:
               { //妊娠合并贫血
                   //红细胞
                    Map<String, Object> redlist = checkDetailDAO.queryNewByCid(13,mid);
                    if(redlist!=null ){
                        String symbol=(String)redlist.get("symbol");
                        if(symbol==null){
                            symbol="";
                        }
                        String  RBC=(String) redlist.get("cname")+redlist.get("checkvalue")+symbol ;
                        list.get(i).put("RBC",  RBC);
                    }
                    //血红蛋白
                    Map<String, Object> bredlist = checkDetailDAO.queryNewByCid(14,mid);
                    if(bredlist!=null ){
                        String symbol=(String)bredlist.get("symbol");
                        if(symbol==null){
                            symbol="";
                        }
                        String HGB=(String) bredlist.get("cname")+bredlist.get("checkvalue")+ symbol;
                        list.get(i).put("HGB", HGB);
                    }
                   break;
               }    
               case 4:
               {//妊娠糖尿病
                 //空腹葡萄糖
                   Map<String, Object> bredlist = checkDetailDAO.queryNewByCid(118,mid);
                   if(bredlist!=null ){
                       String FBG=(String) bredlist.get("cname")+bredlist.get("checkvalue")+ "mmol/L";
                       list.get(i).put("FBG", FBG);
                   }
                   break;
               }
               case 5:
                {//妊娠肥胖
                    List<WeightTest> wlist = WeightTestDAO.find(mid);
                    if(wlist!=null && wlist.size()>0){
                        //首检体重
                        String preWeight = wlist.get(0).getPregnancy();
                       //最新体重
                       String nowWeight = wlist.get(wlist.size()-1).getPregnancy();
                       list.get(i).put("preWeight", preWeight);
                       list.get(i).put("nowWeight", nowWeight);
                    }
                    break;
                }
           }
       }
       
        return list;
    }
    @Override
    public List<Map<String, Object>> findWeeklyList(String medicalNo, Date sweeks, Date eweeks,Integer highTypeId,
            Integer doctor,Integer vipgradeid,Integer patientTypeId,Integer weeklyState,Integer pageNo,Integer pageSize) {
        // TODO Auto-generated method stub
        List<Map<String, Object>> list = abnormityinfoMapper.findWeeklyList(medicalNo,sweeks, eweeks, highTypeId,doctor,vipgradeid, patientTypeId, weeklyState, pageNo, pageSize);
        for(int i=0;i<list.size();i++){
            String mid=(String) list.get(i).get("mid");
            List<Map<String, Object>> hlist = highriskTestMapper.findByMid(mid);
            list.get(i).put("highRiskList", hlist);
            try {
                int weeks=BaseUtil.getWeeks2((Date)list.get(i).get("endDate"));
                list.get(i).put("weeks", weeks);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           switch (patientTypeId) {
               case 1:
               { //妊娠高血压
                   //血压 
                   Bloodpressure b = bloodpressureDAO.findNewPressure(mid);
                    if(b!=null ){
                        //收缩压
                         list.get(i).put("spressure","收缩压:"+b.getSystolic()+"mmHg");
                         //舒张压
                         list.get(i).put("dpressure","舒张压:"+b.getDiastolic()+"mmHg");
                    }
                    //尿蛋白
                    Map<String, Object> uplist = checkDetailDAO.queryNewByCid(1,mid);
                    if(uplist!=null && uplist.size()>0){
                        String UProtein=(String) uplist.get("cname")+uplist.get("checkvalue")+ "mg/L";
                        list.get(i).put("UProtein", UProtein);
                    }
                   break;
               }   
               case 3:
               { //妊娠合并贫血
                   //红细胞
                    Map<String, Object> redlist = checkDetailDAO.queryNewByCid(13,mid);
                    if(redlist!=null ){
                        String symbol=(String)redlist.get("symbol");
                        if(symbol==null){
                            symbol="";
                        }
                        String  RBC=(String) redlist.get("cname")+redlist.get("checkvalue")+symbol ;
                        list.get(i).put("RBC",  RBC);
                    }
                    //血红蛋白
                    Map<String, Object> bredlist = checkDetailDAO.queryNewByCid(14,mid);
                    if(bredlist!=null ){
                        String symbol=(String)bredlist.get("symbol");
                        if(symbol==null){
                            symbol="";
                        }
                        String HGB=(String) bredlist.get("cname")+bredlist.get("checkvalue")+ symbol;
                        list.get(i).put("HGB", HGB);
                    }
                   break;
               }    
               case 4:
               {//妊娠糖尿病
                 //空腹葡萄糖
                   Map<String, Object> bredlist = checkDetailDAO.queryNewByCid(118,mid);
                   if(bredlist!=null ){
                       String FBG=(String) bredlist.get("cname")+bredlist.get("checkvalue")+ "mmol/L";
                       list.get(i).put("FBG", FBG);
                   }
                   break;
               }
               case 5:
                {//妊娠肥胖
                    List<WeightTest> wlist = WeightTestDAO.find(mid);
                    if(wlist!=null && wlist.size()>0){
                        //首检体重
                        String preWeight = wlist.get(0).getPregnancy();
                       //最新体重
                       String nowWeight = wlist.get(wlist.size()-1).getPregnancy();
                       list.get(i).put("preWeight", preWeight);
                       list.get(i).put("nowWeight", nowWeight);
                    }
                    break;
                }
           }
       }
       
        return list;
    }
    @Override
    public List<Map<String, Object>> findCidByMid(String mid) {
        List<Map<String, Object>> clict=abnormityinfoMapper.findCidByMid(mid);
        for (int i = 0; i < clict.size(); i++) {
           
            Integer cid=(Integer) clict.get(i).get("cid");
           
            Integer resultid=(Integer) clict.get(i).get("resultid");
            System.out.println("cid="+cid+" resultid="+resultid);
            if(cid!=null&&resultid!=null){
               Map<String, Object> rmap = checkDetailDAO.findByCidandResultId(cid, resultid);
               Integer score = abnormityinfoMapper.findScoreByCid(mid, cid, resultid);
               if(rmap!=null&&score != null){
                   rmap.put("score", score);
               }
               clict.get(i).put("checkDetail", rmap);
            }
        }
        
        return clict;
    }
    @Override
    public int getListCount1(String medicalNo, Date sweeks, Date eweeks,Integer highTypeId, Integer doctor,Integer vipgradeid,
            Integer patientTypeId,Integer adviceState) {
        return abnormityinfoMapper.getListCount1(medicalNo,sweeks,eweeks,highTypeId,doctor,vipgradeid,  patientTypeId,  adviceState);
    }
    @Override
    public int getListCount2(Integer vipgradeid, Integer doctor, Integer patienttypeid, Integer weeklyState) {
        return abnormityinfoMapper.getListCount2(vipgradeid, doctor, patienttypeid,  weeklyState);
    }
    @Override
    public List<Abnormityinfo> findByResultId(Integer resultId) {
        return abnormityinfoMapper.findByResultId(resultId);
    }
	/**@methodName queryByWeeks
	 * @description: 
	 * @param mid
	 * @param begintime
	 * @param endtime
	 * @return 
	 * @see cn.yunji.doctormanager.service.AbnormityinfoService#queryByWeeks(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Abnormityinfo> selectByWeeks(String mid, String begintime, String endtime) {
		
		return abnormityinfoMapper.selectByWeeks(mid, begintime, endtime);
	}
    @Override
    public List<Map> findByDateRangeCount(String mid, Date begin, Date end) {
        return abnormityinfoMapper.findByDateRangeCount(mid, begin, end);
    }

}
