package top.zerotop.scallion.task.common.util;

import com.github.dexecutor.core.task.ExecutionResults;
import com.github.dexecutor.core.task.Task;
import com.github.dexecutor.core.task.TaskProvider;
import org.springframework.stereotype.Component;
import top.zerotop.scallion.task.common.domain.ScallionTask;
import top.zerotop.scallion.task.common.domain.ScallionTaskComb;
import top.zerotop.scallion.task.common.domain.ScallionTaskContext;
import top.zerotop.scallion.task.common.task.ApplicationContextBeanUtils;
import top.zerotop.scallion.task.common.task.ScallionExecTask;

public class DagTaskProvider<S, B> implements TaskProvider<ScallionTaskComb, Boolean>  {
    @Override
    public Task<ScallionTaskComb, Boolean> provideTask(ScallionTaskComb scallionTaskComb) {
        return new Task<ScallionTaskComb, Boolean>() {
            @Override
            public Boolean execute() {
                ScallionTask scallionTask = scallionTaskComb.getScallionTask();
                ScallionExecTask scallionExecTask = ApplicationContextBeanUtils.getBean(scallionTask.getExecService(), ScallionExecTask.class);
                try {
                    scallionExecTask.execTask(scallionTaskComb.getScallionTaskContext());
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public boolean shouldExecute(ExecutionResults<ScallionTaskComb, Boolean> parentResults) {
                return super.shouldExecute(parentResults);
            }
        };
    }
}
