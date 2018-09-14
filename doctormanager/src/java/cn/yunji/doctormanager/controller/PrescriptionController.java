package cn.yunji.doctormanager.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.Prescription;
import cn.yunji.doctormanager.entity.Temperature;
import cn.yunji.doctormanager.service.PrescriptionService;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {
	@Resource
	public PrescriptionService prescriptionService;
	Long SEVEN_DAY=7*24*60*60*1000L;
    Date end =new Date();
    Date begin=new Date(end.getTime()-SEVEN_DAY);
    
	@ResponseBody
	@RequestMapping("/queryByMid.do")
	public JsonResult queryByMid(String mid) {
		List<Prescription> prescription = prescriptionService.queryByMid(mid);
		return new JsonResult(prescription);
	}
	/**
	 * 查询日期往后一周指定孕妇的用药记录
	 * @author luoyc
	 * @param mid
	 * @return
	 */
	@RequestMapping("/findByDateRange.do")
    @ResponseBody
    public JsonResult findByDateRange(String mid,Date end){
	    Date begin=new Date(end.getTime()-SEVEN_DAY);
        List<Prescription> list=prescriptionService.findByDateRange(mid, begin, end);
        return new JsonResult(list);    
    }
    /**
     * 根据mid和处方日期查出对应孕妇的用药记录
     * @param mid
     * @param predate
     * @return
     */
	@RequestMapping("/selectByPredate.do")
	@ResponseBody
	public JsonResult selectByPredate(String mid,@DateTimeFormat(pattern="yyyy-MM-dd") Date predate){
		List<Prescription> prescription = prescriptionService.selectByPredate(mid, predate);
		return new JsonResult(prescription);
	}
}
