
package cn.yunji.doctormanager.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.CheckProjectMapper;
import cn.yunji.doctormanager.entity.CheckProject;
import cn.yunji.doctormanager.service.CheckProjectService;

 

@Service("checkProjectService")
public class CheckProjectServiceImpl implements CheckProjectService {
	@Resource
	private CheckProjectMapper dao;
	@Override
	public CheckProject selectByRiskname(String riskname) {

		return dao.selectByRiskname(riskname);
	}
	@Override
	public List<Map<String, Object>> findCheckProjectAll(String mid) {
		return dao.findCheckProjectAll(mid);
	}
	@Override
	public List<Map<String, Object>> allFind(int id) {
		return dao.allFind(id);
	}
	@Override
	public CheckProject selectByPrimaryKey(Integer checkprojectid) {
		
		return dao.selectByPrimaryKey(checkprojectid);
	}
    @Override
    public List<CheckProject> selectByPrimaryKeys(List<Integer> ids) {
        return dao.selectByPrimaryKeys(ids);
    }
	

}
