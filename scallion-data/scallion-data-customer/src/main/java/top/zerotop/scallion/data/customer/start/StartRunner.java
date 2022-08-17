package top.zerotop.scallion.data.customer.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.zerotop.scallion.data.customer.data.RabbitMqReceiver;
import top.zerotop.scallion.data.customer.data.RabbitMqStreamReceiver;

@Component
public class StartRunner implements CommandLineRunner {
    @Autowired
    private RabbitMqReceiver mqReceiver;
    @Autowired
    private RabbitMqStreamReceiver streamReceiver;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("start...");
    }
}
