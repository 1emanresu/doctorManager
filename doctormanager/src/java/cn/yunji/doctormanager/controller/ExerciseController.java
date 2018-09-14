package cn.yunji.doctormanager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.yunji.doctormanager.entity.Exercise;
import cn.yunji.doctormanager.service.ExerciseService;
import cn.yunji.doctormanager.util.JsonResult;
/**
 * 运动
 * @author yinzx
 *
 */
@Controller
@RequestMapping("/exercise")
public class ExerciseController {
	@Resource
	private ExerciseService exerciseService;
	/**
	 * 查询运动：微量运动、中量运动
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping("/find.do")
	 public JsonResult find(){
	    Map<String, Object> map=new HashMap<>();
	    List<Exercise> microlist = exerciseService.findMicroSports();
	    List<Exercise> moderalist = exerciseService.findModerateSports();
	    if(microlist.size()>0){
	    	map.put("microlist", microlist);
	    }
	    if(moderalist.size()>0){
	    	map.put("moderalist", moderalist);
	    }
		return new JsonResult(map);
	 }

}
