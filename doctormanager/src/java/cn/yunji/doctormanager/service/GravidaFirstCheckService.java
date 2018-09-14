package cn.yunji.doctormanager.service;

import java.util.Map;

public interface GravidaFirstCheckService {
    /**
     * 按mid查询孕妇首检信息
     * @author yinzx
     * @param mid
     * @return
     */
    Map<String, Object> findByMid(String mid);

}
