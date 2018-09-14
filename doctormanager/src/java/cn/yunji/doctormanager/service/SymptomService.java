package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Symptom;

public interface SymptomService {
    /**
     * @author wangzw
     * @return 查询症状
     */
    List<Map<String, Object>> findSymptom(String mid);

    /**
     * 插入症状数据
     * @author zhengpl
     * @param symptom
     */
    int insert(Symptom symptom);

    /**
     * 查询所有症状
     * @author zhengpl
     * @return
     */
    List<Symptom> queryAll();

    /**
     * 根据条件查询症状
     * @author zhengpl
     * @return
     */
    List<Symptom> queryByCondition(String condition);
    /**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<Symptom> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
}
