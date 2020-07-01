package mybatisdemo02.generic;

import java.util.ArrayList;
import java.util.List;

public class DefaultSqlSession {
	<T>T getMapper(Class<?> cls){
		
		
		return null;
	}
	
	int insert(CharSequence statement){
		
		
		
		return 1;
	}
	
	<q>void show(q t){
		
	}
	
	<t>List<t> sort(List<? extends Comparable<t>> list){
		return null;
		
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		 list.add("aa");
		
	List<String> list2	=new DefaultSqlSession().sort(list);
		System.out.println(list2);
	}
}
