package top.zerotop.scallion.datasource.shop;

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
@Conditional(ShopDataSourceCondition.class)
@MapperScan(basePackages = {"top.zerotop.scallion.web.shop.mapper"})
public class ShopDataSourceConfig {
    @Bean(name = "scallionShopDataSource")
    @ConfigurationProperties("scallion.datasource.scallion-shop")
    public DataSource shopDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "shopSqlSessionFactory")
    public SqlSessionFactory shopSqlSessionFactory(@Qualifier("scallionShopDataSource") DataSource scallionShopDataSource) {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(scallionShopDataSource);
            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/scallion-shop/*.xml"));
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            System.out.printf("初始化shopSqlSessionFactory失败。error：" + e.getMessage());
        }
        return null;
    }

    @Bean(name = "shopSqlSessionTemplate")
    public SqlSessionTemplate shopSqlSessionTemplate(@Qualifier("shopSqlSessionFactory") SqlSessionFactory scallionShopSqlSessionFactory) {
        return new SqlSessionTemplate(scallionShopSqlSessionFactory);
    }

    @Bean(name = "scallionShopTransactionManager")
    public DataSourceTransactionManager scallionShopTransactionManager(@Qualifier("scallionShopDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
