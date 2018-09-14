package cn.yunji.doctormanager.service;

import java.util.List;
import cn.yunji.doctormanager.entity.SelfTestJudgment;

public interface SelfTestJudgmentService {
	/**
     * 根据qid查询所有医生对自测结果的判断结果
     * @author luoyc
     * @param qid
     * @return
     */
    List<SelfTestJudgment> selectByQid(Integer qid);
    int insert(SelfTestJudgment record);
}
