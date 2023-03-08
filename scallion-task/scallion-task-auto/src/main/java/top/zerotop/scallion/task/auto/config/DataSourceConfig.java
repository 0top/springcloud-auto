package top.zerotop.scallion.task.auto.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.scallion-task")
    public DataSource taskDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate testJdbcTemplate() {
        return new JdbcTemplate(taskDataSource());
    }
}
