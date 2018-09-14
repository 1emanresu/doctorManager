package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.Expertsayarticle;

public interface ExpertsayarticleMapper {
    int deleteByPrimaryKey(Integer idexpertsayarticle);

    int insert(Expertsayarticle record);

    int insertSelective(Expertsayarticle record);

    Expertsayarticle selectByPrimaryKey(Integer idexpertsayarticle);

    int updateByPrimaryKeySelective(Expertsayarticle record);

    int updateByPrimaryKeyWithBLOBs(Expertsayarticle record);

    int updateByPrimaryKey(Expertsayarticle record);
    
    /**
     * 查询孕期保健的文章
     * @author yinzx
     * @return
     */
	public List<Expertsayarticle> findHealthArticle();
	  /**
     * 查询孕期妊娠疾病的文章
     * @author yinzx
     * @return
     */
	public List<Expertsayarticle> findDiseaseArticle();
	 /**
     * 查询孕期保健的视频
     * @author yinzx
     * @return
     */
	public List<Expertsayarticle> findHealthVideo();
	/**
     * 查询孕期妊娠疾病的视频
     * @author yinzx
     * @return
     */
	public List<Expertsayarticle> findDiseaseVideo();
}