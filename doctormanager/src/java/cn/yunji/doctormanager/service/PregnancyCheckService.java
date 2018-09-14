package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.PregnancyCheck;

/*
 * 备孕体检表  @author yinzx  2017/9/20
 */
public interface PregnancyCheckService {
 /**
  * 添加或更新 备孕体检信息
  * @author yinzx
  * @param pregnancyCheck
  * @return
  */
    int addOfUpdate(PregnancyCheck pregnancyCheck);
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
    /**
     * 添加备孕体检信息 
     * @author yinzx 
     * @param record
     * @return
     */
    int add(PregnancyCheck record);
}
