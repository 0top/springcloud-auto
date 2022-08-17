package top.zerotop.scallion.data.customer.data;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class RabbitMqStreamReceiver {

    @StreamListener(Sink.INPUT)
    public void receiver(Object payload) {
        System.out.println(String.format("cloud stream接收mq ： %s", payload));
    }
}
