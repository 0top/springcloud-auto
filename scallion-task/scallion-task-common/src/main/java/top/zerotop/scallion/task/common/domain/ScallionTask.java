package top.zerotop.scallion.task.common.domain;

public class ScallionTask {
    private long id;

    private String taskName;

    private String taskGroup;

    private String cronExp;

    private String execService;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCronExp() {
        return cronExp;
    }

    public void setCronExp(String cronExp) {
        this.cronExp = cronExp;
    }

    public String getExecService() {
        return execService;
    }

    public void setExecService(String execService) {
        this.execService = execService;
    }
}
