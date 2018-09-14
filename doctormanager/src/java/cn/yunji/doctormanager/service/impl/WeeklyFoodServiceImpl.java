package cn.yunji.doctormanager.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.WeeklyFoodMapper;
import cn.yunji.doctormanager.entity.WeeklyFood;
import cn.yunji.doctormanager.service.WeeklyFoodService;


@Service("weeklyFoodService")
public class WeeklyFoodServiceImpl implements WeeklyFoodService {
	@Resource
	private WeeklyFoodMapper weeklyFoodDao;

    @Override
    public List<WeeklyFood> selectByPrimaryKeys(List<Integer> ids) {

        return weeklyFoodDao.selectByPrimaryKeys(ids);
    }

    @Override
    public WeeklyFood findByWeek(Integer week) {
        
        return weeklyFoodDao.findByWeek(week);
    }
}
