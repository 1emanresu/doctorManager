package cn.yunji.doctormanager.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FetalheartMapper;
import cn.yunji.doctormanager.entity.Fetalheart;
import cn.yunji.doctormanager.service.FetalHeartService;
import cn.yunji.doctormanager.entity.FetalException;
import cn.yunji.doctormanager.util.FetalMethod;
import cn.yunji.doctormanager.util.UcDemo;

@Service("fetalHeartService")
public class FetalHeartServiceImpl implements FetalHeartService {
	
	@Resource
	private FetalheartMapper fetalheartMapper;

	@Override
	public Fetalheart search(Fetalheart fetalheart) {
		return fetalheartMapper.search(fetalheart);
	}

	@Override
	public List<Map<String, Object>> queryDescription(Integer weeks) {
		return fetalheartMapper.queryDescription(weeks);
	}

	@Override
	public Fetalheart findByMid(String mid, Date checkDate) {
		return fetalheartMapper.findByMid(mid, checkDate);
	}

	@Override
	public List<Fetalheart> findByMidAndProject(Integer checkProjectId, String mId) {
		return fetalheartMapper.findByMidAndProject(checkProjectId, mId);
	}

	@Override
	public List<Fetalheart> findByMidAndWeek(Integer checkProjectId, String mId, Integer weeks) {
		return fetalheartMapper.findByMidAndWeek( checkProjectId,  mId,  weeks);
	}
	@Override
	public List<FetalException> analysisUC(List<Integer> xlist, List<Integer> ylist,int t)throws ParseException {
		UcDemo demo=new UcDemo(xlist,ylist);
        List<Double> plist = FetalMethod.pretreatment(ylist);
        plist=FetalMethod.pretreatment2(plist, 4);
        demo.setPlist(plist);
        List<Double> ret = null;
        try {
			 ret=FetalMethod.deepCopy(plist);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        List<Double> baseline = FetalMethod.getBaseLine(ret, 4, 5);
       demo.setBaseline(baseline);
       List<Double> ret2 = null;
       try {
			 ret2=FetalMethod.deepCopy(plist);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
        List<Double> fitlist = FetalMethod.fittingData(xlist,ret2, 30);
        demo.setFitList(fitlist);
        demo.setDifList(FetalMethod.diffitList(fitlist));
       // 获取详情宫缩信息
     	List<FetalException> msglist = FetalMethod.getUcMsg(demo,t);
     	msglist= FetalMethod.distinct(msglist);
     	if (msglist.size() > 0) {
			demo.setMsglist(msglist);

		}
		return msglist;
	}

    @Override
    public List<Fetalheart> findByDateRange(String mid, Date begin, Date end) {
        return fetalheartMapper.findByDateRange(mid, begin, end);
    }

}
