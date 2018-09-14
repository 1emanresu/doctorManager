package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.SymptomMapper;
import cn.yunji.doctormanager.entity.Symptom;
import cn.yunji.doctormanager.service.SymptomService;
/**
 * 
 * @author wangzw
 * 症状
 */
@Service("symptomService")
public class SymptomServiceImpl implements SymptomService{
    
	@Resource
	private SymptomMapper symptomDao;
	
	@Override
	public List<Map<String, Object>> findSymptom(String mid) {
		return symptomDao.findSymptom(mid);
	}
	
    @Override
    public int insert(Symptom symptom) {
        return symptomDao.insertSelective(symptom);
    }

    @Override
    public List<Symptom> queryAll() {
        return symptomDao.queryAll();
    }

    @Override
    public List<Symptom> queryByCondition(String condition) {
        return symptomDao.queryByCondition(condition);
    }

    @Override
    public List<Symptom> selectByPrimaryKeys(List<Integer> ids) {
        return symptomDao.selectByPrimaryKeys(ids);
    }

}
