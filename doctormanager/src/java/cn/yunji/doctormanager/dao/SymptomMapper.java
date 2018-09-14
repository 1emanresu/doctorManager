package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.CheckProject;
import cn.yunji.doctormanager.entity.Symptom;

public interface SymptomMapper {
    int deleteByPrimaryKey(Integer symptomdetailid);

    int insert(Symptom record);

    int insertSelective(Symptom record);
    /**
     * 根据主键数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<Symptom> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
    Symptom selectByPrimaryKey(Integer symptomdetailid);

    int updateByPrimaryKeySelective(Symptom record);

    int updateByPrimaryKey(Symptom record);
    
    /**
     * @author wangzw
     * @return 查询症状
     */
    List<Map<String, Object>> findSymptom(String mid);

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
    List<Symptom> queryByCondition(@Param("condition") String condition);
}