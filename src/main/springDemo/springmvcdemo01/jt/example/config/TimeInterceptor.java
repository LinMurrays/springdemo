package springmvcdemo01.jt.example.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeInterceptor implements HandlerInterceptor {

    /**
     * tomcat启动时创建对象。单例对象，可能会出现线程不安全问题
     */

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("preHandle");
        //多线程共享资源时要注意线程安全
        long startTime = System.nanoTime();
        //false表示请求不再继续执行，true表示继续执行
        request.setAttribute("startTime", startTime);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("postHandle");
    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println("aftercompletion");
        long endTime = System.nanoTime();
        Object totalTime = (Object) request.getAttribute("startTime");
//        long time = endTime - totalTime;
        System.out.println(totalTime);
    }

}
