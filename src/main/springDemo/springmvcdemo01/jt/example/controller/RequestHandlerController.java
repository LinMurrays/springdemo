package springmvcdemo01.jt.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springmvcdemo01.jt.example.entity.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/req")
public class RequestHandlerController {
    //多个url访问一个url

    /***
     * 普通的请求url映射
     * @return
     */
    @RequestMapping(value = {"dopath01", "doReqpath", "doRequest"})
    @ResponseBody
    public String doRequestPath01() {
        return "request path 01";
    }

    /**
     * Rest风格的请求路径映射,简化多个
     * url编写以及实现状态值的传递
     *
     * @return
     */
    @RequestMapping("doRequestPath/{a}")
    @ResponseBody
    public String doRequestPath02() {
        return "request path 02";
    }

    @RequestMapping(value = "doRequestType01", method = {RequestMethod.GET})
    @ResponseBody
    public String doRequestPath03() {
        return "request path 03请求方式映射";
    }

    @RequestMapping(value = "doRequestType02", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String doRequestPath04() {
        return "request path 03请求方式映射adssad";
    }

    /**
     * 请求参数处理(原生servlet API)
     */
    @RequestMapping("doRequestParam01")
    @ResponseBody
    public String doRequestParam01(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        String queryString = request.getQueryString();
        return "uri" + uri + "<br/>" + "url" + url + "<br/>" + "queryString=" + queryString;

    }

    @RequestMapping("doRequestParam02")
    @ResponseBody
    //通过反射在浏览器注入参数值可以调用
    //http://localhost/CGB-SPRING-MVC-04/req/doRequestParam02.do?name=A&page=1&date=2018/07/25
    //日期格式要用"/"分割
    //传值尽量使用对象类型，不要使用基本数据类型例如int
    //如果使用了对象类型没有传值会显示null值,如果使用基本类型会报错
    public String doRequestParam02(String name, Integer page, Date date) {

        return name + "/" + page + "/" + date;

    }

    @RequestMapping("doRequestParam03")
    @ResponseBody
    //@DateTimeFormat(pattern="yyyy-mm-dd")
    public String doRequestParam03
            (String name, Integer page,
             Date date,
             @RequestParam(value = "param-01", required = false) String foo
            ) {
        return name + "/" + page + "/" + date + "/" + foo;

    }

    /**
     * 当使用pojo或vo对象等接收页面
     * 参数数据时,对象内部需要提供
     * 与参数名对应的set方法.
     *
     * @param msg
     * @return
     */
    @RequestMapping("doRequestParam04")
    @ResponseBody
    //http://localhost/CGB-SPRING-MVC-04/req/
    //doRequestParam04.do?id=1&title=2&createdDate=2018/07/25
    //底层会通过反射调用set方法为对象属性注入值
    /**
     * 当时用pojo或vo对象等接受页面时参数数据时，
     * 底层会通过反射调用set方法为对象属性注入值
     * @param msg
     * @return
     */
    public String doRequestParam04(Message msg) {
        return msg.toString();
    }


    @RequestMapping("doRequestParam05")
    @ResponseBody
    //http://localhost/CGB-SPRING-MVC-04/req/doRequestParam05.do?ids=1,2,3,4
    //可以使用Integer来赋值
    public String doRequestParam05(Integer[] ids) {
        return Arrays.toString(ids);
    }

    /**
     * rest风格的url实现参数值的注入
     * 需要使用@PathVariable注解修饰
     *
     * @param id
     * @param username
     * @return
     */
    @RequestMapping("doRequestParam06/{id}/{name}")
    @ResponseBody
    //参数来自路径
    public String doRequestParam06(@PathVariable Integer id, @PathVariable(value = "name", required = false) String username) {
        return "id=" + id + "/username:" + username;
    }

    @RequestMapping("doRequestParam07")
    @ResponseBody
    //Accepttext/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8Accept-Encodinggzip, deflate
    //http://localhost/CGB-SPRING-MVC-04/req/doRequestParam07.do
    public String doRequestParam07
            (@RequestHeader String Accept, @RequestHeader("Accept-Encoding") String AcceptEncoding) {
        return "Accept:" + Accept + "Accept-Encoding" + AcceptEncoding;
    }

    @RequestMapping("doRequestParam08")
    @ResponseBody
    public String doRequestParam08(@CookieValue(required = false) String JSESSIONID, HttpSession session) {
        System.out.println(session);
        return "Obtained COOKIE Value '" + JSESSIONID + "'";
    }


}
