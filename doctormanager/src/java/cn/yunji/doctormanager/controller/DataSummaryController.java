package cn.yunji.doctormanager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.service.VipOrderService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 用于数据汇总，百分率
 * 
 * @author zhangqt
 * @CreateDate 2017年11月21日 下午3:41:22
 */
@Controller
@RequestMapping("/dataSummary")
public class DataSummaryController {
	@Resource
	private VipOrderService vipOrderService;

	/**
	 * 查询开通医嘱问诊与开通周报的人数
	 * 
	 * @return weekly 代表周报人数
	 * @return inquiry 代表医嘱问诊人数
	 * @author zhangqt
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@RequestMapping("/queryServiceTypeNum.do")
	@ResponseBody
	public JsonResult queryServiceTypeNum() {
		Map<String, Object> nums = new HashMap<String, Object>();
		List<Map<String, Object>> is = vipOrderService.queryServiceTypeNum();
		for (Map<String, Object> map : is) {
			if (Integer.parseInt(String.valueOf(map.get("vipid"))) == 100) {// 周报
				nums.put("weekly", map.get("count"));
			} else if (Integer.parseInt(String.valueOf(map.get("vipid"))) == 101) {// 医嘱问诊
				nums.put("inquiry", map.get("count"));
			}
		}
		return new JsonResult(nums);
	}

	/**
	 * 查询周报已处理与未处理人数
	 * 
	 * @return in 代表周报已处理
	 * @return not 代表周报未处理
	 * @author zhangqt
	 * @throws ParseException
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@RequestMapping("/queryWeeklyHandleNum.do")
	@ResponseBody
	public JsonResult queryWeeklyHandleNum() throws ParseException {
		Map<String, Object> nums = new HashMap<String, Object>();
		SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(cal.DAY_OF_WEEK, cal.MONDAY);
		cal.set(Calendar.DATE, cal.get(cal.DATE) + 6);
		String weeklast = simdf.format(cal.getTime());// 当前星期的周日
		List<Map<String, Object>> i = vipOrderService.queryWeeklyHandleNum(weeklast, 100);
		int num1 = 0;
		int num2 = 0;
		for (Map<String, Object> map : i) {
			if (Integer.parseInt(String.valueOf(map.get("processingState"))) == 0) {
				num1++;
			} else if (Integer.parseInt(String.valueOf(map.get("processingState"))) == 1) {
				num2++;
			}
		}
		nums.put("not", num1);
		nums.put("ins", num2);
		return new JsonResult(nums);
	}
	/**
	 * 查询医嘱已处理与未处理人数
	 * 
	 * @return in 代表医嘱已处理
	 * @return not 代表医嘱未处理
	 * @author zhangqt
	 * @throws ParseException
	 * @createDate 2017年10月13日 下午4:48:50
	 */
	@RequestMapping("/queryAdviceHandleNum.do")
	@ResponseBody
	public JsonResult queryAdviceHandleNum() throws ParseException {
		Map<String, Object> nums = new HashMap<String, Object>();
		//获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
		List<Map<String, Object>> i = vipOrderService.queryWeeklyHandleNum(last, 101);
		int num1 = 0;
		int num2 = 0;
		for (Map<String, Object> map : i) {
			if (Integer.parseInt(String.valueOf(map.get("processingState"))) == 0) {
				num1++;
			} else if (Integer.parseInt(String.valueOf(map.get("processingState"))) == 1) {
				num2++;
			}
		}
		nums.put("not", num1);
		nums.put("ins", num2);
		return new JsonResult(nums);
	}
}
