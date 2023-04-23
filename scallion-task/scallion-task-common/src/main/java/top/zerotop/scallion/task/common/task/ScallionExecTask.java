package top.zerotop.scallion.task.common.task;

import top.zerotop.scallion.task.common.domain.ScallionTask;
import top.zerotop.scallion.task.common.domain.ScallionTaskContext;

import java.util.List;

public interface ScallionExecTask {
    /**
     * 执行任务
     * @param scallionTaskContext
     */
    void execTask(ScallionTaskContext scallionTaskContext);

    /**
     * 获取执行任务列表
     * @return
     */
    List<ScallionTask> getExecTaskList();
}
