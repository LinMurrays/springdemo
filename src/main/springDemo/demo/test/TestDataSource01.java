package demo.test;


import com.alibaba.druid.pool.DruidDataSource;
import springdemo01.utils.OpenDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

public class TestDataSource01 extends TestBase {

    @Test
    public void test1() {
        OpenDataSource ods = ctx.getBean("openDataSource01", OpenDataSource.class);
        System.out.println(ods);
        System.out.println();
    }

    @Test
    public void test2() {
        OpenDataSource ods = ctx.getBean("openDataSource02", OpenDataSource.class);
        System.out.println(ods);

    }

    @Test//c3p0连接池
    public void test4() {
        ComboPooledDataSource cpds = ctx.getBean("c3p0DataSource", ComboPooledDataSource.class);
        System.out.println(cpds);
    }

    @Test//druid连接池
    public void test5() throws Exception {
        DruidDataSource dds = ctx.getBean("druidDataSource", DruidDataSource.class);
        System.out.println(dds.getConnection());

    }
}
