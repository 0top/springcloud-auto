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
        return new Queue("top.zerotop.queue.schedule.fanout");
    }

    @Bean
    public FanoutExchange scheduleFanout() {
        return new FanoutExchange("scheduleFanout");
    }

    @Bean
    public Binding bindingScheduleFanout(Queue scheduleQueue, FanoutExchange scheduleFanout) {
        return BindingBuilder.bind(scheduleQueue).to(scheduleFanout);
    }
}
