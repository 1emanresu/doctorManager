package cn.yunji.doctormanager.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.KeyAttention;

public interface KeyAttentionService {
    KeyAttention selectByPrimaryKey(Integer kid);
   /**
    * 根据id数组查询数据
    * @author luoyc
    * @param ids
    * @return
    */
   List<KeyAttention> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
}
