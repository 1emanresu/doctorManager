package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Electrocardio;

public interface ElectrocardioMapper {
    int deleteByPrimaryKey(Integer elid);

    int insert(Electrocardio record);

    int insertSelective(Electrocardio record);

    Electrocardio selectByPrimaryKey(Integer elid);

    int updateByPrimaryKeySelective(Electrocardio record);

    int updateByPrimaryKey(Electrocardio record);

	/**
	 * 根据孕妇ID查询心电信息
	 * @param mid
	 * @param checkDate
	 * @return
	 */
	Electrocardio queryByMid(@Param("mid") String mid,@Param("checkDate")  Date checkDate);

	/**
	 * 根据孕周查询心电描述及提示
	 * @param weeks
	 * @return
	 */
	List<Map<String, Object>> queryElectrocardioTip(@Param("weeks") Integer weeks);
	/**
	  * 根据孕周、mid、 检查项目id查看B超报告  yinzx
	  * @param mid
	  * @param weeks
	  * @return
	  */
	Electrocardio findByMidAndWeeks(@Param("weeks")Integer weeks, @Param("checkProjectId")Integer checkProjectId, @Param("mId")String mId);
	/**
	 *  根据检查项目、孕妇id查询明细信息(按日期升序) yinzx
	 * @param checkProjectId
	 * @param mId
	 * @return  list
	 */
	List<Electrocardio> findByMidAndProject( @Param("checkProjectId")Integer checkProjectId, @Param("mId")String mId);

}