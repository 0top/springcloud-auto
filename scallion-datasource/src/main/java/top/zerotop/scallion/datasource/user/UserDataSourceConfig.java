package top.zerotop.scallion.datasource.user;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@Conditional(UserDataSourceCondition.class)
@MapperScan(basePackages = {"top.zerotop.scallion.user.mapper"})
public class UserDataSourceConfig {
    @Bean(name = "scallionUserDataSource")
    @ConfigurationProperties("scallion.datasource.scallion-user")
    public DataSource taskDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "scallionUserSqlSessionFactory")
    public SqlSessionFactory scallionUserSqlSessionFactory(@Qualifier("scallionUserDataSource") DataSource scallionUserDataSource) {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(scallionUserDataSource);
            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:scallion-user/*.xml"));
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            System.out.printf("初始化scallionUserSqlSessionFactory失败。error：" + e.getMessage());
        }
        return null;
    }

    @Bean(name = "scallionUserSqlSessionTemplate")
    public SqlSessionTemplate scallionUserSqlSessionTemplate(@Qualifier("scallionUserSqlSessionFactory") SqlSessionFactory scallionUserSqlSessionFactory) {
        return new SqlSessionTemplate(scallionUserSqlSessionFactory);
    }

    @Bean(name = "scallionUserTransactionManager")
    public DataSourceTransactionManager scallionUserTransactionManager(@Qualifier("scallionUserDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
