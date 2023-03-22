package top.zerotop.scallion.data.customer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Bean
    public Queue scheduleQueue() {
        return new Queue("top.zerotop.queue.schedule.topic");
    }

    @Bean
    public TopicExchange scheduleTopic() {
        return new TopicExchange("scheduleTopic");
    }

    @Bean
    public Binding bindingScheduleTopic(Queue scheduleQueue, TopicExchange scheduleTopic) {
        return BindingBuilder.bind(scheduleQueue).to(scheduleTopic).with("scheduleTopic");
    }
}
