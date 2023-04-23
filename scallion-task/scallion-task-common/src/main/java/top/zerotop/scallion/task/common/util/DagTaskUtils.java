package top.zerotop.scallion.task.common.util;

import com.github.dexecutor.core.DefaultDexecutor;
import com.github.dexecutor.core.DexecutorConfig;
import com.github.dexecutor.core.ExecutionConfig;
import top.zerotop.scallion.task.common.domain.ScallionTask;
import top.zerotop.scallion.task.common.domain.ScallionTaskComb;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DagTaskUtils {
    public void executeTask() {
        DexecutorConfig<ScallionTaskComb, String> dexecutorConfig = new DexecutorConfig<ScallionTaskComb, String>(ExecutorUtils.generateExecutorService(), new DagTaskProvider());
        DefaultDexecutor<ScallionTaskComb, String> dexecutor = new DefaultDexecutor<>(dexecutorConfig);
        ExecutionConfig executionConfig = new ExecutionConfig();
        dexecutor.execute(executionConfig);
    }

    /**
     * 添加依赖任务
     * @param scallionTasks
     * @param dexecutor
     */
    public void addTaskDependency(List<ScallionTask> scallionTasks, DefaultDexecutor<ScallionTask, String> dexecutor) {
        Map<String, ScallionTask> map = scallionTasks.stream().collect(Collectors.toMap(ScallionTask::getTask, v -> v, (o1, o2) -> o1));
        for (ScallionTask scallionTask : scallionTasks) {
           if (scallionTask.getRelayTask() != null) {
               dexecutor.addDependency(map.get(scallionTask.getRelayTask()), scallionTask);
           } else {
               dexecutor.addIndependent(scallionTask);
           }
        }
    }
}
