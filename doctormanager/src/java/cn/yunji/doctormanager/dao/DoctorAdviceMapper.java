package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Bloodoxygen;
import cn.yunji.doctormanager.entity.DoctorAdvice;

public interface DoctorAdviceMapper {
    int deleteByPrimaryKey(Integer daid);

    int insert(DoctorAdvice record);

    int insertSelective(DoctorAdvice record);

    DoctorAdvice selectByPrimaryKey(Integer daid);

    int updateByPrimaryKeySelective(DoctorAdvice record);

    int updateByPrimaryKey(DoctorAdvice record);
    
    /**
	 * 查询孕妇医嘱
	 * @param mid 孕妇ID
	 * @return List结果集
	 */
    List<DoctorAdvice> doctorAdviceQueryByMid(String mid);
   /**
    * @author luoyc 
    * @param doctorAdvice
    * @return
    * 插入医生建议并返回主键
    */
    Integer insertDoctorAdvice(DoctorAdvice doctorAdvice);
    /**
     * 根据日期范围查询指定孕妇的医嘱 
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<DoctorAdvice> findByDateRange(String mid,Date begin,Date end);

    /**
	 * 查询孕妇医嘱
	 * @param mid 孕妇ID,keyword 关键字（可选）
	 * @return List结果集
	 */
	List<DoctorAdvice> findByMid(@Param("mid")String mid,@Param("keyword") String keyword,@Param("sdate") String sdate,@Param("edate") String edate,@Param("pageIndex") Integer pageIndex,@Param("pageSize")Integer pageSize);
}