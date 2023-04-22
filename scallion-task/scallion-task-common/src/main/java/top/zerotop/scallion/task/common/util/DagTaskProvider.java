package top.zerotop.scallion.task.common.util;

import com.github.dexecutor.core.task.Task;
import com.github.dexecutor.core.task.TaskProvider;

public class DagTaskProvider<ScallionTask, Boolean> implements TaskProvider {
    @Override
    public Task<ScallionTask, Boolean> provideTask(Object o) {
        return null;
    }
}
