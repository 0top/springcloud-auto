package top.zerotop.scallion.task.auto.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.zerotop.scallion.task.auto.entity.ScheduleTask;
import top.zerotop.scallion.task.auto.task.ScheduleService;
import top.zerotop.scallion.task.common.domain.ScallionTask;
import top.zerotop.scallion.task.common.manager.QuartzManager;

import java.util.List;

import static top.zerotop.scallion.task.auto.enums.TaskGroup.TASK_SCHEDULE;

@Component
public class InitScallionTask implements CommandLineRunner {
    @Autowired
    private QuartzManager quartzManager;
    @Autowired
    private ScheduleService scheduleService;

    @Override
    public void run(String... args) throws Exception {
        List<ScheduleTask> scheduleTaskList = scheduleService.listTask();

        for (ScheduleTask scheduleTask : scheduleTaskList) {
            if (!scheduleTask.isDataStatus()) {
                continue;
            }
            ScallionTask scallionTask = new ScallionTask();
            scallionTask.setTaskName(scheduleTask.getTaskName());
            scallionTask.setTaskGroup(TASK_SCHEDULE.name());
            scallionTask.setCronExp(scheduleTask.getCron());
            Class clazz = Class.forName("top.zerotop.scallion.task.auto." + scheduleTask.getTaskService());
            quartzManager.addQuartzJob(scallionTask, clazz);

            System.out.printf("======新增任务: " + scallionTask.getTaskName());

        }
    }
}
