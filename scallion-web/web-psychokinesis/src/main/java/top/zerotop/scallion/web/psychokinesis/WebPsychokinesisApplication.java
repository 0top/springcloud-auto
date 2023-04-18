package top.zerotop.scallion.web.psychokinesis;

import com.alibaba.nacos.api.utils.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;
import top.zerotop.scallion.datasource.EnableScallionDataSource;

@EnableDiscoveryClient
@EnableScallionDataSource(enableDatabaseList = {"scallion-psychokinesis"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},
                         scanBasePackages = {"top.zerotop.scallion.datasource", "top.zerotop.scallion.web.psychokinesis"})
@EnableOpenApi
public class WebPsychokinesisApplication {

    public static void main(String[] args) {
        if (StringUtils.isBlank(System.getProperty("project.name"))) {
            System.setProperty("project.name", "scallion-web-psychokinesis");
        }
        SpringApplication.run(WebPsychokinesisApplication.class, args);
    }

}
