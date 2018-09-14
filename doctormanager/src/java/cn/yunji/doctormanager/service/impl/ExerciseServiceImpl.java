package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.ExerciseMapper;
import cn.yunji.doctormanager.entity.Exercise;
import cn.yunji.doctormanager.service.ExerciseService;
@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService{

	@Resource
	private ExerciseMapper ExerciseDAO;
	@Override
	public List<Exercise> findMicroSports() {

		return ExerciseDAO.findMicroSports();
	}

	@Override
	public List<Exercise> findModerateSports() {

		return ExerciseDAO.findModerateSports();
	}

    @Override
    public List<Exercise> selectByPrimaryKeys(List<Integer> ids) {

        return ExerciseDAO.selectByPrimaryKeys(ids);
    }

}
