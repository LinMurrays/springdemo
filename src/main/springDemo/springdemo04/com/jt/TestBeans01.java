package springdemo04.com.jt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo04.com.jt.common.config.AppConfig;
import springdemo04.com.jt.common.utils.OpenDataSource;
import springdemo04.com.jt.sys.dao.SysConfigDao;

public class TestBeans01 {
	private AnnotationConfigApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}
	
	
	@Test
	public void testOpenDataSource(){
	OpenDataSource data = ctx.getBean("dataSourceDemo",OpenDataSource.class);
		System.out.println(data);
	}
	
	@After
	public void destory(){
		ctx.close();
	}
	
	@Test
	public void testSysConfigDao(){
		//必须是小写字母开头
		SysConfigDao dao= ctx.getBean("sysConfigDaoImpl",SysConfigDao.class);
		System.out.println(dao);
	}
}
