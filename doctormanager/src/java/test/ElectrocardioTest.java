package test;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yunji.doctormanager.entity.Electrocardio;
import cn.yunji.doctormanager.service.ElectrocardioService;
import cn.yunji.doctormanager.service.impl.ElectrocardioServiceImpl;


public class ElectrocardioTest {
	private ElectrocardioService electrocardioService;
	@Before
	public void init() {
		String[] conf = { "conf/spring-mybatis.xml", "conf/spring-mvc.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		electrocardioService = ac.getBean("electrocardioService", ElectrocardioServiceImpl.class);
	}
	@Test
	public void queryAll() {
		try {
			Electrocardio e=electrocardioService.queryByMid("", null);
			System.out.println(e.getBpiclink());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
