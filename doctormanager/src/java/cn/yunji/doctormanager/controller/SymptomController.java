package cn.yunji.doctormanager.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Symptom;
import cn.yunji.doctormanager.service.SymptomService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 
 * @author wangzw
 * 症状控制器
 */
@Controller
@RequestMapping("/symptom")
public class SymptomController {
	@Resource
	private SymptomService symptomService;
	/**
	 * @author wangzw
	 * @param mid
	 * @return 全部异常
	 */
	@RequestMapping("/querySymptom.do") 
	@ResponseBody
	public JsonResult queryAbnormityinAll(String mid) {
		List<Map<String, Object>> symptom=symptomService.findSymptom(mid);
//		System.out.println(symptom);
		return new JsonResult(symptom); 
	}
	
	/**
	 * 录入症状数据
	 * @author zhengpl
	 * @param symptom
	 * @return
	 */
    @RequestMapping("/entering.do") 
    @ResponseBody
    public JsonResult entering(Symptom symptom) {
        symptomService.insert(symptom);
        return new JsonResult("");
    }

    /**
     * 查询所有症状
     * @author zhengpl
     * @return
     */
    @RequestMapping("/query.do") 
    @ResponseBody
    public JsonResult query() {
        //symptomService.insert(symptom);
        List<Symptom> list = symptomService.queryAll();
        return new JsonResult(list);
    }
    
    /**
     * 根据条件查询症状
     * @author zhengpl
     * @return
     */
    @RequestMapping(value="/queryByCondition.do") 
    @ResponseBody
    public JsonResult queryByCondition(String condition) {
        List<Symptom> list = symptomService.queryByCondition(condition);
        return new JsonResult(list);
    }
    
}
