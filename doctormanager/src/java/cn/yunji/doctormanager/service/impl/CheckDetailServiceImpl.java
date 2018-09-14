package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.CheckDetailMapper;
import cn.yunji.doctormanager.entity.CheckDetail;
import cn.yunji.doctormanager.service.CheckDetailService;
/**
 * 
 * @author wangzw
 * 检查明细
 */
@Service("checkDetailService")
public class CheckDetailServiceImpl implements CheckDetailService{
	@Resource
	private CheckDetailMapper checkDetailMapper;
	@Override
	public CheckDetail selectByCid(String mid,int cid) {
		return checkDetailMapper.selectByCid(mid,cid);
	}
	@Override
	public List<Map<String, Object>> finddetailByCheckresultid(int checkresultid) {
		// TODO Auto-generated method stub
		return checkDetailMapper.finddetailByCheckresultid(checkresultid);
	}
	@Override
	public List<Map<String, Object>> finddetailByCidandmid(int cid, String mid) {
		// TODO Auto-generated method stub
		return checkDetailMapper.finddetailByCidandmid(cid, mid);
	}
    @Override
    public Map<String, Object> findByCidandResultId(int cid, int resultid) {
        // TODO Auto-generated method stub
        return checkDetailMapper.findByCidandResultId(cid,resultid);
    }
}
