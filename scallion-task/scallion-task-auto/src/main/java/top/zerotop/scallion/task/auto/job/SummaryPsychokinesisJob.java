package top.zerotop.scallion.task.auto.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import top.zerotop.scallion.task.common.domain.ScallionTask;
import top.zerotop.scallion.task.common.domain.ScallionTaskContext;
import top.zerotop.scallion.task.common.domain.ScallionTaskExecuteContext;
import top.zerotop.scallion.task.common.task.ApplicationContextBeanUtils;
import top.zerotop.scallion.task.common.task.ScallionExecTask;

import java.util.List;

public class SummaryPsychokinesisJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ScallionExecTask scallionExecTask = ApplicationContextBeanUtils.getBean("scallionExecSummaryPsychokinesisTask", ScallionExecTask.class);
        scallionExecTask.execTask(new ScallionTaskExecuteContext());
    }
}
