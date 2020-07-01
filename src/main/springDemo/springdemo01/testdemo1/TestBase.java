package springdemo01.testdemo1;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
    protected ClassPathXmlApplicationContext ctx;
    protected ClassPathXmlApplicationContext ctx2;

    @Before
    public void init() {
        //初始化spring中的IOC容器
        ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
        ctx2 = new ClassPathXmlApplicationContext("spring-configs.xml");
    }

    @After
    public void destory() {
        //释放容器中的资源
        ctx.close();
    }
}
