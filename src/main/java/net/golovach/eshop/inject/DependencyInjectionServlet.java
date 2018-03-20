package net.golovach.eshop.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Field;
import java.util.List;

public class DependencyInjectionServlet extends HttpServlet {

    public static final String APP_CTX_PATH = "contextConfigLocation";



    @Override
    public void init() throws ServletException {

        String appCtxPath = this.getServletContext().getInitParameter(APP_CTX_PATH);
        if(appCtxPath == null){
            throw new ServletException();
        }
        try {
            ApplicationContext appCtx = new ClassPathXmlApplicationContext("appContext-dao.xml");
            //виртуальность!
            List<Field> allFields = FieldReflector.collectUpTo(this.getClass(), DependencyInjectionServlet.class);
            List<Field> injectFields = FieldReflector.filterInject(allFields);

            for (Field field : injectFields) {
                //crack private and final!
                field.setAccessible(true);
                Inject annotation = field.getAnnotation(Inject.class);
                String beanName = annotation.value();
                Object bean = appCtx.getBean(beanName);
                if (bean == null) {
                    throw new ServletException();
                }
                field.set(this, bean);
            }
        } catch (IllegalAccessException e){

        }
    }


}
