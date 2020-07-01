package springmvcdemo01.jt.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvcdemo01.jt.example.entity.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 多个线程(多个客户端)访问单个controller时，(单例对象)，要注意线程安全
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/resp/")
public class ResponseHandlerController {

    @RequestMapping("doResponse01")
    public String doResponse01(HttpServletRequest request) {
        request.setAttribute("msg", "hello");
        //return "response";//请求转发
        return "redirect:doResponse02.do?msg=hello";
    }

    @RequestMapping("doResponse02")
    public String doResponse02(HttpServletRequest request) {
        request.setAttribute("msg", "hello");
        return "response";//请求转发
    }

    @RequestMapping("doResponse03")
    @ResponseBody
    //需要导入jason 的jar包，将map集合以字符串形式呈现在浏览器
    public Map<String, Object> doResponse3() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 100);
        map.put("title", "hello");
        map.put("createdTime", new Date());
        return map;
    }

    @RequestMapping("doResponse04")
    @ResponseBody
    //需要导入jason 的jar包，将map集合以字符串形式呈现在浏览器
    public List<Map<String, Object>> doResponse4() {
        List<Map<String, Object>> list = new ArrayList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 100);
        map.put("title", "hello");
        map.put("createdTime", new Date());
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("id", 200);
        map.put("title", "hello");
        map.put("createdTime", new Date());
        list.add(map);
        return list;
    }

    @RequestMapping("doResponse05")
    @ResponseBody
    //需要导入jason 的jar包，将map集合以字符串形式呈现在浏览器
    public Message doResponse5() {
        Message msg = new Message();
        msg.setId(100);
        msg.setCreatedDate(new Date());
        msg.setTitle("title");
        return msg;//底层将对象转换为json字符串时，会调用对象的get方法

    }


}

