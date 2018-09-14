package cn.yunji.doctormanager.dao;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Checkindex;

public interface CheckindexMapper {
	int deleteByPrimaryKey(Integer cid);

	int insert(Checkindex record);

	int insertSelective(Checkindex record);

	Checkindex selectByPrimaryKey(Integer cid);

	int updateByPrimaryKeySelective(Checkindex record);

	int updateByPrimaryKey(Checkindex record);

	/**
	 * 根据检查项目ID查询检查指标
	 * 
	 * @param projectId
	 *            检查项目ID
	 * @return
	 */
	List<Checkindex> queryByProjectId(Integer projectId);

	/**
	 * @author wangzw
	 * @param 指标的id查询指标 checkProjectId
	 * @return 所有的血压的指标
	 */
	 Map<String, Object> queryShouAll(int checkProjectId,int cid);
	 /**
	  * 根据cid查询指标名称
	  * @author yinzx
	  * @param cid
	  * @return
	  */
	 String findCNameByCid(int cid);
}