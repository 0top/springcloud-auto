package top.zerotop.scallion.task.auto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ScallionTaskAutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScallionTaskAutoApplication.class, args);
    }

}
