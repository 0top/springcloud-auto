package top.zerotop.scallion.task.auto.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.zerotop.scallion.task.common.domain.ScallionTask;
import top.zerotop.scallion.task.common.domain.ScallionTaskContext;
import top.zerotop.scallion.task.common.task.ScallionExecTask;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service(value = "scallionExecSummaryPsychokinesisTask")
public class ScallionExecSummaryPsychokinesisTask implements ScallionExecTask {
    @Autowired
    private RestTemplate remoteRestTemplate;
    @Override
    public void execTask(ScallionTaskContext scallionTaskContext) {
        try {
//            String url = "http://scallionallion-data-customer/data/execSummaryTask?param=1";
            String url = "http://scallion-web-psychokinesis/scallion/psychokinesis/task/summary";
            String result = CompletableFuture.supplyAsync(() -> {
                        String res = remoteRestTemplate.getForObject(url, String.class);
                        return res;})
                    .get();

            System.out.println("调用数据汇总任务: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ScallionTask> getExecTaskList() {
        return null;
    }
}
