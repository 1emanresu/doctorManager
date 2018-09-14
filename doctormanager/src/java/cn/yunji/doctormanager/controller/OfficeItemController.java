/**
 * @Package cn.yunji.doctormanager.controller
 * @createDate 2017年12月11日 下午4:18:10 
 */
package cn.yunji.doctormanager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.OfficeItem;
import cn.yunji.doctormanager.service.OfficeItemService;
import cn.yunji.doctormanager.util.JsonResult;

/** 
 * @ClassName OfficeItemController.java
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author wangzw
 */

@Controller
@RequestMapping("/officeItem")
public class OfficeItemController {
    @Resource
    private OfficeItemService officeItemService;
    /**
     * 查询出所有的科室
     * @Description: TODO(用一句话描述该方法做什么) 
     * @return
     * @author wangzw
     */
    @ResponseBody
    @RequestMapping("/findItemOffice.do")
    public JsonResult findItemOffice(){
        List<OfficeItem> ret=null;
        try {
         ret=  officeItemService.findOffAll();
        } catch (Exception e) {
        }
        return new JsonResult(ret);
    }
}
