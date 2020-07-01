package springmvcdemo01.jt.example.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //从session中获取用户信息
        String user = (String) request.getSession().getAttribute("user");
        //有用户信息说明已经登录
        if (user != null) {
            return true;//放行
        }
        //没有用户信息则让用户先登录
        System.out.println("request.getContextPath()=" + request.getContextPath());
        response.sendRedirect(request.getContextPath() + "/doLoginUi.do");
        return false;

    }

}
