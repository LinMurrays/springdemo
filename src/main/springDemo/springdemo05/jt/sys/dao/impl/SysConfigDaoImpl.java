package springdemo05.jt.sys.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import springdemo05.jt.common.utils.OpenDataSource;
import springdemo05.jt.sys.dao.SysConfigDao;

/**
 * @Repository 此注解一般用于描述dao对象
 * 使用这样的注解修饰的对象通常称之为Bean
 * 对象,此对象由spring创建,假如是单例作用域
 * spring会将此对象存储到IOC容器(map),默认
 * 的key为类名,然后首字母小写.
 */
@Repository
public class SysConfigDaoImpl implements SysConfigDao {
	private OpenDataSource openDataSource;

	@Autowired//默认按修饰的方法中参数类型对象找匹配对象为属性注入值
	@Qualifier("dataSource")//假如有多个类型相同的对象，可借助此注解找名字
	public void setOpenDataSource(OpenDataSource openDataSource) {
		this.openDataSource = openDataSource;
	}

	public OpenDataSource getOpenDataSource() {
		return openDataSource;
	}
	
	
	
	
	
}
