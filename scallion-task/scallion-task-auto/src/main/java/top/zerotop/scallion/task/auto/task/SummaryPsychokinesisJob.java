package top.zerotop.scallion.task.auto.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

public class SummaryPsychokinesisJob implements Job {
    private RestTemplate remoteRestTemplate = ApplicationContextBeanUtils.getBean("remoteRestTemplate", RestTemplate.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
//            String url = "http://scallionallion-data-customer/data/execSummaryTask?param=1";
            String url = "http://scallion-web-psychokinesis/scallion/psychokinesis/task/summary";
            String result = CompletableFuture.supplyAsync(() -> {
                String res = remoteRestTemplate.getForObject(url, String.class);
                return res;})
                    .get();
            System.out.printf("调用数据汇总任务: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
