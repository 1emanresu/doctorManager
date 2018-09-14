package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.FetalExceptionMapper;
import cn.yunji.doctormanager.entity.FetalException;
import cn.yunji.doctormanager.service.FetalExceptionService;
@Service("fetalExceptionService")
public class FetalExceptionServiceImpl implements FetalExceptionService{

	@Resource
	private FetalExceptionMapper FetalExceptionDao;
	@Override
	public int deleteByPrimaryKey(Integer feid) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.deleteByPrimaryKey(feid);
	}

	@Override
	public int insert(FetalException record) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.insert(record);
	}

	@Override
	public int insertSelective(FetalException record) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.insertSelective(record);
	}

	@Override
	public FetalException selectByPrimaryKey(Integer feid) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.selectByPrimaryKey(feid);
	}

	@Override
	public int updateByPrimaryKeySelective(FetalException record) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FetalException record) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.updateByPrimaryKey(record);
	}

	@Override
	public int querySpeedUpTimes(Integer fetalheartid, String mid) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.querySpeedUpTimes(fetalheartid, mid);
	}

	@Override
	public List<FetalException> querySpeedUp(Integer fetalheartid, String mid) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.querySpeedUp(fetalheartid, mid);
	}

	@Override
	public List<FetalException> queryByFetalheartid(Integer fetalheartid, String mid) {
		// TODO Auto-generated method stub
		return FetalExceptionDao.queryByFetalheartid(fetalheartid, mid);
	}

}
