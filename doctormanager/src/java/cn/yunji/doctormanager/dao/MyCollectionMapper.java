package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.MyCollection;

public interface MyCollectionMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(MyCollection record);

    int insertSelective(MyCollection record);

    MyCollection selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(MyCollection record);

    int updateByPrimaryKey(MyCollection record);

	/** 
	 * 以孕妇id查询收藏的视频
	 * @param mid
	 * @return
	 * @author zhangqt
	 * @createDate 2017年12月11日 下午5:11:09
	 */
	List<MyCollection> queryByMid(String mid);
}