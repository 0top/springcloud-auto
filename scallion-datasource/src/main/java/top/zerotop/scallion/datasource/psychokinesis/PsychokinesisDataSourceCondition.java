package top.zerotop.scallion.datasource.psychokinesis;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;
import java.util.Optional;

@Configuration
public class PsychokinesisDataSourceCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String requestDataSourceList = conditionContext.getEnvironment().getProperty("scallion.datasource.requests");
        String[] datasourceList = Optional.ofNullable(requestDataSourceList).orElse("").split(",");
        return Arrays.asList(datasourceList).contains("scallion-psychokinesis");
    }
}
