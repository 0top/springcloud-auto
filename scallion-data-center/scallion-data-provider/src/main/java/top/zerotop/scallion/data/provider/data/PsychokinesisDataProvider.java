package top.zerotop.scallion.data.provider.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class PsychokinesisDataProvider {
    @Autowired
    private RestTemplate remoteRestTemplate;

    static Random random = new Random();

//    @Scheduled(cron = "0/30 * * * * ?")
    public void generateSentence() {
        System.out.println("开始执行生成任务======》 psychokinesis generate sentence");
        String time = LocalTime.now().toString();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> sentenceMap = new HashMap<String, Object>();
            sentenceMap.put("userId", "user"+random.nextInt(100));
            sentenceMap.put("sentence", "加油_"+time+"_"+i);

            try {
//            String url = "http://scallionallion-data-customer/data/execSummaryTask?param=1";
                String url = "http://scallion-web-psychokinesis/scallion/psychokinesis/sentence/save";
                String result = CompletableFuture.supplyAsync(() -> {
                            String res = remoteRestTemplate.postForObject(url, sentenceMap, String.class);
                            return res;})
                        .get();
                System.out.printf("调用数据生成任务: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
