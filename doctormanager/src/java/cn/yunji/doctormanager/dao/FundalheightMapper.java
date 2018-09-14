package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import cn.yunji.doctormanager.entity.Fundalheight;

public interface FundalheightMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Fundalheight record);

    int insertSelective(Fundalheight record);
    /**
     * 根据mid查询所有宫高数据
     * @author luoyc
     * @param mid
     * @return
     */
    List<Fundalheight> findByMid(String mid);

    int updateByPrimaryKeySelective(Fundalheight record);
    int updateByPrimaryKey(Fundalheight record);
    /**
     * 根据日期范围查询指定孕妇宫高数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Fundalheight> findByDateRange(String mid,Date begin,Date end);
}