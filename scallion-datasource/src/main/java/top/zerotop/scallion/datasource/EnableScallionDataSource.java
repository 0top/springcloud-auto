package top.zerotop.scallion.datasource;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan("top.zerotop.scallion.datasource")
public @interface EnableScallionDataSource {
    String[] enableDatabaseList() default {};
}
