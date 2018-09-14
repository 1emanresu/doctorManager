package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.MyCollectionMapper;
import cn.yunji.doctormanager.entity.MyCollection;
import cn.yunji.doctormanager.service.MyCollectionService;

/**
 * 我的收藏
 * @author zhangqt
 * @CreateDate 2017年12月11日 下午3:46:34
 */
@Service("myCollectionService")
public class MyCollectionServiceImpl implements MyCollectionService {
	@Resource
	private MyCollectionMapper myCollectionDao;
	@Override
	public int insert(MyCollection myCollection) {
		return myCollectionDao.insert(myCollection);
	}
	@Override
	public List<MyCollection> queryByMid(String mid) {
		return myCollectionDao.queryByMid(mid);
	}
	@Override
	public int deleteByCid(Integer cid) {
		return myCollectionDao.deleteByPrimaryKey(cid);
	}

}
