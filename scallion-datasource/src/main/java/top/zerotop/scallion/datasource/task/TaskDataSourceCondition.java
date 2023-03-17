package top.zerotop.scallion.datasource.task;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import top.zerotop.scallion.datasource.EnableScallionDataSource;

import java.util.Arrays;
import java.util.Map;

@Configuration
public class TaskDataSourceCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> m = conditionContext.getBeanFactory().getBeansWithAnnotation(EnableScallionDataSource.class);
        try {
            String applicationBeanName = m.keySet().stream().filter(x -> x.endsWith("Application")).findFirst().get();
            EnableScallionDataSource annotation = conditionContext.getBeanFactory().findAnnotationOnBean(applicationBeanName, EnableScallionDataSource.class);
            boolean result = annotation != null &&
                                annotation.enableDatabaseList() != null &&
                                Arrays.asList(annotation.enableDatabaseList()).contains("scallion-task");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //    @Override
//    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
//        String requestDataSourceList = conditionContext.getEnvironment().getProperty("scallion.datasource.requests");
//        String[] datasourceList = Optional.ofNullable(requestDataSourceList).orElse("").split(",");
//        return Arrays.asList(datasourceList).contains("scallion-task");
//    }
}
