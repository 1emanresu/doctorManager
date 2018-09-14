package cn.yunji.doctormanager.dao;

import cn.yunji.doctormanager.entity.WeeklyNursing;

public interface WeeklyNursingMapper {
    int deleteByPrimaryKey(Integer wid);

    int insert(WeeklyNursing record);

    int insertSelective(WeeklyNursing record);

    WeeklyNursing selectByPrimaryKey(Integer wid);

    int updateByPrimaryKeySelective(WeeklyNursing record);

    int updateByPrimaryKey(WeeklyNursing record);
    /**
     * 根据孕周查询相应数据
     * @author luoyc
     * @param week
     * @return
     */
    WeeklyNursing findByWeek(Integer week);
}