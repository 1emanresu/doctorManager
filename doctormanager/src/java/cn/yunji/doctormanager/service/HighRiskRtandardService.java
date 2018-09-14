package cn.yunji.doctormanager.service;

import java.math.BigDecimal;
import java.util.List;

import cn.yunji.doctormanager.entity.HighRiskRtandard;

public interface HighRiskRtandardService {
	public List<HighRiskRtandard> queryById(String hid,int cid);

	/**
	 * 高危标准查询,结果为当前明细所属范围。
	 * @param value	明细值
	 * @param hid	医院id
	 * @param cid	指标编号
	 * @param flag	true:查询低梯度范围；false:查询高梯度范围；
	 * @return
	 */
	public HighRiskRtandard queryHighRiskRtandard(Number value, String hid, int cid, boolean flag);
        List<HighRiskRtandard> findByCid(HighRiskRtandard record);
    public HighRiskRtandard getHisgRiskStandardbycid(int cid); 
}
