package top.zerotop.scallion.web.psychokinesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"top.zerotop.scallion.datasource", "top.zerotop.scallion.web.psychokinesis"})
@EnableOpenApi
public class WebPsychokinesisApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebPsychokinesisApplication.class, args);
    }

}
