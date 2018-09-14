package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.MenuMapper;
import cn.yunji.doctormanager.entity.Menu;
import cn.yunji.doctormanager.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Resource
	public MenuMapper menuDao;

    @Override
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

}
