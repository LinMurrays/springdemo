package springmvcdemo01.jt.example.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring MVC后端控制器
 * 1.此对象如何交给Spring管理
 * 2.从浏览器中输入一个url如何找到此对象
 * 3.此对象handleRequest方法处理结束后如何返回对应的页面，以及如何对页面解析
 *
 * @author Administrator
 */

public class XmlHelloController implements Controller {
    /**
     * 处理客户端请求
     */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String msg = request.getParameter("msg");

        if (msg != null || msg.trim().length() > 0) {
            msg = msg.toUpperCase();
        }
        //VO值对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msg);//默认放到请求作用域
        mv.setViewName("hello");//在哪个页面中 呈现modle中的数据
        return mv;

    }

}
