package cn.yunji.doctormanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yunji.doctormanager.entity.Knowledge;

public interface KnowledgeService {
	public Knowledge queryById(int highRiskResultTypeId,int cid);

	Knowledge querybyhidcid(int hid, int cid);
	/**
	 * 查询知识库
	 */
	List<Knowledge> queryByListId(int cid);
	 /**
     * 根据关键字模糊查询相关医嘱
     * @author luoyc
     * @param keyword
     * @return
     */
    List<String> queryByKeyword(String keyword);
}
