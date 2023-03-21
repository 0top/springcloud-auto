package top.zerotop.scallion.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import top.zerotop.scallion.datasource.EnableScallionDataSource;

@EnableScallionDataSource(enableDatabaseList = {"scallion-user"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"top.zerotop.scallion.datasource", "top.zerotop.scallion.user"})
public class ScallionUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScallionUserApplication.class, args);
    }
}
