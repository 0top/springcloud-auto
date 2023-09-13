package top.zerotop.scallion.datasource.shop;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import top.zerotop.scallion.datasource.EnableScallionDataSource;

import java.util.Arrays;
import java.util.Map;

@Configuration
public class ShopDataSourceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> m = conditionContext.getBeanFactory().getBeansWithAnnotation(EnableScallionDataSource.class);
        try {
            for (String beanName : m.keySet()) {
                EnableScallionDataSource annotation = conditionContext.getBeanFactory().findAnnotationOnBean(beanName, EnableScallionDataSource.class);
                boolean result = annotation != null &&
                        annotation.enableDatabaseList() != null &&
                        Arrays.asList(annotation.enableDatabaseList()).contains("scallion-shop");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    @Override
//    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
//        String requestDataSourceList = conditionContext.getEnvironment().getProperty("scallion.datasource.requests");
//        String[] datasourceList = Optional.ofNullable(requestDataSourceList).orElse("").split(",");
//        return Arrays.asList(datasourceList).contains("scallion-psychokinesis");
//    }
}
