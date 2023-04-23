package top.zerotop.scallion.task.common.domain;

public class ScallionTaskComb {
    private ScallionTaskContext scallionTaskContext;

    private ScallionTask scallionTask;

    public ScallionTask getScallionTask() {
        return scallionTask;
    }

    public void setScallionTask(ScallionTask scallionTask) {
        this.scallionTask = scallionTask;
    }

    public ScallionTaskContext getScallionTaskContext() {
        return scallionTaskContext;
    }

    public void setScallionTaskContext(ScallionTaskContext scallionTaskContext) {
        this.scallionTaskContext = scallionTaskContext;
    }
}
