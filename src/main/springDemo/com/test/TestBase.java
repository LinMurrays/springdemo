package com.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	protected ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		//初始化spring中的IOC容器
		ctx=new ClassPathXmlApplicationContext("spring-configs.xml");
	}

	@After
	public void destory(){
		//释放容器中的资源
		ctx.close();
	}
}
