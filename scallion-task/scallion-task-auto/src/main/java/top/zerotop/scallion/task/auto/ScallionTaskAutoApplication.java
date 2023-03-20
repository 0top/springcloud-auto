package top.zerotop.scallion.task.auto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.task.configuration.SimpleTaskAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.oas.annotations.EnableOpenApi;
import top.zerotop.scallion.datasource.EnableScallionDataSource;

@EnableScheduling
@EnableDiscoveryClient
@EnableScallionDataSource(enableDatabaseList = {"scallion-task"})
@SpringBootApplication(exclude = {SimpleTaskAutoConfiguration.class, DataSourceAutoConfiguration.class},
                            scanBasePackages = {"top.zerotop.scallion.datasource", "top.zerotop.scallion.task.auto"})
public class ScallionTaskAutoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScallionTaskAutoApplication.class, args);
    }

}
