package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.BloodfatMapper;
import cn.yunji.doctormanager.dao.SelfTestJudgmentMapper;
import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.SelfTestJudgment;
import cn.yunji.doctormanager.service.BloodfatService;
import cn.yunji.doctormanager.service.SelfTestJudgmentService;


@Service("selfTestJudgment")
public class SelfTestJudgmentServiceImpl implements SelfTestJudgmentService {
	@Resource
	private SelfTestJudgmentMapper selfTestJudgmentDao;

	@Override
	public List<SelfTestJudgment> selectByQid(Integer qid) {
		return selfTestJudgmentDao.selectByQid(qid);
	}

	@Override
	public int insert(SelfTestJudgment record) {
		return selfTestJudgmentDao.insert(record);
	}


}
