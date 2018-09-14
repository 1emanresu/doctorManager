package cn.yunji.doctormanager.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Prescription;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(Integer preid);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(Integer preid);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);

    /**
     * @author zhangqt
     * 查询孕妇的用药记录
     * @param mid 孕妇id
     * @return list
     */
	List<Prescription> queryByMid(String mid);
	/**
     * 根据日期范围查询指定孕妇的用药记录
     * @author luoyc
     * @param mid
     * @param begin
     * @param end
     * @return
     */
    List<Prescription> findByDateRange(String mid,Date begin,Date end);
    /**
     * 根据mid和处方日期查出对应孕妇的用药记录
     * @param mid
     * @param predate
     * @return
     */
    List<Prescription> selectByPredate(@Param("mid") String mid,@Param("predate") Date predate);
}