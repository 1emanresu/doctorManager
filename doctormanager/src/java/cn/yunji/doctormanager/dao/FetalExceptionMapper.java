package cn.yunji.doctormanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.FetalException;

public interface FetalExceptionMapper {
   
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
    int querySpeedUpTimes(@Param("fetalheartid")Integer fetalheartid,@Param("mid")String mid);
    /**
     * 根据胎心id、mid查询加速详细数据    @yinzx
     * @param fetalheartid
     * @param mid
     * @return
     */
    List<FetalException> querySpeedUp(@Param("fetalheartid")Integer fetalheartid,@Param("mid")String mid);
    /**
     * 根据胎心id、mid查询胎心异常详细数据    @yinzx
     * @param fetalheartid
     * @param mid
     * @return
     */
    List<FetalException> queryByFetalheartid(@Param("fetalheartid")Integer fetalheartid,@Param("mid")String mid);
}