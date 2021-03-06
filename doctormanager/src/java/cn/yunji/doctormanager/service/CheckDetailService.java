package cn.yunji.doctormanager.service;

import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.CheckDetail;

public interface CheckDetailService {
    /**
     * @author wangzw
     * @param mid孕妇 cid 按条件查询检查明细
     * @return CheckDetail
     */
    CheckDetail selectByCid(String mid,int cid);
    /**
     * @author wuwj
     * @param checkresultid 按检查接结果编号查询检查明细
     * @return List
     */
    List<Map<String, Object>> finddetailByCheckresultid(int checkresultid);
    /**
     * @author wuwj
     * @param cid 指标编号
     * @param mid 孕妇编号
     * @return List
     */
    List<Map<String, Object>> finddetailByCidandmid(int cid, String mid);
    /**
     * 根据cid和resultid查询具体指标信息
     * @author yinzx
     * @param cid
     * @param resultid
     * @return
     */
    Map<String, Object> findByCidandResultId(int cid, int resultid);
}
