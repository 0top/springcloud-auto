package top.zerotop.scallion.task.common.domain;

public class ScallionTask {
    private long id;

    private String task;
    private String taskName;

    private String taskGroup;

    private String cronExpr;

    private String relayTask;

    private String execService;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getCronExpr() {
        return cronExpr;
    }

    public void setCronExpr(String cronExpr) {
        this.cronExpr = cronExpr;
    }

    public String getRelayTask() {
        return relayTask;
    }

    public void setRelayTask(String relayTask) {
        this.relayTask = relayTask;
    }

    public String getExecService() {
        return execService;
    }

    public void setExecService(String execService) {
        this.execService = execService;
    }
}
