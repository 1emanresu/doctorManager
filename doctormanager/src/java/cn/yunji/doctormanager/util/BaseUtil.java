package cn.yunji.doctormanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseUtil {
	/**
     * 通过末次月经期  计算当前孕周    @yinzx
     * @param endDate
     * @return
     * @throws ParseException 
     */
  	public static String getWeeks(Date endDate) throws ParseException {
  		//当前日期
  		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
  		java.util.Date d1=new Date();
  		String dd =sdf.format(d1);
  		java.util.Date recordDate =sdf.parse(dd);
  		//System.out.println(recordDate);
  		Calendar calendar = Calendar.getInstance();
  		if(endDate!=null){
  		calendar.setTime(endDate);
  		}
  		int cnt = 0;//相差天数,怀孕天数
  		while(calendar.getTime().compareTo(recordDate)!=0){
  		      calendar.add(Calendar.DATE, 1);
  		      cnt++;
  		 }
  		//System.out.println(cnt);
  		//计算孕周
  		String weeks=(int)((cnt-1)/7)+"周";
  	    int days=(cnt-1)%7;
  	     if(days!=0){
  	    	weeks+="+"+days+"天";
  	     }
  		return weeks;
  	}
    /**
     * 通过末次月经期  计算指定日期时刻的孕周    @yinzx
     * @param endDate 末次月经期
     * @param buildDate 指定日期
     * @return
     * @throws ParseException 
     */
    public static int getWeeks(Date endDate,Date buildDate) throws ParseException {
        java.util.Date recordDate=null;
       
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d1=buildDate;
            String dd =sdf.format(d1);
            //System.out.println(dd);
        recordDate =sdf.parse(dd);
       
        
        //System.out.println(recordDate);
        Calendar calendar = Calendar.getInstance();
        if(endDate!=null){
        calendar.setTime(endDate);
        }
        int cnt = 0;//相差天数,怀孕天数
        while(calendar.getTime().compareTo(recordDate)!=0){
              calendar.add(Calendar.DATE, 1);
              cnt++;
         }
        //System.out.println(cnt);
        int weeks=(int)((cnt-1)/7);
        return weeks;
        
        
    }
    public static int getWeeks2(Date endDate) throws ParseException {
        java.util.Date recordDate=null;
       
        //当前日期
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d1=new Date();
            String dd =sdf.format(d1);
             recordDate =sdf.parse(dd);
       
        
        //System.out.println(recordDate);
        Calendar calendar = Calendar.getInstance();
        if(endDate!=null){
        calendar.setTime(endDate);
        }
        int cnt = 0;//相差天数,怀孕天数
        while(calendar.getTime().compareTo(recordDate)!=0){
              calendar.add(Calendar.DATE, 1);
              cnt++;
         }
        //System.out.println(cnt);
       
        //计算孕周
       int weeks=(int)((cnt-1)/7);
          return weeks;
       
        
    }
}
