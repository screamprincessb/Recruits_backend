package com.sense.backend.common.helper;
import com.sense.backend.hb.config.HibernateConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HBHelper {

    private static HBHelper instance;

    private AnnotationConfigApplicationContext context;

    private HBHelper() {
        context = new AnnotationConfigApplicationContext(HibernateConfig.class);
    }

    public static HBHelper instance() {
        if (instance == null) {
            instance = new HBHelper();
        }

        return instance;
    }

    public AnnotationConfigApplicationContext context() {
        return context;
    }

    public <T> T service(Class<T> serviceClass) {
        return context.getBean(serviceClass);
    }

}
