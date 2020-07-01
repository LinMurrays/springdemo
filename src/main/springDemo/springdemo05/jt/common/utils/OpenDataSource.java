package springdemo05.jt.common.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 借助@Component注解描述此类为一个bean组件对象
 * @author Administrator
 *
 */
@Component("dataSource")
@Lazy//这个对象延迟加载
@Scope("singleton")//默认,假如希望是多例,可配置prototype
public class OpenDataSource {

	public OpenDataSource() {
		System.out.println("opendatasource()");
	}
	
	@PostConstruct//表示生命周期的初始化方法
	public void init(){
		System.out.println("init()");
	}
	
	@PreDestroy//表示生命周期的销毁方法
	public void destory(){
		System.out.println("destory");
	}

}
