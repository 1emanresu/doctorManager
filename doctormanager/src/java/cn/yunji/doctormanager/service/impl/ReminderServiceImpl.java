package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.ReminderMapper;
import cn.yunji.doctormanager.entity.Reminder;
import cn.yunji.doctormanager.service.ReminderService;

@Service("reminderService")
public class ReminderServiceImpl implements ReminderService{
	@Resource
	public ReminderMapper reminderDao;

	@Override
	public int insert(Reminder record) {
		return reminderDao.insert(record);
	}

	@Override
	public Reminder selectByDaid(Integer daid) {
		return reminderDao.selectByDaid(daid);
	}

	@Override
	public List<Reminder> findByDateRange(String mid, Date begin, Date end) {
		return reminderDao.findByDateRange(mid, begin, end);
	}

    @Override
    public Reminder findByMid(String mid) {
        return reminderDao.findByMid(mid);
    }

	@Override
	public int insertSelective(Reminder record) {
		return reminderDao.insertSelective(record);
	}

	@Override
	public List<Reminder> selectReminder() {
		return reminderDao.selectReminder();
	}

	@Override
	public int deleteByName(String remindname) {
		return reminderDao.deleteByName(remindname);
	}

	@Override
	public int updateByName(Reminder record) {
		return reminderDao.updateByName(record);
	}

	@Override
	public Reminder selectByName(String name) {
		return reminderDao.selectByName(name);
	}

	@Override
	public List<Reminder> selectByMid(String mid) {
		return reminderDao.selectByMid(mid);
	}



}
