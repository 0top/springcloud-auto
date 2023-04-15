package top.zerotop.scallion.data.customer;

import io.netty.util.internal.StringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ScallionDataCustomerApplication {

    public static void main(String[] args) {
        if (StringUtil.isNullOrEmpty(System.getProperty("project.name"))) {
            System.setProperty("project.name", "scallion-data-customer");
        }
        SpringApplication.run(ScallionDataCustomerApplication.class, args);
    }

}
