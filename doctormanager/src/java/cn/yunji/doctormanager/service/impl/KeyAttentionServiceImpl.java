package cn.yunji.doctormanager.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.BloodfatMapper;
import cn.yunji.doctormanager.dao.KeyAttentionMapper;
import cn.yunji.doctormanager.entity.Bloodfat;
import cn.yunji.doctormanager.entity.KeyAttention;
import cn.yunji.doctormanager.service.BloodfatService;
import cn.yunji.doctormanager.service.KeyAttentionService;


@Service("keyAttentionService")
public class KeyAttentionServiceImpl implements KeyAttentionService {
	@Resource
	private KeyAttentionMapper keyAttentionDao;

    @Override
    public KeyAttention selectByPrimaryKey(Integer kid) {

        return keyAttentionDao.selectByPrimaryKey(kid);
    }

    @Override
    public List<KeyAttention> selectByPrimaryKeys(List<Integer> ids) {
        return keyAttentionDao.selectByPrimaryKeys(ids);
    }

}
