package cn.yunji.doctormanager.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.NursingEssentialsMapper;
import cn.yunji.doctormanager.entity.NursingEssentials;
import cn.yunji.doctormanager.service.NursingEssentialsService;


@Service("nursingEssentialsService")
public class NursingEssentialsServiceImpl implements NursingEssentialsService {
	@Resource
	private NursingEssentialsMapper nursingEssentialsDao;

    @Override
    public List<NursingEssentials> selectByPrimaryKeys(List<Integer> ids) {
        
        return nursingEssentialsDao.selectByPrimaryKeys(ids);
    }
}
