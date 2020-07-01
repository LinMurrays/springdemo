package mybatisdemo02.com.test;


import mybatisdemo02.com.jt.module.dao.ProjectDao;
import mybatisdemo02.com.jt.module.entity.Project;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCach01 extends TestBase{
	 
	/**
     * 1.MyBatis中的一级缓存指的是?
     * 2.MyBatis中的一级缓存默认开启了吗?
     * 3.MyBatis中的一级缓存中使用的哪个缓存对象?
     *   3.1)PerpetualCache 对象(永久cache,底层实现HashMap)
     *   3.2)PerpetualCache 对象何时创建的?
     * 4.MyBatis中执行查询时一级缓存的应用过程?
     * 4.1)先从一级缓存找
     * 4.2)有则直接返回
     * 4.3)没有则访问数据库
     * 4.4)将查询结果放到缓存，然后返回。
     */
	
	@Test
	public void testFirstLevelCach01(){
		SqlSession session = factory.openSession();
		ProjectDao dao = session.getMapper(ProjectDao.class);
		 //查询数据,并将数据存储在缓存中
		Project p1 = dao.findObjectById(10);
		System.out.println(p1);
		//此次缓存直接从缓存中获取
		Project p2 = dao.findObjectById(10);
		System.out.println(p2);
		
		 
	}
	
	/**一级缓存会因为insert,update,delete导致缓存失效*/
	@Test  
	public void testFirstLevelCache02(){
		  SqlSession session=factory.openSession();
		  ProjectDao dao=
				  session.getMapper(ProjectDao.class);
		  //查询数据,并将数据存储在缓存中
		  Project p1=dao.findObjectById(2);//session.selectList
		  System.out.println(p1);
		  Project p=new Project();
		  p.setName("project-ccccc-11111");
		  p.setNote("project-note-cccccc-11111");
		  dao.insertObject(p);
		  session.commit();
		  //查询数据,此次查询直接从缓存获取
		  Project p2=dao.findObjectById(2);
		  System.out.println(p2);
		  session.close();
	  }
	
	 /**
	   * 一级缓存可能存在脏读现象
	   */
	  @Test
	  public void testFirstLevelCache03(){
	  		SqlSession session1=factory.openSession(true);
	  		SqlSession session2=factory.openSession(true);
	  		ProjectDao dao1=session1.getMapper(ProjectDao.class);
	  		ProjectDao dao2=session2.getMapper(ProjectDao.class);
	  		int id=2;
	  		Project a1=dao1.findObjectById(id);
	  		System.out.println(a1);
	  		Project a=new Project();
	  		a.setId(id);
	  		a.setName("12306");
	  		a.setNote("12306........");
	  		int rows=dao2.updateObject(a);
	  		session2.close();
	  		Project a2=dao1.findObjectById(id);
	  		System.out.println(a2);
	  		session1.close();
	  	}
	
}




