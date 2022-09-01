package top.zerotop.scallion.web.psychokinesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableDiscoveryClient
@SpringBootApplication
@EnableOpenApi
public class WebPsychokinesisApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebPsychokinesisApplication.class, args);
    }

}
