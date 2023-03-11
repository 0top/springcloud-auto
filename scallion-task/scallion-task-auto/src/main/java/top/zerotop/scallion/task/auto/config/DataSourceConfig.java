package top.zerotop.scallion.task.auto.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"top.zerotop.scallion.task.auto.mapper"})
public class DataSourceConfig {
    @Primary
    @Bean(name = "scallionTaskDataSource")
    @ConfigurationProperties("scallion.datasource.scallion-task")
    public DataSource taskDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "taskSqlSessionFactory")
    public SqlSessionFactory taskSqlSessionFactory(@Qualifier("scallionTaskDataSource") DataSource scallionTaskDataSource) {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(scallionTaskDataSource);
            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/scallion-task/*.xml"));
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            System.out.printf("初始化taskSqlSessionFactory失败。error：" + e.getMessage());
        }
        return null;
    }

    @Bean(name = "taskSqlSessionTemplate")
    public SqlSessionTemplate taskSqlSessionTemplate(@Qualifier("taskSqlSessionFactory") SqlSessionFactory taskSqlSessionFactory) {
        return new SqlSessionTemplate(taskSqlSessionFactory);
    }

    @Primary
    @Bean(name = "scallionTaskTransactionManager")
    public DataSourceTransactionManager scallionTaskTransactionManager(@Qualifier("scallionTaskDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

//    @Bean
//    public JdbcTemplate testJdbcTemplate() {
//        return new JdbcTemplate(taskDataSource());
//    }
}
