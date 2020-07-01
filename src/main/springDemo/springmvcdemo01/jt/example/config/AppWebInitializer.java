package springmvcdemo01.jt.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**思考:
 1)此类何时被加载? tomcat 启动时
 2)加载的流程是怎样的?
 2.1) tomcat 启动时会读取类路径下的如下文件
 META-INF/services//META-INF/services/javax.servlet.ServletContainerInitializer
 2.2) 获取文件中定义的具体类,并且加载此类
 2.3) 然后加载修饰此类的@HandlesTypes注解中定义的类型的子类类型.
 Initializer--初始化器
 */
//web.xml
public class AppWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public AppWebInitializer() {
        System.out.println("AppWebInitializer() ");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses()");
        return null;//service,dao
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("getServletConfigClasses()");
        return new Class[]{AppServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("getServletMappings()");
        return new String[]{"*.do"};
    }
}
