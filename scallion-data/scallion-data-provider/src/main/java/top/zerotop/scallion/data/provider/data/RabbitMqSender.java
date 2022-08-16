package top.zerotop.scallion.data.provider.data;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RabbitMqSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        int count = 0;
        while (count < 50) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
            String message = String.format("发送消息, seq: %s, time: %s", count, LocalTime.now().toString());
            System.out.println(message);
            amqpTemplate.convertAndSend("scheduleFanout", "", message);
            count++;
        }
    }
}
