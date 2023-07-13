package springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};  //Ссылка на конфигурационный файл
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};  //Все запросы от пользователя посылаются на DispatcherServlet
    }
}
