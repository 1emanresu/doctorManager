package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.RelationMapper;
import cn.yunji.doctormanager.entity.Relation;
import cn.yunji.doctormanager.service.RelationService;
@Service("relationService")
public class RelationServiceImpl implements RelationService {
	@Resource
	private RelationMapper relationMapper;

	@Override
	public List<Relation> find() {
		return relationMapper.find();
	}

}
