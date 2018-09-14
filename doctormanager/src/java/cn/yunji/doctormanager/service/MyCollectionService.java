package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.MyCollection;

/**
 * 我的收藏
 * @author zhangqt
 * @CreateDate 2017年12月11日 下午3:45:09
 */
public interface MyCollectionService {
	public int insert(MyCollection myCollection);

	/** 
	 * 以孕妇id查询收藏的内容
	 * @param mid
	 * @return list
	 * @author zhangqt
	 * @createDate 2017年12月11日 下午3:53:00
	 */
	public List<MyCollection> queryByMid(String mid);

	/** 
	 * 以主键删除收藏
	 * @param cid
	 * @return
	 * @author zhangqt
	 * @createDate 2017年12月12日 下午7:04:07
	 */
	public int deleteByCid(Integer cid);
}
