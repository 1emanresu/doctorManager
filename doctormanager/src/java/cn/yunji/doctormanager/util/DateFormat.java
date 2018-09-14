package cn.yunji.doctormanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String yMd(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
}
