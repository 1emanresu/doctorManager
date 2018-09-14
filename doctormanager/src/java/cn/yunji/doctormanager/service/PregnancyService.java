package cn.yunji.doctormanager.service;


import java.util.List;
import java.util.Map;

import cn.yunji.doctormanager.entity.Pregnancy;


public interface PregnancyService {
    //查询
	public Pregnancy findByPCid(Integer pcid);
	//增加
	public int addPregnancy(Pregnancy pregnancy);
	//更新
	public int update(Pregnancy pregnancy);
	
	public int updateByPcid(Integer pcid,Integer sibship,Integer familyhistory,Integer recentmarriage);
	/**
	 * 按mid查询信息
	 * @author yinzx
	 * @param mid
	 * @return
	 */
	public Pregnancy findByMid(String mid);
	/**
	 * 按mid更新信息
	 * @author yinzx
	 * @param mid
	 * @return
	 */
	public void updateByMid(Pregnancy pregnancy);
	/**
	 * 按条件查询
	 * @author zhangqt
	 * @return map
	 */
	public List<Map<String, Object>> findByCheck(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno,Integer pageIndex,Integer pageSize);
	
	public List<Map<String, Object>> findByNotCheck(Integer sage,Integer eage,Integer dreFoli,String medicalrecordno,Integer pageIndex,Integer pageSize);
	
	public int getDateCount1(Integer sage, Integer eage, Integer dreFoli, String medicalrecordno);
	
	public int getDateCount2(Integer sage, Integer eage, Integer dreFoli, String medicalrecordno);
	public int getDateCount3(Integer sage, Integer eage, Integer dreFoli, String medicalrecordno);
	List<Map<String, Object>> findByCheck2(Integer sage, Integer eage, Integer dreFoli, String medicalrecordno,
			
			Integer pageIndex, Integer pageSize);
}
