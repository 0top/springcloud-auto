package top.zerotop.scallion.task.common.task;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextBeanUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static  <T> T getBean(String beanName, Class<T> clazz) {
        return (T) applicationContext.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
