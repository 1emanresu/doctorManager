package cn.yunji.doctormanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.KeyAttention;

public interface KeyAttentionMapper {
    int deleteByPrimaryKey(Integer kid);

    int insert(KeyAttention record);

    int insertSelective(KeyAttention record);

    KeyAttention selectByPrimaryKey(Integer kid);
    /**
     * 根据id数组查询数据
     * @author luoyc
     * @param ids
     * @return
     */
    List<KeyAttention> selectByPrimaryKeys(@Param("ids")List<Integer> ids);

    int updateByPrimaryKeySelective(KeyAttention record);

    int updateByPrimaryKey(KeyAttention record);

}