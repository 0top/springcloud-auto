package top.zerotop.scallion.task.auto.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

public class SummaryPsychokinesisJob implements Job {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            String url = "http://scallion-data-customer/data/execSummaryTask?param=1";
            String result = CompletableFuture.supplyAsync(() -> {return restTemplate.getForObject(url, String.class);}).get();
            System.out.printf("调用数据汇总任务: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
