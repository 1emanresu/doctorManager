package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.PregnancyCheck;

public interface PregnancyCheckMapper {
    int deleteByPrimaryKey(Integer pcheckid);

    int insert(PregnancyCheck record);

    int insertSelective(PregnancyCheck record);

    PregnancyCheck selectByPrimaryKey(Integer pcheckid);

    int updateByPrimaryKeySelective(PregnancyCheck record);

    int updateByPrimaryKey(PregnancyCheck record);
  /**
   * 根据备孕编号 更新信息
   * @author yinzx
   * @param pregnancyCheck
   * @return
   */
    int updateByPcid(PregnancyCheck pregnancyCheck);
    /**
     * 根据备孕编号 查询信息
     * @author yinzx
     * @param pregnancyCheck
     * @return
     */
    PregnancyCheck findByPcid(int pcid);
}