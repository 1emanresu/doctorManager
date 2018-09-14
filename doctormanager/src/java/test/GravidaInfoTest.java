package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yunji.doctormanager.entity.GravidaInfo;
import cn.yunji.doctormanager.service.GravidaInfoService;
import cn.yunji.doctormanager.service.impl.GravidaInfoServiceImpl;

public class GravidaInfoTest {
	private GravidaInfoService gravidaInfoService;
	@Before
	public void init() {
		String[] conf = { "conf/spring-mybatis.xml", "conf/spring-mvc.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		gravidaInfoService = ac.getBean("gravidaInfoService", GravidaInfoServiceImpl.class);
	}
	@Test
	public void queryAll() {
		try {
			GravidaInfo gravidainfo = gravidaInfoService.find("dg000001");
			System.out.println(gravidainfo);
			/*for (GravidaInfo gravidaInfo : list) {
				System.out.println("孕妇："+gravidaInfo.getGname());
			}*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void main(String[] args) throws ParseException {
//		Timer timer = new Timer();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//		String time = sdf2.format(System.currentTimeMillis());//当前时间的年月日
//		Date date = sdf.parse(time + " 14:28:50");
//		
//		TimerTask task = new TimerTask() {
//			
//			@Override
//			public void run() {
//				System.out.println("321321");
//			}
//		};
//		timer.schedule(task,date);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = time.format(System.currentTimeMillis());
		System.out.println(now);
	}
	
}
