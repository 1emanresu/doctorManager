package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.NeteasyIm;

public interface NeteasyImMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NeteasyIm record);

    int insertSelective(NeteasyIm record);

    NeteasyIm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NeteasyIm record);

    int updateByPrimaryKey(NeteasyIm record);
    /**
     * 通过userid查询出网易账号相关信息 
     * @Description: TODO(用一句话描述该方法做什么) 
     * @author yinzx
     * @createDate 2017年11月24日 上午9:34:10
     * @param userid
     * @return
     */
    NeteasyIm findByUserid(Integer userid);
    
    /**
     * 通过mid查询出网易账号相关信息 
     * @Description: TODO(用一句话描述该方法做什么) 
     * @author yinzx
     * @createDate 2017年11月24日 上午9:34:10
     * @param userid
     * @return
     */
    NeteasyIm findIMByMid(String mid);
    
}