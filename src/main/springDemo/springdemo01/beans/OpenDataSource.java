package springdemo01.beans;
/**
 * 自定义数据源对象
 * @author Administrator
 *
 */

public class OpenDataSource {
	private OpenDataSource(){
		System.out.println("open");
		}
	public void init(){
		System.out.println("init");
	}
	public void close(){
		System.out.println("close");
	}

}
