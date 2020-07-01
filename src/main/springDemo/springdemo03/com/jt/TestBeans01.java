package springdemo03.com.jt;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import springdemo03.com.jt.sys.TestBase;
import springdemo03.com.jt.sys.controller.SysConfigController;
import springdemo03.com.jt.sys.dao.SysConfigDao;
import springdemo03.com.jt.sys.entity.SysConfig;
import springdemo03.com.jt.sys.service.SysConfigService;

import java.sql.SQLException;

public class TestBeans01 extends TestBase {

    @Test
    public void testDataSource() throws SQLException {
        DruidDataSource dataSource = ctx.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.getConnection());

    }

    @Test
    public void testSqlSessionFactory() {
        SqlSessionFactory ssf = ctx.getBean("sqlSessionFactory", SqlSessionFactory.class);
        System.out.println(ssf);
    }

    @Test
    public void testSqlsession() {
        SqlSessionFactory ssf = ctx.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession session = ssf.openSession();
        System.out.println(session);
        SysConfigDao dao = session.getMapper(SysConfigDao.class);
        SysConfig cfg = dao.findById(4);
        System.out.println(cfg);
        session.close();
    }

    @Test
    public void testSysConfigDao() {
        SysConfigDao dao = ctx.getBean(SysConfigDao.class);
        SysConfig cfg = dao.findById(4);
        System.out.println(cfg);
    }

    @Test
    public void testSysConfigServlce() {
        SysConfigService scfg = ctx.getBean("sysConfigService", SysConfigService.class);
        SysConfig cfg = scfg.findObjectById(4);
        System.out.println(cfg);
    }

    @Test
    public void testSysConfigController() {
        SysConfigController scc = ctx.getBean("sysConfigColtroller", SysConfigController.class);
        scc.findById(4);
    }


}






















