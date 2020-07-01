package springmvcdemo01.jt.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//这是注解的方式，代替大量的配置文件，比如spring-configs.xml
//spring-configs.xml
@ComponentScan("springmvcdemo01.jt")//配置包扫描
@EnableWebMvc //启动mvc默认配置
public class AppServletConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置视图解析器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/",
                ".jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        super.addInterceptors(registry);
        TimeInterceptor interceptor = new TimeInterceptor();
        LoginInterceptor interceptor2 = new LoginInterceptor();

        registry.addInterceptor(interceptor2)
                .addPathPatterns("/req/*");

        registry.addInterceptor(interceptor)
                .addPathPatterns("/req/*")//拦截
                .excludePathPatterns("/resp/*");//不拦截


    }
}
