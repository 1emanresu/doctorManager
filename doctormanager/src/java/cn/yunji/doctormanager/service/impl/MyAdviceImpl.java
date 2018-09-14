package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.MyAdviceMapper;
import cn.yunji.doctormanager.entity.MyAdvice;
import cn.yunji.doctormanager.service.MyAdviceService;
@Service("myAdvice")
public class MyAdviceImpl implements MyAdviceService {
	@Resource
	private MyAdviceMapper MyAdviceDao;

	@Override
	public int insert(MyAdvice record) {
		return MyAdviceDao.insert(record);
	}

	/**根据医生id查询所有我的医嘱
	 */
	@Override
	public List<MyAdvice> selectByDoctorId(Integer doctorid) {
		
		return MyAdviceDao.selectByDoctorId(doctorid);
	}
	
}
