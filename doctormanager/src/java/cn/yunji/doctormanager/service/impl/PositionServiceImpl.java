package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.PositionMapper;
import cn.yunji.doctormanager.entity.Position;
import cn.yunji.doctormanager.service.PositionService;

/**
 * 职位
 * @author zhangqt
 * @CreateDate 2017年10月31日 下午3:19:07
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
	@Resource
	private PositionMapper positionDao;
	@Override
	public List<Position> find() {
		return positionDao.find();
	}

}
