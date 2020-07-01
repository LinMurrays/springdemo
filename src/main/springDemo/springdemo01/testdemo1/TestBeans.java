package springdemo01.testdemo1;

import springdemo01.beans.OpenDataSource;
import org.junit.Test;

public class TestBeans extends TestBase {
    @Test
    public void testDataSource01() {
        //有id根据id找，不然根据类名找,去实现了FactoryBean接口的类执行getObjectType方法判断是否属于需要的类型
        //不符合则会创建对象
        //OpenDataSource ds1 = ctx.getBean(OpenDataSource.class);
        OpenDataSource ds2 = ctx.getBean("dataSource", OpenDataSource.class);
        //System.out.println(ds1==ds2);
        OpenDataSource ds3 = ctx.getBean("dataSource", OpenDataSource.class);
        System.out.println(ds2 == ds3);

        OpenDataSource ds4 = ctx.getBean("dataSource", OpenDataSource.class);
        System.out.println(ds4 == ds3);

    }
}

