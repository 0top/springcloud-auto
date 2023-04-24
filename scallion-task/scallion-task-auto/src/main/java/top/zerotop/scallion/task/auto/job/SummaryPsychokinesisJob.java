package top.zerotop.scallion.task.auto.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.client.RestTemplate;
import top.zerotop.common.rest.Response;
import top.zerotop.scallion.task.common.domain.ScallionTask;
import top.zerotop.scallion.task.common.domain.ScallionTaskContext;
import top.zerotop.scallion.task.common.task.ApplicationContextBeanUtils;
import top.zerotop.scallion.task.common.task.ScallionExecTask;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SummaryPsychokinesisJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        ScallionExecTask scallionExecTask = ApplicationContextBeanUtils.getBean("scallionExecSummaryPsychokinesisTask", ScallionExecTask.class);
//        scallionExecTask.execTask(new ScallionTaskContext() {
//            @Override
//            public List<ScallionTask> getTaskList() {
//                return null;
//            }
//        });

        RestTemplate remoteRestTemplate = ApplicationContextBeanUtils.getBean("remoteRestTemplate", RestTemplate.class);
        try {
//            String url = "http://scallionallion-data-customer/data/execSummaryTask?param=1";
            String url = "http://scallion-web-psychokinesis/scallion/psychokinesis/task/summary";
            String result = CompletableFuture.supplyAsync(() -> {
                        Response res = remoteRestTemplate.getForObject(url, Response.class);
                        return res.getMsg();})
                    .get();
            System.out.printf("调用数据汇总任务: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
