package springmvcdemo01.jt.example.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JacksonTest {
	@Test
	public void test() throws Exception {
		
			//1.构建map对象
			Map<String,Object>map = new HashMap<String,Object>();
			//2.存储数据
			map.put("id", 100);
			map.put("name","name-a");
			map.put("age",20);
			
			 //3.将map对象转换为json格式字符串
			  //3.1构建对象转换器(jackson)
			ObjectMapper om = new ObjectMapper();
			 //3.2将map对象转换为json字符串(重要)
			String s1=om.writeValueAsString(map);
			
			System.out.println(s1);
			//假如有需要也可以将json串转换为java对象
			Map<?,?>map2 = om.readValue(s1, Map.class);
			System.out.println(map2);
	}
	
	  @Test
	  public void testList()throws Exception{
		  //1构建一个list对象
		  List<Map<String,Object>> list=
		  new ArrayList<Map<String,Object>>();
		  //2.构建map对象,并存储数据
		  Map<String,Object> map=
				  new HashMap<String,Object>();
		  map.put("id", 100);
		  map.put("name","AAA");
		  map.put("age",20);
		  list.add(map);
		  map=new HashMap<String,Object>();
		  map.put("id", 101);
		  map.put("name","DDD");
		  map.put("age", 30);
		  list.add(map);
		  //3.将list对象转换为json格式字符串
		  //3.1构建对象转换器(jackson)
		  ObjectMapper om=new ObjectMapper();
		  //3.2将map对象转换为json字符串(重要)
		  String s1=om.writeValueAsString(list);      
		  System.out.println(s1);
	  }
	  
	  @Test
	  public void testUser()throws Exception{        
		  //构建一个java对象
		  SysUser user=new SysUser();
		  user.setId(10);
		  user.setUsername("CCCCC");
		  user.setPassword("123456");
		  //将java对象转换为字符串
		  ObjectMapper om=new ObjectMapper();
		  String jsonStr=
		  om.writeValueAsString(user);
		  System.out.println(jsonStr);
		  //构建list集合,并存储多个User对象
		  List<SysUser> list=new ArrayList<SysUser>();
		  list.add(user);
		  user=new SysUser();
		  user.setId(20);
		  user.setUsername("MMM");
		  user.setPassword("456789");
		  list.add(user);
		  //将list集合转换为json格式的
		  jsonStr=om.writeValueAsString(list);
		  System.out.println(jsonStr);
	  }
}

