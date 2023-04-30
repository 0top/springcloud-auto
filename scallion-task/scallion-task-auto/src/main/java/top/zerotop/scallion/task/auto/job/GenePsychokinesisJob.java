package top.zerotop.scallion.task.auto.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import top.zerotop.scallion.task.common.domain.ScallionTaskExecuteContext;
import top.zerotop.scallion.task.common.task.ApplicationContextBeanUtils;
import top.zerotop.scallion.task.common.task.ScallionExecTask;

public class GenePsychokinesisJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ScallionExecTask scallionExecTask = ApplicationContextBeanUtils.getBean("scallionExecGenePsychokinesisDataTask", ScallionExecTask.class);
        scallionExecTask.execTask(new ScallionTaskExecuteContext());
    }
}
