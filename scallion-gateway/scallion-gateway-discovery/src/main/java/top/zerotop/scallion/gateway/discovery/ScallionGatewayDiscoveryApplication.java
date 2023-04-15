package top.zerotop.scallion.gateway.discovery;

import io.netty.util.internal.StringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ScallionGatewayDiscoveryApplication {

    public static void main(String[] args) {
        if (StringUtil.isNullOrEmpty(System.getProperty("project.name"))) {
            System.setProperty("project.name", "scallion-gateway-discovery");
        }
        SpringApplication.run(ScallionGatewayDiscoveryApplication.class, args);
    }

}
