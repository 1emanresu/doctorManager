package cn.yunji.doctormanager.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.service.FetalHeartDataService;
import cn.yunji.doctormanager.dao.FetalHeartDataMapper;
import cn.yunji.doctormanager.entity.FetalHeartData;
@Service("fetalHeartDataService")
public class FetalHeartDataServiceImpl implements FetalHeartDataService{
	@Resource
	private FetalHeartDataMapper fetalHeartDataDAO;
	@Override
	public int insertSelective(FetalHeartData record) {
		int[] ylist=record.getFHlistArr();
		String str1=Arrays.toString(ylist).replace(" ", "");
	    //System.out.println(str1);
		//System.out.println(str1.length());
		record.setFhrlist(str1);
		int[] fmlist=record.getFMlistArr();
		String str2=Arrays.toString(fmlist).replace(" ", "");
		record.setFmlist(str2);
		int[] uclist=record .getUClistArr();
		String str3=Arrays.toString(uclist).replace(" ", "");
		record.setUclist(str3);
		return fetalHeartDataDAO.insertSelective(record);
	
	}

	@Override
	public FetalHeartData selectByPrimaryKey(Integer fdid) {
		return fetalHeartDataDAO.selectByPrimaryKey(fdid);
	}

	@Override
	public int updateByPrimaryKeySelective(FetalHeartData record) {
		return fetalHeartDataDAO.updateByPrimaryKey(record);
	}

	@Override
	public List<FetalHeartData> findByMid(String mid) {
		return fetalHeartDataDAO.findByMid(mid);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		List<Map<String, Object>> list = fetalHeartDataDAO.findAll();
		return list;
	}

    @Override
    public FetalHeartData findSmallByMid(String mid) {
       List<FetalHeartData> list = fetalHeartDataDAO.findSmallByMid(mid);
       FetalHeartData fhData=null;
       if(list!=null &&list.size()>0){
           fhData=list.get(0);
       }
        return fhData;
    }

    @Override
    public FetalHeartData findLargeByMid(String mid) {
        FetalHeartData fhData=null;
       List<FetalHeartData> list = fetalHeartDataDAO.findLargeByMid(mid);
        if(list!=null &&list.size()>0){
            fhData=list.get(0);
        }
        return fhData;
    }

    @Override
    public List<FetalHeartData> findByDateRange(String mid, Date begin, Date end) {
        return fetalHeartDataDAO.findByDateRange(mid, begin, end);
    }

	
}
