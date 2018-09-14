package cn.yunji.doctormanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.FetalException;

public interface FetalExceptionService {
	 
	int deleteByPrimaryKey(Integer feid);

	    int insert(FetalException record);

	    int insertSelective(FetalException record);

	    FetalException selectByPrimaryKey(Integer feid);

	    int updateByPrimaryKeySelective(FetalException record);

	    int updateByPrimaryKey(FetalException record);
	    /**
	     * 根据胎心id、mid查询  胎心加速次数   @yinzx
	     * @param fetalheartid
	     * @param mid
	     * @return 胎心加速次数
	     */
	    int querySpeedUpTimes(Integer fetalheartid,String mid);
	    /**
	     * 根据胎心id、mid查询加速详细数据    @yinzx
	     * @param fetalheartid
	     * @param mid
	     * @return
	     */
	    List<FetalException> querySpeedUp(Integer fetalheartid,String mid);
	    /**
	     * 根据胎心id、mid查询胎心异常详细数据    @yinzx
	     * @param fetalheartid
	     * @param mid
	     * @return
	     */
	    List<FetalException> queryByFetalheartid(Integer fetalheartid,String mid);
}
