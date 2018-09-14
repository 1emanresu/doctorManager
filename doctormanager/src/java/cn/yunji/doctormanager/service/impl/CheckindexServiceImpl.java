package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.CheckindexMapper;
import cn.yunji.doctormanager.entity.Checkindex;
import cn.yunji.doctormanager.service.CheckindexService;

@Service("checkindexService")
public class CheckindexServiceImpl implements CheckindexService {

	@Resource
	private CheckindexMapper CheckindexMapper;

	@Override
	public int deleteByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Checkindex> queryByProjectId(int cpid) {
		// TODO Auto-generated method stub
		return CheckindexMapper.queryByProjectId(cpid);
	}

	@Override
	public int insert(Checkindex record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Checkindex record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Checkindex selectByPrimaryKey(Integer cid) {
		return CheckindexMapper.selectByPrimaryKey(cid);
	}

	@Override
	public int updateByPrimaryKeySelective(Checkindex record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Checkindex record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Checkindex> queryByProjectId(Integer projectId) {
		// TODO Auto-generated method stub
		return CheckindexMapper.queryByProjectId(projectId);
	}

	@Override
	public Map<String, Object> queryShouAll(int checkProjectId,int cid) {
		// TODO Auto-generated method stub
		return CheckindexMapper.queryShouAll(checkProjectId, cid);
	}

	@Override
	public String findCNameByCid(int cid) {
		// TODO Auto-generated method stub
		return CheckindexMapper.findCNameByCid(cid);
	}

}
