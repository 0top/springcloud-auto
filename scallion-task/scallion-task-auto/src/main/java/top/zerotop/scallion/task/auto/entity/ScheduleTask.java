package top.zerotop.scallion.task.auto.entity;

import java.io.Serializable;

public class ScheduleTask implements Serializable {
    private int id;

    private String taskId;

    private String taskName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "ScheduleTask{" +
                "id=" + id +
                ", taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
