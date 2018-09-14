package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import cn.yunji.doctormanager.entity.Abdominalgirth;
import cn.yunji.doctormanager.entity.Fundalheight;

public interface AbdominalgirthMapper {
    int deleteByPrimaryKey(Integer agid);

    int insert(Abdominalgirth record);

    int insertSelective(Abdominalgirth record);
    /**
     * 根据孕妇Id查询所有的腹围自测数据
     * @author luoyc
     * @param mid
     * @return
     */
    List<Abdominalgirth> findByMid(String mid);

    int updateByPrimaryKeySelective(Abdominalgirth record);

    int updateByPrimaryKey(Abdominalgirth record);
    /**
     * 根据日期范围查询指定孕妇腹围数据 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Abdominalgirth> findByDateRange(String mid,Date begin,Date end);
}