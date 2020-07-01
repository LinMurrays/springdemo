package mybatisdemo01.com.test;

import mybatisdemo01.com.jt.module.dao.ProjectDao;
import mybatisdemo01.com.jt.module.entity.Project;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TestProjectDao01 {
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-configs.xml"));
    }

    @Test
    public void testFindObjects() {
        //1.create Session
        SqlSession session = factory.openSession();
        //2.execute query
        //2.1获取接口实现类对象
        //等号右边等于一个代理对象
        ProjectDao dao = session.getMapper(ProjectDao.class);
        //2.3执行查询命令
        List<Project> list = dao.findObjects();
        //2.3处理查询结果
        for (Project project : list) {
            System.out.println("test"+project);
        }
        session.close();
    }

    @Test
    public void findObjectById() {//Executor-->CachingExecutor-->SimpleExecutor-->jdbc
        //1.create session
        SqlSession session = factory.openSession();
        //2.execute query
        //session.selectList(statement, parameter);
        //2.1 获取接口实现类对象
        //等号右边指向的是一个代理对象(课后了解代理模式)
        ProjectDao dao = session.getMapper(ProjectDao.class);
        //2.2执行查询操作
        Project pro = dao.findObjectById(8);
        //2.3处理查询结果
        System.out.println(pro);
        //3.close session
        session.close();
    }

    @Test
    public void findPageObjects() {
        SqlSession session = factory.openSession();
        ProjectDao dao = session.getMapper(ProjectDao.class);
        List<Project> pro = dao.findPageObjects("a", 1, 2);
        for (Project project : pro) {
            System.out.println(project);
        }
        session.close();
    }

    @Test
    public void insertObjects() {
        SqlSession session = factory.openSession();
        ProjectDao dao = session.getMapper(ProjectDao.class);
        Project p = new Project();
        p.setName("zhaoyun");
        p.setNote("diaochan");
        p.setCreatedTime(new Date());
        int rows = dao.insertObject(p);
        session.commit();
        System.out.println("rows=" + rows);
        session.close();
    }

    @Test
    public void updateObject() {
        SqlSession session = factory.openSession();
        ProjectDao dao = session.getMapper(ProjectDao.class);
        Project p = new Project();
        p.setId(7);
        p.setName("libai");
        p.setNote("lvbu");
        p.setCreatedTime(new Date());
        int rows = dao.updateObject(p);
        session.commit();
        System.out.println("rows=" + rows);
        session.close();
    }

    @Test
    public void deleteObject() {
        SqlSession session = factory.openSession();
        ProjectDao dao = session.getMapper(ProjectDao.class);

        int rows = dao.deleteObject(13);
        session.commit();
        System.out.println("rows=" + rows);
        session.close();
    }

}
