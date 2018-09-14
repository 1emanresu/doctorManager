package cn.yunji.doctormanager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Checkindex;
import cn.yunji.doctormanager.service.CheckindexService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("checkindex")
public class CheckindexController {
	@Resource
	private CheckindexService checkindexService;
	
	/**
	 * 根据项目编号获取该项目所有参考范围值
	 * @param cpid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getIndexList")
	public List<Checkindex> getIndexList(int cpid) {
		return checkindexService.queryByProjectId(cpid);
	}
	
	/**
	 * 根据检查项目ID查询检查指标
	 * @param pid 检查项目ID
	 * @return
	 */
    @RequestMapping("/queryByProjectId.do")
    @ResponseBody
    public JsonResult queryByProjectId(int pid){
        return new JsonResult(checkindexService.queryByProjectId(pid));
    }
}
