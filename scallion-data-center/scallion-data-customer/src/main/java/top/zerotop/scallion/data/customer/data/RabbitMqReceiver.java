package top.zerotop.scallion.data.customer.data;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReceiver {

    @RabbitListener(queues = "top.zerotop.queue.schedule.fanout")
    public void receiver(String message) {
        System.out.println(message);
    }
}
