package top.zerotop.scallion.task.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ScallionTaskCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScallionTaskCommonApplication.class, args);
    }

}
