package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.WeightTestMapper;
import cn.yunji.doctormanager.entity.WeightTest;
import cn.yunji.doctormanager.service.WeightTestService;


@Service("weightTestService")
public class WeightTestServiceImpl implements WeightTestService {
	@Resource
	private WeightTestMapper weightTestDao;

	@Override
	public List<WeightTest> findByDateRange(String mid, Date begin, Date end) {
		
		return weightTestDao.findByDateRange(mid, begin, end);
	}

	
	@Override
	public WeightTest selectByPrimaryKey(Integer wid) {
		return weightTestDao.selectByPrimaryKey(wid);
	}


	
	@Override
	public WeightTest updateByPrimaryKey(Integer wid) {
		return weightTestDao.updateByPrimaryKey(wid);
	}


	
	@Override
	public List<WeightTest> selectByMid(String mid) {
		
		return weightTestDao.selectByMid(mid);
	}




	
}
