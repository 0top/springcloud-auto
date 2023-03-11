package top.zerotop.scallion.task.auto.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import top.zerotop.scallion.task.auto.entity.ScheduleTask;
import top.zerotop.scallion.task.auto.mapper.ScheduleTaskMapper;

import java.util.List;

@Component
public class ScheduleService {
    @Autowired
    private ScheduleTaskMapper scheduleTaskMapper;

    @Scheduled(cron = "0/5 * * * * ?")
    public void listTask() {
        try {
            List<ScheduleTask> list = scheduleTaskMapper.listAll();

            if (!CollectionUtils.isEmpty(list)) {
                list.forEach(System.out::println);
            } else {
                System.out.println("目前无定时任务");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
