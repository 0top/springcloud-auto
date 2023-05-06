package top.zerotop.scallion.message.transfer.config;

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
    public Queue taskPublishQueue() {
        return new Queue("top.zerotop.queue.task.publish.fanout");
    }

    @Bean
    public FanoutExchange taskPublishFanout() {
        return new FanoutExchange("taskPublishFanout");
    }

    @Bean
    public Binding bindingTaskPublishFanout(Queue taskPublishQueue, FanoutExchange taskPublishFanout) {
        Binding binding = BindingBuilder.bind(taskPublishQueue).to(taskPublishFanout);
        amqpAdmin.declareBinding(binding);
        return binding;
    }
}
