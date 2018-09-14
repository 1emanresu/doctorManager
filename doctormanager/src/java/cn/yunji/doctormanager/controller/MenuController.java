package cn.yunji.doctormanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Menu;
import cn.yunji.doctormanager.service.MenuService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 菜单Controller
 * @author zhengpl
 * @CreateDate 2017年12月13日 下午5:09:04
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource
	private MenuService menuService;

    @ResponseBody
    @RequestMapping("/getMenuTree.do")
	public JsonResult getMenuTree() {
        List<Menu> menuList = menuService.findAll();
        List<Menu> tree = menuTree(0, menuList);
		return new JsonResult(tree);
	}
    
    private List<Menu> menuTree(Integer id, List<Menu> menuList) {
        List<Menu> list = new ArrayList<Menu>();
        for (int i = 0; i < menuList.size(); ++i) {
            Menu m = menuList.get(i);
            if (m.getParentId() == id) {
                m.setChildren(menuTree(m.getId(), menuList));
                list.add(m);
            }
        }
        return list;
    }
    

}
