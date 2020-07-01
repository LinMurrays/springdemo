package mybatisdemo02.com.test;

import mybatisdemo02.com.jt.module.dao.OrderDao;
import mybatisdemo02.com.jt.module.entity.Order;
import mybatisdemo02.com.jt.module.entity.OrderResult;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

public class TestOrderDao01 extends TestBase {

    @Test
    public void insertObjects() {
        //1.create Session
        SqlSession session = factory.openSession();
        //2.execute query
        OrderDao dao = session.getMapper(OrderDao.class);
        Order entity = new Order();

        entity.setPrice(44.2);
        entity.setState(41);
        entity.setProjectId(11);

        int rows = dao.insertObjects(entity);
        session.commit();
        System.out.println(entity.getId());
        session.close();
    }

    @Test
    public void testFindObjectById() {
        SqlSession session = factory.openSession();

        OrderDao dao = session.getMapper(OrderDao.class);

        String id = "2bdd558d8af111e8bac6fc3fdb107eb0";

        Map<String, Object> map = dao.findObjectByid(id);

        System.out.println(map);
        session.close();
    }


    @Test
    public void findOrderResultWithId() {
        SqlSession session = factory.openSession();

        OrderDao dao = session.getMapper(OrderDao.class);

        String id = "2bdd558d8af111e8bac6fc3fdb107eb0";

        OrderResult result = dao.findOrderResultWithId(id);

        System.out.println("orderId:" + result);

        session.close();
    }


}
