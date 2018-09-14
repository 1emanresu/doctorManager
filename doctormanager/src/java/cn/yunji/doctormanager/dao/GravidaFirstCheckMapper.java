package cn.yunji.doctormanager.dao;

import java.util.Map;

import cn.yunji.doctormanager.entity.GravidaFirstCheck;

public interface GravidaFirstCheckMapper {
    int deleteByPrimaryKey(Integer gfcid);

    int insert(GravidaFirstCheck record);

    int insertSelective(GravidaFirstCheck record);

    GravidaFirstCheck selectByPrimaryKey(Integer gfcid);

    int updateByPrimaryKeySelective(GravidaFirstCheck record);

    int updateByPrimaryKey(GravidaFirstCheck record);
    /**
     * 按mid查询孕妇首检信息
     * @author yinzx
     * @param mid
     * @return
     */
    Map<String, Object> findByMid(String mid);
}