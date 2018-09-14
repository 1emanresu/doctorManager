package cn.yunji.doctormanager.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.FamilyMember;
import cn.yunji.doctormanager.service.FamilyMemberService;
import cn.yunji.doctormanager.service.GravidaFirstCheckService;
import cn.yunji.doctormanager.service.PreviousHistoryService;
import cn.yunji.doctormanager.util.BaseUtil;
import cn.yunji.doctormanager.util.JsonResult;

@Controller
@RequestMapping("/gravidaFirstCheck")
public class GravidaFirstCheckController {

    @Resource
    private GravidaFirstCheckService gravidaFirstCheckService;
    @Resource
    private PreviousHistoryService pService;
    @Resource
    private FamilyMemberService fService;
    
    @RequestMapping("/findByMid.do")
    @ResponseBody
    public JsonResult findByMid(String mid) throws ParseException{
        Map<String, Object> map = gravidaFirstCheckService.findByMid(mid);
        //既往史
        if(map==null){
        	map=new HashMap<String,Object>();
        }
        map.put("previous", pService.findByMid(mid));
        Date enddate=(Date) map.get("endDate");
        Date checkDate=(Date) map.get("checkDate");
        int weeks=0;
        if(checkDate!=null){
        	weeks= BaseUtil.getWeeks(enddate, checkDate);
        }
        map.put("weeks", weeks);
       List<FamilyMember> list = fService.findAllByMid(mid);
       
       map.put("flist", list);
        return new JsonResult(map);
    }
}
