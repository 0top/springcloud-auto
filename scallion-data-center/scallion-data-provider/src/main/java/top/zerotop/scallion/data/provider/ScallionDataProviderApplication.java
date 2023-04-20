package top.zerotop.scallion.data.provider;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class ScallionDataProviderApplication {

    public static void main(String[] args) {
        if (StringUtils.isBlank(System.getProperty("project.name"))) {
            System.setProperty("project.name", "scallion-data-provider");
        }
        SpringApplication.run(ScallionDataProviderApplication.class, args);
    }

}
