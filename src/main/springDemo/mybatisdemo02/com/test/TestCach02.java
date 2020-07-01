package mybatisdemo02.com.test;

import mybatisdemo02.com.jt.module.dao.ProjectDao;
import mybatisdemo02.com.jt.module.entity.Project;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCach02 extends TestBase{
	@Test
	public void testSecondLevelCach01(){
		
		SqlSession session1=factory.openSession(true);
		SqlSession session2=factory.openSession(true);
		SqlSession session3=factory.openSession(true);
		ProjectDao dao1=session1.getMapper(ProjectDao.class);
		ProjectDao dao2=session2.getMapper(ProjectDao.class);
		ProjectDao dao3=session3.getMapper(ProjectDao.class);
		//查询数据,并将数据存储在缓存中	
		Project p1 = dao1.findObjectById(10);
			System.out.println(p1);
			session1.close();//commit或session关闭时会将数据存储到二级缓存
			//查询数据,此次查询直接从缓存获取
			Project p2 = dao2.findObjectById(10);
			System.out.println(p2);
			session2.close();
			//查询数据
			Project p3=dao3.findObjectById(2);
			System.out.println(p3);
			session3.close();
			System.out.println(p1==p2);
			System.out.println(p2==p3);
	}
	
}
