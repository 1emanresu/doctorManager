package cn.yunji.doctormanager.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.PsychologyEssentialsMapper;
import cn.yunji.doctormanager.entity.PsychologyEssentials;
import cn.yunji.doctormanager.service.PsychologyEssentialsService;


@Service("psychologyEssentialsService")
public class PsychologyEssentialsServiceImpl implements PsychologyEssentialsService {
	@Resource
	private PsychologyEssentialsMapper psychologyEssentialsDao;

    @Override
    public List<PsychologyEssentials> selectByPrimaryKeys(List<Integer> ids) {
        return psychologyEssentialsDao.selectByPrimaryKeys(ids);
    }



}
