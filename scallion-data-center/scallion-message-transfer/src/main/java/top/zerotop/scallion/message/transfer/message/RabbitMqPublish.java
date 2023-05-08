package top.zerotop.scallion.message.transfer.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.zerotop.common.task.TaskMessage;
import top.zerotop.scallion.message.transfer.domain.ForwardMessage;

@Component
public class RabbitMqPublish {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void publishTask(TaskMessage taskMessage) {
        System.out.println(String.format("准备发布任务==》 %s", taskMessage.toString()));
        amqpTemplate.convertAndSend("taskPublishFanout", "", taskMessage);
    }
}
