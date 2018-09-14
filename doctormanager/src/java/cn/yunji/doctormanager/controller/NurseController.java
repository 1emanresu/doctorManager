package cn.yunji.doctormanager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Abnormityinfo;
import cn.yunji.doctormanager.service.NurseService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 
 * @author Wangzw
 * 护士
 */
@Controller
@RequestMapping("/nurse")
public class NurseController {
	@Resource
	private NurseService nurseService;
 	/**
	 * @author Wangzw
	 * @param nid
	 * @return 
	 * @throws ParseException
	 * 以护士id 查询护士的信息
	 */
    @RequestMapping("/queryBynurseId.do")
	@ResponseBody
	public JsonResult queryByMid(int nid) throws ParseException {
		List<Map<String, Object>> nurseList=nurseService.queryByNurseId(nid);
		return new JsonResult(nurseList);
	}

    

    
    
    
}
