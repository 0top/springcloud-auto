package top.zerotop.scallion.message.transfer;

import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"top.zerotop.scallion.message.transfer"})
public class MessageTransferApplication {
    public static void main(String[] args) {
        if (StringUtils.isBlank(System.getProperty("project.name"))) {
            System.setProperty("project.name", "scallion-message-transfer");
        }
        SpringApplication.run(MessageTransferApplication.class, args);
    }
}
