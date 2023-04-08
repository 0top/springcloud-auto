package top.zerotop.scallion.task.common.manager;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import top.zerotop.scallion.task.common.domain.ScallionTask;

@Component
public class QuartzManager {
    @Autowired
    private SchedulerFactoryBean schedulerFactory;

    /**
     * 新增job
     */
    public void addQuartzJob(ScallionTask scallionTask, Class clazz) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(scallionTask.getTaskName(), scallionTask.getTaskGroup())
                    .withSchedule(CronScheduleBuilder.cronSchedule(scallionTask.getCronExp()))
                    .build();
            JobDetail jobDetail = JobBuilder.newJob(clazz)
                    .withIdentity(scallionTask.getTaskName(), scallionTask.getTaskGroup())
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 移除job
     */
    public void removeQuartzJob() {

    }
}
