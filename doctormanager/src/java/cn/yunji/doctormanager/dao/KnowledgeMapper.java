package cn.yunji.doctormanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Knowledge;

public interface KnowledgeMapper {
    int deleteByPrimaryKey(Integer knowledgeid);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    Knowledge selectByPrimaryKey(Integer knowledgeid);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKey(Knowledge record);
    
    Knowledge queryById(int highRiskResultTypeId, int cid);

    Knowledge selectByHidandCid(@Param("hid")Integer hid,@Param("cid")Integer cid);

    Knowledge selectByCidHType(Integer cid,Integer highType);
    
    List<Knowledge> queryByListId(int cid);
    /**
     * 根据关键字模糊查询相关医嘱
     * @author luoyc
     * @param keyword
     * @return
     */
    List<String> queryByKeyword(String keyword);
}