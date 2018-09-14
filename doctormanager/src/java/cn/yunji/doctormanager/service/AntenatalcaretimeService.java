package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.Antenatalcaretime;
/**
 * 
 * @author wangzw
 * 产检次数
 */
public interface AntenatalcaretimeService {
    /**
     * @author wangzw
     * @param mid
     * @return 查询产检的次数
     */
    List<Antenatalcaretime> queryAntenatalcaretime(String mid);
    /**
     * @author wuwj
     * @param date
     * @param mid
     * @return 查询第一次产检附加检查项目
     */
    Antenatalcaretime findfirstExtendCheckprojectId(String date, String mid);
    /**
     * @author wuwj
     * @param date
     * @param mid
     * @return 查询第二次产检附加检查项目
     */
    Antenatalcaretime findsecondExtendCheckprojectId(String date, String mid);
    /**
     * @author wuwj
     * @param date
     * @param mid
     * @return 查询第三次产检附加检查项目
     */
    Antenatalcaretime findthirdExtendCheckprojectId(String date, String mid);
    /**
     * @author wuwj
     * @param date
     * @param mid
     * @return 查询第四次产检附加检查项目
     */
    Antenatalcaretime findfourthExtendCheckprojectId(String date, String mid);
    /**
     * @author wuwj
     * @param date
     * @param mid
     * @return 查询第五次产检附加检查项目
     */
    Antenatalcaretime findfifthExtendCheckprojectId(String date, String mid);
    /**
     * @author wuwj
     * @param date
     * @param mid
     * @return 查询第六次产检附加检查项目
     */
    Antenatalcaretime findsixthExtendCheckprojectId(String date, String mid);
    /**
     * @author wuwj
     * @param date
     * @param mid
     * @return 查询第七次产检附加检查项目
     */
    Antenatalcaretime findsevenExtendCheckprojectId(String date, String mid);
}
