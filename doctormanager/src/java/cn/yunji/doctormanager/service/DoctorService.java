package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Doctor;

/**
 * 
 * @author Wangzw
 *  医生
 */
public interface DoctorService {
  
	/**
	 * @author Wangzw
	 * @param did 医生编号
	 * @return 医生信息
	 */
	 List<Map<String, Object>>  queryByDoctortId(int did);
	/**
	 * @author wangzw 
	 * @param doctorId 医生编号
	 * @return 医生个人信息
	 */
	 public Doctor findDoctor(int doctorId);
	 
		/**
		 * @author mcally.ly
		 * @param doctorId  医生id
		 * @return 医生个人信息及其医院患者，粉丝，积分详情
		 * 
		 */
		Map<String,Object> doctorBasicAndfansAndIntegral(Integer did);
	 
		/**
		 * @author mcally.ly
		 * @param doctorId  医生id
		 * @return  根据医生id 查找对应的孕妇异常信息
		 * 
		 */
	 
		List<Map<String,Object>>  riskprewarning(Integer doctorid);
		
		/**
		 * 添加医生
		 * @author zhangqt
		 * @param doctor
		 * @return int
		 * 
		 */
		int addDoctorAccount(Doctor doctor);
		/**
		 * 查询所有医生的账户信息，包括所属医院、科室
		 * @param hid （医院id）、dname(医生名称) 都是可选参数
		 * @author zhangqt
		 * @return List<Map>
		 * @createDate 2017年10月31日 上午10:05:25
		 */
		List<Map<String, Object>> queryInfo(String hid, String dname,Integer pageIndex,Integer pageSize);
		
		/**
		 * 查询所有医生的账户信息，包括所属医院、科室
		 * @param hid （医院id）、dname(医生名称) 都是可选参数
		 * @author zhangqt
		 * @return count 总条数
		 * @createDate 2017年10月31日 上午10:05:25
		 */
		int queryInfoCount(String hid, String dname);
 
		int updateByPrimaryKeySelective(Doctor record);

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
	    int alertOffid(Integer offID, Integer doctorid);
}








