package top.zerotop.scallion.task.common.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduleJob implements Job {
    private static Logger logger = LoggerFactory.getLogger(ScheduleJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("调用任务:" + jobExecutionContext.getJobDetail().getKey());
    }
}
