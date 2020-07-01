package springdemo01.testdemo1;

import springdemo01.beans.HelloService;
import springdemo01.beans.ObjectFactory;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class TestBeans01 extends TestBase {

    @Test
    public void testHello() {
        HelloService helloservice = (HelloService) ctx.getBean("helloService");
        System.out.println("hello");

    }

    @Test
    public void testCalendar() {
        Calendar c1 = ctx.getBean(Calendar.class);
        System.out.println(c1);
        System.out.println(c1.getClass().getName());
    }

    @Test
    public void testDate() {
        Date c1 = ctx.getBean("date", Date.class);
        System.out.println(c1);
        System.out.println(c1.getClass().getName());
    }

    @Test
    public void testObjectFactory() {
        ObjectFactory oFactory = ctx.getBean("objectFactory", ObjectFactory.class);
        System.out.println(oFactory);
        //当我们调用getBean方法时，底层会检测key对应bean是否为FactoryBean类型
        //假如是FactoryBean类型则会直接调用Bean对象的getObject方法获取bean的实例
        ObjectFactory oFactory2 = ctx.getBean("objectFactory", ObjectFactory.class);
        System.out.println(oFactory == oFactory2);

    }
}
