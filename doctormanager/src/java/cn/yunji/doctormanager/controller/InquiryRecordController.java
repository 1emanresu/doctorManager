package cn.yunji.doctormanager.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.apache.commons.fileupload.UploadContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.yunji.doctormanager.controller.exception.ServiceException;
import cn.yunji.doctormanager.entity.DoctorAdvice;
import cn.yunji.doctormanager.entity.InquiryRecord;
import cn.yunji.doctormanager.entity.SelfTestJudgment;
import cn.yunji.doctormanager.entity.Weeklyreport;
import cn.yunji.doctormanager.service.DoctorAdviceService;
import cn.yunji.doctormanager.service.InquiryRecordService;
import cn.yunji.doctormanager.service.RemoteReservationService;
import cn.yunji.doctormanager.service.SelfTestJudgmentService;
import cn.yunji.doctormanager.util.JsonResult;
import cn.yunji.doctormanager.util.MultipartFileUtil;


@Controller
@RequestMapping("/inquiryRecord")
public class InquiryRecordController {

	@Resource
	private InquiryRecordService inquiryRecordService;
	@Resource
	private SelfTestJudgmentService selfTestJudgmentService;
	@Resource
	private DoctorAdviceService doctorAdviceService;
	@Resource
	private RemoteReservationService remoteReservationServiceImpl;
	/**
	 * 插入医嘱记录
	 * @author luoyc
	 * @param inquiryRecord
	 * @param jugementStrList
	 * @return
	 */
	@RequestMapping("/insert.do")
	@ResponseBody
	public JsonResult insert(InquiryRecord inquiryRecord,String jugementStrList){
		inquiryRecordService.insert(inquiryRecord);
		if(jugementStrList!=null){
		    String[] jugement=jugementStrList.split(",");
	        SelfTestJudgment selfTestJudgment=new SelfTestJudgment();
	        selfTestJudgment.setQid(inquiryRecord.getQid());
	        for(int i=0;i<jugement.length;i++){
	            if(i%3==0){
	                selfTestJudgment.setSname(jugement[i]);
	            }else if(i%3==1){
	                selfTestJudgment.setJudgment(jugement[i]);
	            }else if(i%3==2){
	                selfTestJudgment.setIllustration(jugement[i]);
	                selfTestJudgmentService.insert(selfTestJudgment);
	            }
	            if(i==jugement.length-1&&jugement.length%3!=0){
	                selfTestJudgment.setIllustration("");
	                selfTestJudgmentService.insert(selfTestJudgment);
	            }
	        } 
		}
		
		DoctorAdvice doctorAdvice=new DoctorAdvice();
		doctorAdvice.setMid(inquiryRecord.getMid());
		doctorAdvice.setDoctorid(inquiryRecord.getDoctorid());
		doctorAdvice.setAdvicedate(inquiryRecord.getQdate());
		doctorAdvice.setMyknowledge(inquiryRecord.getDoctoradvice());
		doctorAdviceService.insertDoctorAdvice(doctorAdvice);
		return new JsonResult(0);	
	}
	
	/**
	 * 
	 * 数据从app来带有视频的请求
	 * @param uploadFile
	 * @param inquiryRecord
	 * @param jugementStrList
	 * @return
	 * @author oumh
	 * @createDate 2018年1月25日 下午4:15:26
	 */
	@RequestMapping("insertInquiryRecord.do")
	@ResponseBody
	public JsonResult insertInquiryRecord(MultipartFile uploadFile,InquiryRecord inquiryRecord,String jugementStrList){
	    if(uploadFile!=null&&uploadFile.getSize()>0){
	        String inquiryVideo = 
	                MultipartFileUtil.multipartFileTransferToLocal(uploadFile, "E:\\InquiryVideo/");
	        inquiryRecord.setInquiryVideo(inquiryVideo); 
	    }
	    System.out.println(inquiryRecord);
		inquiryRecordService.insert(inquiryRecord);
		if(jugementStrList!=null){
		    String[] jugement=jugementStrList.split(",");
	        SelfTestJudgment selfTestJudgment=new SelfTestJudgment();
	        selfTestJudgment.setQid(inquiryRecord.getQid());
	        for(int i=0;i<jugement.length;i++){
	            if(i%3==0){
	                selfTestJudgment.setSname(jugement[i]);
	            }else if(i%3==1){
	                selfTestJudgment.setJudgment(jugement[i]);
	            }else if(i%3==2){
	                selfTestJudgment.setIllustration(jugement[i]);
	                selfTestJudgmentService.insert(selfTestJudgment);
	            }
	            if(i==jugement.length-1&&jugement.length%3!=0){
	                selfTestJudgment.setIllustration("");
	                selfTestJudgmentService.insert(selfTestJudgment);
	            }
	        } 
		}
		
		DoctorAdvice doctorAdvice=new DoctorAdvice();
		doctorAdvice.setMid(inquiryRecord.getMid());
		doctorAdvice.setDoctorid(inquiryRecord.getDoctorid());
		doctorAdvice.setAdvicedate(inquiryRecord.getQdate());
		doctorAdvice.setMyknowledge(inquiryRecord.getDoctoradvice());
		doctorAdviceService.insertDoctorAdvice(doctorAdvice);
		return new JsonResult(0);
	}
	
	/**
	 * 查询出当月所有记录
	 * @author luoyc
	 * @param mid
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/findMonthlyAllRecord.do")
	@ResponseBody
	public JsonResult findAllRecord(String mid) throws ParseException{
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Calendar now =Calendar.getInstance();
		int month=now.get(2)+1;
		String mon=month+"";
		if(month<10){
			mon="0"+mon;
		}
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=now.get(1)+"-"+mon+"-"+"01";
		Date start=sdf.parse(dateStr);
		Date end=now.getTime();
		List<InquiryRecord> inquiryRecordList=inquiryRecordService.findByDateRange(mid, start, end);
		List<Date> dateList=new ArrayList();
		for(InquiryRecord inquiryRecord:inquiryRecordList){
			dateList.add(inquiryRecord.getQdate());
		}
		//删除重复日期
		for(int i=0;i<dateList.size()-1;i++){ 
		    for(int j=dateList.size()-1;j>i;j--){ 
		      if(dateList.get(j).equals(dateList.get(i))){ 
		    	  dateList.remove(j); 
		      } 
		    } 
		}
		return new JsonResult(dateList);	
	}
	@RequestMapping("/findRecordByDate.do")
	@ResponseBody
	public JsonResult findRecordByDate(String mid,Integer day) throws ParseException{
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Calendar now =Calendar.getInstance();
		int month=now.get(2)+1;
		String mon=month+"";
		if(month<10){
			mon="0"+mon;
		}
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=now.get(1)+"-"+mon+"-"+day;
		Date qdate=sdf.parse(dateStr);
		InquiryRecord ir=new InquiryRecord();
		ir.setMid(mid);
		ir.setQdate(qdate);
		List<InquiryRecord> inquiryRecordList=inquiryRecordService.findByDate(ir);
		List<Date> dateList=new ArrayList();
		ir=inquiryRecordList.get(inquiryRecordList.size()-1);
		return new JsonResult(ir);	
	}
	@RequestMapping("/findByMid.do")
	@ResponseBody
	public Map findByMid(String mid,String keyword,String sdate,String edate, Integer pageIndex,Integer pageSize){
		List<InquiryRecord> list=inquiryRecordService.findByMid(mid,keyword,sdate,edate,pageIndex,pageSize);
		Map map=new HashMap();
		map.put("total", 10);
		map.put("rows", list);
		return map;
	}
	@RequestMapping("/findByQid.do")
    @ResponseBody
    public InquiryRecord findByQid(Integer qid){
        InquiryRecord list=inquiryRecordService.findByQid(qid);
        return list;
    }
	
	@RequestMapping("/selectByMid.do")
    @ResponseBody
	public JsonResult selectByMid(String mid){
		List<InquiryRecord> list = inquiryRecordService.selectByMid(mid);
		return new JsonResult(list);
	}
	/**
	 * 根据mid查询所有问诊报告记录
	 * @Description: TODO(用一句话描述该方法做什么) 
	 * @author yinzx
	 * @createDate 2018年1月17日 下午3:05:42
	 * @param mid
	 * @return
	 */
	@RequestMapping("/findAllByMid.do")
    @ResponseBody
    public JsonResult findAllByMid(String mid){
        List<Map<String,Object>> list = inquiryRecordService.findAllByMid(mid);
        return new JsonResult(list);
    }
}