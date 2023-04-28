package top.zerotop.scallion.task.common.domain;

import java.util.List;

public interface ScallionTaskContext {
    /**
     * 获取任务列表
     * @return
     */
    List<ScallionTask> getTaskList();
}
