package mybatisdemo02.args;

import java.util.Arrays;
import java.util.List;

public class TestArgs1 {
	/**
	 * 可以理解动态参数为一个数组
	 * 减少类中参数类型相同，个数不同的重载方法
	 * @param
	 * @return
	 */
	static int method(int... array){
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			count+=array[i];
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(method(1,2));
		System.out.println(method(1,2,3));
		
		List<Integer> list = Arrays.asList(1,32,3,4,6);
		//list.add(5);报错,不支持添加删除
		list.set(2, 8);//支持修改
	}

	
}
