package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Nurse;
/**
 * 
 * @author Wangzw
 * 护士
 */
public interface NurseMapper {
    /**
     * 查询护士的基本信息
     * @author Wangzw
     * @param nid
     * @return 护士的基本信息
     */
    List<Map<String, Object>> queryByNurseId(int nid);
    
    /**
     * 根据userid查找对应的护士
     * @author mcally.ly
     * @param userid
     * @return 护士的信息
     */
    
    Nurse findByUserid(Integer userid);
    
}