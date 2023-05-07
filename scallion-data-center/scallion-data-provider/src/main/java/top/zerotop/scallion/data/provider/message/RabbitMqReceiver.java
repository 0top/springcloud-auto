package top.zerotop.scallion.data.provider.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.zerotop.common.task.TaskMessage;
import top.zerotop.common.task.enums.TaskTypeEnum;
import top.zerotop.scallion.data.provider.data.GenerateDataTask;

@Component
public class RabbitMqReceiver {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private GenerateDataTask generateDataTask;

    @RabbitListener(queues = "top.zerotop.queue.task.publish.fanout")
    public void receiver(TaskMessage message) {
        System.out.println("接受到任务==》" + message);
        TaskTypeEnum taskType = message.getTaskType();
        if (TaskTypeEnum.GENERATE_DATA == taskType) {
            generateDataTask.execTask(message);
        } else {
            generateDataTask.execTask(message);
        }
    }
}
