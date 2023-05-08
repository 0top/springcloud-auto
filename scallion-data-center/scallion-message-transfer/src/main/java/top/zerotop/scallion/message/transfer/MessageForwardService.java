package top.zerotop.scallion.message.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import top.zerotop.common.task.TaskMessage;
import top.zerotop.scallion.message.transfer.domain.ForwardMessage;
import top.zerotop.scallion.message.transfer.message.RabbitMqPublish;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
public class MessageForwardService {
    @Autowired
    private RestTemplate remoteRestTemplate;
    @Autowired
    private RabbitMqPublish rabbitMqPublish;

    public void forward(TaskMessage taskMessage) {
        publishRabbitMqMessage(taskMessage);
    }

    /**
     * 发布rabbitmq消息
     * @param map
     */
    private void publishRabbitMqMessage(TaskMessage taskMessage) {
        rabbitMqPublish.publishTask(taskMessage);
    }

    /**
     * 转发rest消息
     * @param map
     */
    public void publishRestMessage(Map<String, Object> map) {
        try {
            String url = String.format("http://%s/%s", map.get("target"), map.get("url"));
            String result = CompletableFuture.supplyAsync(() -> {
                        String res = remoteRestTemplate.postForObject(url, map, String.class);
                        return res;})
                    .get();

            System.out.println("调用数据汇总任务: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
