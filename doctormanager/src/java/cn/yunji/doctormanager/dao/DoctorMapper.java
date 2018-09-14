package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Doctor;

public interface DoctorMapper {
	int deleteByPrimaryKey(Integer doctorid);

	int insert(Doctor record);

	int insertSelective(Doctor record);

	Doctor selectByPrimaryKey(Integer doctorid);

	Doctor selectByPrimaryKey2(Integer userid);

	int updateByPrimaryKeySelective(Doctor record);

	int updateByPrimaryKey(Doctor record);

	/**
	 * @author wangzw
	 * @param did
	 *            医生编号
	 * @return 返回医生列表
	 */
	List<Map<String, Object>> queryByDoctortId(int did);

	/**
	 * @author wangzw
	 * @param doctorId
	 *            医生编号
	 * @return 医生个人信息
	 */
	public Doctor findDoctor(int doctorId);

	/**
	 * @author mcally.ly
	 * @param dname
	 *            医生的名字
	 * @return 返回医生的职称title
	 */

	Map<String, Object> selectByDname(String dname);

	/**
	 * 查询所有医生的账户信息，包括所属医院、科室
	 * 
	 * @param hid
	 *            （医院id）、dname(医生名称) 都是可选参数
	 * @author zhangqt
	 * @return List<Map>
	 * @createDate 2017年10月31日 上午10:05:25
	 */
	List<Map<String, Object>> queryInfo(@Param("hid") String hid, @Param("dname") String dname,
			@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

	 /** 查询所有医生的账户信息，包括所属医院、科室
	 * @param hid
	 *            （医院id）、dname(医生名称) 都是可选参数
	 * @author zhangqt
	 * @return count 总条数
	 * @createDate 2017年10月31日 上午10:05:25
	 */
	int queryInfoCount(@Param("hid") String hid, @Param("dname") String dname);
	
	/**
	 *  查询所有的产科的医生
	 * @Description: TODO(用一句话描述该方法做什么) 
	 * @param officeId
	 * @return
	 * @author wangzw
	 */
	List<Doctor> findByofficeId(Integer offItemId);

	/**
     *  修改医生的子科室id
     * @Description: TODO(用一句话描述该方法做什么) 
     * @param offID
     * @return
     * @author wangzw
     */
	int alertOffid(@Param("offID") Integer offID,@Param("doctorid") Integer doctorid);
}