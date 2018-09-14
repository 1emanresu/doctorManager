package cn.yunji.doctormanager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.NeteasyImMapper;
import cn.yunji.doctormanager.entity.NeteasyIm;
import cn.yunji.doctormanager.service.NeteasyImService;

/**
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author yinzx
 * @CreateDate 2017年11月24日 上午9:35:55
 */
@Service("NeteasyImService")
public class NeteasyImServiceImpl implements NeteasyImService{


    @Resource
    private NeteasyImMapper  NeteasyImMapper;
    @Override
    public NeteasyIm findByUserid(Integer userid) {
        // TODO Auto-generated method stub
        return NeteasyImMapper.findByUserid(userid);
    }
    @Override
    public NeteasyIm findIMByMid(String mid) {
        // TODO Auto-generated method stub
        return NeteasyImMapper.findIMByMid(mid);
    }
	@Override
	public int insertSelective(NeteasyIm record) {
		// TODO Auto-generated method stub
		return NeteasyImMapper.insertSelective(record);
	}

}
