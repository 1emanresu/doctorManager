package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.KnowledgeMapper;
import cn.yunji.doctormanager.entity.Knowledge;
import cn.yunji.doctormanager.service.KnowledgeService;

@Service("knowledgeService")
public class KnowledgeServiceImpl implements KnowledgeService {
	@Resource
	private KnowledgeMapper knowledgeMapper;
	@Override
	public Knowledge queryById(int highRiskResultTypeId,int cid) {
		return knowledgeMapper.queryById(highRiskResultTypeId,cid);
	}

	@Override
	public Knowledge querybyhidcid(int hid, int cid) {
		// TODO Auto-generated method stub
		return knowledgeMapper.selectByHidandCid(hid, cid);
	}
	/**@methodName queryByListId
	 * @description: 查询知识库功能
	 * @param cid
	 * @return 
	 * @see cn.yunji.doctormanager.service.KnowledgeService#queryByListId(int)
	 */
	public List<Knowledge> queryByListId(int cid) {
		return knowledgeMapper.queryByListId(cid);
	}

	@Override
	public List<String> queryByKeyword(String keyword) {
		return knowledgeMapper.queryByKeyword(keyword);
	}
}
