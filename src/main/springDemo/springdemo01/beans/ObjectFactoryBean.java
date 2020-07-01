package springdemo01.beans;

import org.springframework.beans.factory.FactoryBean;


/**
 * 工厂bean对象
 * 1.需要实现FactoryBean接口
 * 2.重写接口方法
 * 1.一般应用于工厂对象的构建
 * @author Administrator
 *
 */
public class ObjectFactoryBean implements FactoryBean<ObjectFactory>{

	//此方法用于构建工厂对象

	public ObjectFactory getObject() throws Exception {
		System.out.println("getObjects()");
		return new ObjectFactory();
	}


	public Class<?> getObjectType() {
		System.out.println("getobjectType()");
		return ObjectFactory.class;
	}

	public boolean isSingleton() {
		System.out.println("isSingleton()");
		return false;
	}
	
}
