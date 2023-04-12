package top.zerotop.scallion.task.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.task.common.domain.ScallionTask;
import top.zerotop.scallion.task.common.job.ScheduleJob;
import top.zerotop.scallion.task.common.manager.QuartzManager;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private QuartzManager quartzManager;

    @GetMapping(value = "/exec")
    private Response execTask() {
        try {
            ScallionTask scallionTask = new ScallionTask();
            scallionTask.setTaskName("testtask");
            scallionTask.setTaskGroup("testGroup");
            scallionTask.setCronExp("0/10 * * * * ?");
            quartzManager.addQuartzJob(scallionTask, ScheduleJob.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseUtil.ok();
    }
}
