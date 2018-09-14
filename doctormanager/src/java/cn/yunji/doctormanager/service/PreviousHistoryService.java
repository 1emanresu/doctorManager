package cn.yunji.doctormanager.service;

public interface PreviousHistoryService {
/**
 * 按mid查询既往史，返回具体既往史内容
 * @author yinzx
 * @param mid
 * @return
 */
    String findByMid(String mid);
}
