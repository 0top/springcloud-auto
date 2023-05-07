package top.zerotop.scallion.data.provider.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RabbitMqSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        Thread senderThread = new Thread(() -> {
            int count = 0;
            while (count < 500) {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                String message = String.format("Scallion Data provider 发送mq消息, time: %s", LocalTime.now().toString());
                System.out.println(message);
                amqpTemplate.convertAndSend("scheduleFanout", "", message);
                count++;
            }
        });
        senderThread.start();
    }
}
