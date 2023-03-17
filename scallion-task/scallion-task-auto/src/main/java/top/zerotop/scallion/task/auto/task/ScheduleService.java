package top.zerotop.scallion.task.auto.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import top.zerotop.scallion.task.auto.entity.ScheduleTask;
import top.zerotop.scallion.task.auto.mapper.ScheduleTaskMapper;

import java.util.List;

@Component
public class ScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    @Autowired
    private ScheduleTaskMapper scheduleTaskMapper;

    public List<ScheduleTask> listTask() {
        return scheduleTaskMapper.listAll();
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void echoScheduleTask() {
        try {
            List<ScheduleTask> list = scheduleTaskMapper.listAll();

            if (!CollectionUtils.isEmpty(list)) {
                logger.debug("打印日志。。。");

                list.forEach(System.out::println);
            } else {
                System.out.println("目前无定时任务");
            }
            logger.debug("打印日志。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
