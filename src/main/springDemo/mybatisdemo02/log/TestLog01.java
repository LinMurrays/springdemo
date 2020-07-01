package mybatisdemo02.log;

import java.util.logging.Logger;

public class TestLog01 {
	static Logger log =Logger.getLogger(TestLog01.class.getName());
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("hello");
		log.info("hello");
		
		Class<?> c1= TestLog01.class;
		Class<?> c2= new TestLog01().getClass();
		Class<?> c3 = Class.forName("log.TestLog01");
		System.out.println(c1==c2);
		System.out.println(c2==c3);
	}
}
