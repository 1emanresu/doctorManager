package cn.yunji.doctormanager.service;

import java.util.List;
import cn.yunji.doctormanager.entity.PatientType;

public interface PatientTypeService {
    /**
     * 查询所有的病人类型
     * @return
     * @author luoyc
     * @createDate 2017年10月27日 上午9:33:54
     */
    List<PatientType> findAll();
}
