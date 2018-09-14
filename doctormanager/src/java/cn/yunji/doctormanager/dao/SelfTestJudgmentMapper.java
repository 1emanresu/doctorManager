package cn.yunji.doctormanager.dao;

import java.util.List;

import cn.yunji.doctormanager.entity.SelfTestJudgment;

public interface SelfTestJudgmentMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(SelfTestJudgment record);

    int insertSelective(SelfTestJudgment record);
    /**
     * 根据qid查询所有医生对自测结果的判断结果
     * @author luoyc
     * @param qid
     * @return
     */
    List<SelfTestJudgment> selectByQid(Integer qid);

    int updateByPrimaryKeySelective(SelfTestJudgment record);

    int updateByPrimaryKey(SelfTestJudgment record);
}