package cn.yunji.doctormanager.service;

 
import cn.yunji.doctormanager.entity.UserTb;

/**
 * 
 * @author wangzw
 *
 */
public interface UserTbService {
	/**
	 *  @author wangzw
	 * @param userTb
	 * @return 更新用户头像
	 */
	int updateByPrimaryKeySelective(UserTb userTb);
	
	/**
	 * 添加用户
	 *  @author zhangqt
	 * @param userTb
	 * @return int
	 */
	int addUser(UserTb userTb);
	/**
	 * 检查密码账号
	 * @param userName
	 * @param password
	 * @return
	 */
	UserTb findByNameAndpassword(String  userName, String password);
	/**
	 * 根据电话号码查
	 * @param username
	 * @return
	 */
	UserTb selectByName(String username);
}
