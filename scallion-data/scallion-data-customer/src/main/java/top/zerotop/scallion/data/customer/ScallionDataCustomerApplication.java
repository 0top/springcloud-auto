package top.zerotop.scallion.data.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ScallionDataCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScallionDataCustomerApplication.class, args);
    }

}
