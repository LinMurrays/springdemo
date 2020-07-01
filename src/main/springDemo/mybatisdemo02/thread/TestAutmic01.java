package mybatisdemo02.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAutmic01 {
	static int count;
	static int getAndIncrement(){
		count++;
		return count;
	}
	
	public static void main(String[] args) {
		//线程安全(底层使用了CAS算法)
		 final AtomicInteger a=new AtomicInteger(1);
		
		for (int j = 1; j <3; j++) {
			new Thread(){
				public void run() {
					for (int i = 0; i < 10; i++) {
						System.out.println(a.getAndIncrement());
					}
				};
			}.start();
		}
	}
}
