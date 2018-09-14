package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Eircle;

public interface EircleMapper {
     List<Map<String,Object>> findByUserId(Integer userid);
     Eircle  findByUserIdAndeid(Integer userId,Integer eid);
      void      deleteById(@Param("userid")Integer userId,@Param("eid")Integer eid);
      void     updateAll(Eircle  eircle);
      void     updatepraise(Eircle eircle);
      void     insert(Map<String,Object> map);
}
