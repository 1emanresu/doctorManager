package cn.yunji.doctormanager.service;

import cn.yunji.doctormanager.entity.NeteasyIm;

/**
 * @Description: 网易IM账号
 * @author yinzx
 * @CreateDate 2017年11月24日 上午9:35:14
 */
public interface NeteasyImService {

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
    
    int insertSelective(NeteasyIm record);
}
