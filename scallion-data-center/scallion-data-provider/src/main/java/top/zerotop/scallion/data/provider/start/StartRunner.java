package top.zerotop.scallion.data.provider.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import top.zerotop.scallion.data.provider.data.RabbitMqSender;
import top.zerotop.scallion.data.provider.netty.NettyHandler;
import top.zerotop.scallion.data.provider.netty.NettyServer;

import java.util.concurrent.Executors;

@Component
public class StartRunner implements CommandLineRunner {
    @Autowired
    private RabbitMqSender mqSender;
    @Autowired
    private NettyServer nettyServer;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
//        mqSender.send();

        Executors.newSingleThreadExecutor().submit(() -> nettyServer.start());
        Thread socket = new Thread(() -> {
            int count = 0;
            while (count < 500) {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                System.out.println(String.format("socket msg: 最新通知:%s", count));
                NettyHandler.sendAllMessages(null, "socket msg: 最新通知" + count);
                count++;
            }
        });
        System.out.println("socket thread start....");
        socket.start();

        redisTemplate.opsForValue().set("firstKey", "hello world");
        System.out.println(redisTemplate.opsForValue().get("firstKey"));
    }
}
