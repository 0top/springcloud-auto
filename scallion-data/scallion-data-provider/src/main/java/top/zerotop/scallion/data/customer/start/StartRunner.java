package top.zerotop.scallion.data.customer.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.zerotop.scallion.data.customer.data.RabbitMqSender;

@Component
public class StartRunner implements CommandLineRunner {
    @Autowired
    private RabbitMqSender mqSender;

    @Override
    public void run(String... args) throws Exception {
        mqSender.send();
    }
}
