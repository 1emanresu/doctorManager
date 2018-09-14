/**
 * @Package cn.yunji.doctormanager.controller
 * @createDate 2017年12月11日 下午4:53:23 
 */
package cn.yunji.doctormanager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Doctorschedule;
import cn.yunji.doctormanager.service.DoctorService;
import cn.yunji.doctormanager.service.DoctorscheduleService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * @ClassName DoctorscheduleController.java
 * @Description: TODO(用一句话描述这个类的作用)
 * @author wangzw
 */
@Controller
@RequestMapping("/doctorschedule")
public class DoctorscheduleController {
	@Resource
	private DoctorscheduleService doctorscheduleService;
	@Resource
	private DoctorService doctorService;

	/**
	 * 查询全部医生本周的排班信息
	 * 
	 * @Description: TODO(用一句话描述该方法做什么)
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 * @author wangzw
	 */
	@ResponseBody
	@RequestMapping("/findAlldoctorschedule.do")
	public JsonResult findAlldoctorschedule(String beginDate,String endDate,Integer offid) {
		List<Map<String, Object>> doctorschedule = doctorscheduleService.findAlldoctorschedule(beginDate,endDate,offid);
		return new JsonResult(doctorschedule);
	}

	/**
	 * 添加医生排班
	 * 
	 * @Description: TODO(用一句话描述该方法做什么)
	 * @param record
	 * @return
	 * @author wangzw
	 * @throws ParseException
	 * @throws JSONException
	 */
	@ResponseBody
	@RequestMapping("/addAlldoctorschedule.do")
	public JsonResult insertSelective(String json) throws JSONException, ParseException {
		int ret = 0;
		JSONArray JsonArray = new JSONArray(json);
		for (int i = 0; i < JsonArray.length(); i++) {
			JSONObject job = JsonArray.getJSONObject(i);
			Object doctid = job.get("doctid");
			int did = Integer.parseInt((String) doctid);
			List<Map<String, Object>> doctor = doctorService.queryByDoctortId(did);
			String dname = (String) doctor.get(0).get("dName");
			JSONArray paiban = job.getJSONArray("paiban");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			for (int j = 0; j < paiban.length(); j++) {
				Doctorschedule record = new Doctorschedule();
				if (paiban.getString(j).length() > 12) {
					String[] strs = paiban.getString(j).split("~");
					String[] beginDate = strs[1].split("-");
					record.setDutybegintime(sdf.parse(beginDate[0]));
					record.setDutyendtime(sdf.parse(beginDate[1]));
					record.setDutyendtime(sdf.parse(beginDate[1]));
					record.setDutydate(sdf2.parse(strs[0]));
					record.setDoctorid(did);
					record.setDname(dname);
					ret = doctorscheduleService.insertSelective(record);
				} else {
					record.setDutydate(sdf2.parse(paiban.getString(j)));
					record.setDutyframe("休息");
					record.setDoctorid(did);
					record.setDname(dname);
					ret = doctorscheduleService.insertSelective(record);
				}

			}
		}
		return new JsonResult(ret);
	}
}
