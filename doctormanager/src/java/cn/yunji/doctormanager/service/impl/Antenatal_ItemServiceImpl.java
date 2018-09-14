package cn.yunji.doctormanager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.Antenatal_ItemMapper;
import cn.yunji.doctormanager.entity.Antenatal_Item;
import cn.yunji.doctormanager.service.Antenatal_ItemService;
@Service("antenatal_itemservice")
public class Antenatal_ItemServiceImpl implements Antenatal_ItemService {
	@Resource
	private Antenatal_ItemMapper antenatal_itemmapper;
	
	@Override
	public List<Map<String, Object>> findallcheckprojectbyweeks(int weeks) {
		return antenatal_itemmapper.findallcheckprojectbyweeks(weeks);
	}

	@Override
	public List<Map<String, Object>> findcheckedprojectbyweeks(int weeks, String mid, String doctorId,
			String hospitalId) {
		return antenatal_itemmapper.findcheckedprojectbyweeks(weeks, mid, doctorId, hospitalId);
	}

	@Override
	public Antenatal_Item findbeginandendweeks(int weeks) {
		return antenatal_itemmapper.findbeginandendweeks(weeks);
	}

    @Override
    public List<Map<String, Object>> queryByWeeks(Integer week) {
        return antenatal_itemmapper.queryByWeeks(week);
    }

}
