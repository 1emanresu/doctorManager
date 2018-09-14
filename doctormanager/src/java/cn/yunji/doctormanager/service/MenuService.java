package cn.yunji.doctormanager.service;

import java.util.List;

import cn.yunji.doctormanager.entity.Menu;

/**
 * 菜单Service
 * @author zhengpl
 * @CreateDate 2017年12月13日 下午4:53:07
 */
public interface MenuService {

    /** 
     * 查询所有菜单
     * @return
     * @author zhengpl
     * @createDate 2017年12月13日 下午5:09:25
     */
    List<Menu> findAll();
}
