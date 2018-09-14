package cn.yunji.doctormanager.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.HighRiskRtandard;

public interface HighRiskRtandardMapper {
    int deleteByPrimaryKey(Integer highriskstandardid);

    int insert(HighRiskRtandard record);

    int insertSelective(HighRiskRtandard record);

    HighRiskRtandard selectByPrimaryKey(Integer highriskstandardid);

    int updateByPrimaryKeySelective(HighRiskRtandard record);

    int updateByPrimaryKey(HighRiskRtandard record);
    
    List<HighRiskRtandard> queryById(@Param("hid") String hid,@Param("cid") int cid);

    HighRiskRtandard queryHighRiskRtandard(@Param("value") Number value,@Param("hid") String hid,@Param("cid") int cid,
			@Param("flag") boolean flag);
    List<HighRiskRtandard> findByCid(HighRiskRtandard record);
    
    HighRiskRtandard selectBycid(Integer cid);
}