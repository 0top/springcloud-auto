package top.zerotop.scallion.data.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ScallionGatewayDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScallionGatewayDiscoveryApplication.class, args);
    }

}
