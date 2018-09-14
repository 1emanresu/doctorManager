package cn.yunji.doctormanager.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSInput;

import cn.yunji.doctormanager.dao.DoctorAdviceMapper;
import cn.yunji.doctormanager.entity.DoctorAdvice;
import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.entity.PatientType;
import cn.yunji.doctormanager.entity.Reminder;
import cn.yunji.doctormanager.service.DoctorAdviceService;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.PatientTypeService;
import cn.yunji.doctormanager.service.ReminderService;
import cn.yunji.doctormanager.util.JsonResult;
import cn.yunji.doctormanager.util.RandomUtil;
import cn.yunji.doctormanager.util.SendSMS;

@Controller
@RequestMapping("/Reminder")
public class ReminderController {
	@Resource
	private ReminderService reminderService;
	@Resource
	private DoctorAdviceService doctorAdviceService;
	@Resource
	private GravidaInfoService gravidainfoService;
	@Resource
    private PatientTypeService patientTypeService;
	@RequestMapping("/insert.do")
	@ResponseBody
	/**
	 * @author luoyc
	 * @param reminder
	 * @param doctorAdvice
	 * @return
	 * 先插入医嘱，并将医嘱主键返回，再将daid插入到提醒信息表里最后发送短信。
	 */
	public int insertReminderForDoctorAdvice(Reminder reminder,DoctorAdvice doctorAdvice) {
		doctorAdviceService.insertDoctorAdvice(doctorAdvice);
		reminder.setDaid(doctorAdvice.getDaid());
		GravidaInfo gravidaInfo=new GravidaInfo();
		gravidaInfo.setMid(reminder.getMid());
		gravidaInfo.setProcessingState(1);
		gravidainfoService.updateProcessingState(gravidaInfo);
		//发送短信
//		String message="本次医嘱为："+doctorAdvice.getMyknowledge()+"你应该"+reminder.getSelftestdetails();
//		SendSMS.sendSms("18819488093",message);
		return reminderService.insert(reminder);
	}
	@RequestMapping("/insertReminder.do")
	@ResponseBody
	/**
	 * @author luoyc
	 * @param reminder
	 * @return
	 * 单单插入提醒信息
	 */
	public int insertReminderForRemind(Reminder reminder) {
		return reminderService.insert(reminder);
	}
	@RequestMapping("/insertSelective.do")
	@ResponseBody
	/**
	 * @author zhongjl
	 * @param reminder
	 * @return
	 * 插入信息，字段可以为空
	 */
	public int insertSelective(Reminder reminder){
		int n = reminderService.insertSelective(reminder);
		return n;
	}
	@RequestMapping("/insertReminder1.do")
	@ResponseBody
	/**
	 * @author luoyc
	 * @param reminder
	 * @return
	 * 插入转高危提醒，并把高危类型插入孕妇表
	 */
	public int insertReminderForRiskTypeChange(Reminder reminder) {
		String riskType=reminder.getMonitoringsuggestion();
		Integer patientTypeId=2;
		GravidaInfo gravidaInfo=new GravidaInfo();
		gravidaInfo.setMid(reminder.getMid());
		List<PatientType> patientTypeList=patientTypeService.findAll();
		for(PatientType patientType:patientTypeList){
		    if(riskType.equals(patientType.getPatienttypename())){
		        patientTypeId=patientType.getPatienttypeid();
		    }
		}
		gravidaInfo.setPatienttypeid(patientTypeId);
		gravidainfoService.updatePatientTypeId(gravidaInfo);
		return reminderService.insert(reminder);
	}
	@RequestMapping("/findReminderByDaid.do")
	@ResponseBody
	/**
	 * @author luoyc
	 * @param daid
	 * @return
	 * 根据daid查找对应的提醒
	 */
	public JsonResult findReminderByDaid(Integer daid) {
		return new JsonResult(reminderService.selectByDaid(daid));
	}
	/**
	 * 根据孕妇ID查询最近一次自测提醒内容
	 * @param mid
	 * @return
	 * @author luoyc
	 * @createDate 2017年10月27日 上午10:20:19
	 */
	@RequestMapping("/findByMid.do")
    @ResponseBody
	public JsonResult findReminderByMid(String mid) {
        return new JsonResult(reminderService.findByMid(mid));
    }
	/**
	 * 用于发送提醒模块
	 * @param mid
	 * @return
	 */
	@RequestMapping("/selectReminder.do")
    @ResponseBody
    public JsonResult selectReminder(){
		List<Reminder> remind = reminderService.selectReminder();
		return new JsonResult(remind);
	}
	@RequestMapping("/deleteByName.do")
	@ResponseBody
	public int deleteByName(String remindname){
		return reminderService.deleteByName(remindname);
	}
	/**
	 * 根据提醒名称更新
	 * @param record
	 * @return
	 */
	@RequestMapping("/updateByName.do")
	@ResponseBody
	public int updateByName(Reminder record){
		return reminderService.updateByName(record);
	}
	@RequestMapping("/selectByName.do")
	@ResponseBody
	public JsonResult selectByName(String remindname){
		Reminder remind = reminderService.selectByName(remindname);
		return new JsonResult(remind);
	}
	@RequestMapping("/selectByMid.do")
	@ResponseBody
	public JsonResult selectByMid(String mid){
		List<Reminder> remind = reminderService.selectByMid(mid);
		return new JsonResult(remind);
	}
}
