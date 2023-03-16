package top.zerotop.scallion.datasource.psychokinesis;

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
import top.zerotop.scallion.datasource.psychokinesis.PsychokinesisDataSourceCondition;

import javax.sql.DataSource;

@Configuration
@Conditional(PsychokinesisDataSourceCondition.class)
@MapperScan(basePackages = {"top.zerotop.scallion.web.psychokinesis.mapper"})
public class PsychokinesisDataSourceConfig {
    @Bean(name = "scallionPsychokinesisDataSource")
    @ConfigurationProperties("scallion.datasource.scallion-psychokinesis")
    public DataSource psychokinesisDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "psychokinesisSqlSessionFactory")
    public SqlSessionFactory psychokinesisSqlSessionFactory(@Qualifier("scallionPsychokinesisDataSource") DataSource scallionPsychokinesisDataSource) {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(scallionPsychokinesisDataSource);
            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/scallion-psychokinesis/*.xml"));
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            System.out.printf("初始化psychokinesisSqlSessionFactory失败。error：" + e.getMessage());
        }
        return null;
    }

    @Bean(name = "psychokinesisSqlSessionTemplate")
    public SqlSessionTemplate psychokinesisSqlSessionTemplate(@Qualifier("psychokinesisSqlSessionFactory") SqlSessionFactory psychokinesisSqlSessionFactory) {
        return new SqlSessionTemplate(psychokinesisSqlSessionFactory);
    }

    @Bean(name = "scallionPsychokinesisTransactionManager")
    public DataSourceTransactionManager scallionPsychokinesisTransactionManager(@Qualifier("scallionPsychokinesisDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
