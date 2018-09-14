package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.HighriskTestMapper;
import cn.yunji.doctormanager.entity.HighriskTest;
import cn.yunji.doctormanager.service.HighriskTestService;

@Service("highriskTestService")
public class HighriskTestServiceImpl implements HighriskTestService {
	@Resource
	private HighriskTestMapper highriskTestMapper;

	@Override
	public List<Map<String, Object>> findByMid(String mid) {
		return highriskTestMapper.findByMid(mid);
	}

	@Override
	public int insertLoop(List<HighriskTest> highriskTest) {
		// TODO Auto-generated method stub
		return highriskTestMapper.insertLoop(highriskTest);
	}

	/**@methodName findByMidandweeks
	 * @description: 
	 * @param mid
	 * @param begintime
	 * @param endtime
	 * @return 
	 * @see cn.yunji.doctormanager.service.HighriskTestService#findByMidandweeks(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Map<String, Object>> findByMidandweeks(String mid, String begintime, String endtime) {
		
		return highriskTestMapper.findByMidandweeks(mid, begintime, endtime);
	}

}
