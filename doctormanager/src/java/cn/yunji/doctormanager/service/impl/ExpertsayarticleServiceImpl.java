package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.ExpertsayarticleMapper;
import cn.yunji.doctormanager.entity.Expertsayarticle;
import cn.yunji.doctormanager.service.ExpertsayarticleService;
@Service("expertsayarticleService")
public class ExpertsayarticleServiceImpl implements ExpertsayarticleService{

	@Resource
	private ExpertsayarticleMapper expertsayarticleDAO;
	@Override
	public List<Expertsayarticle> findHealthArticle() {
		// TODO Auto-generated method stub
		return expertsayarticleDAO.findHealthArticle();
	}

	@Override
	public List<Expertsayarticle> findDiseaseArticle() {
		// TODO Auto-generated method stub
		return expertsayarticleDAO.findDiseaseArticle();
	}

	@Override
	public List<Expertsayarticle> findHealthVideo() {
		// TODO Auto-generated method stub
		return expertsayarticleDAO.findHealthVideo();
	}

	@Override
	public List<Expertsayarticle> findDiseaseVideo() {
		// TODO Auto-generated method stub
		return expertsayarticleDAO.findDiseaseVideo();
	}

}
