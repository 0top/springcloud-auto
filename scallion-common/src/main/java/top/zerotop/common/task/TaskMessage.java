package top.zerotop.common.task;

import top.zerotop.common.task.enums.TaskTypeEnum;

import java.io.Serializable;
import java.util.Map;

public class TaskMessage implements Serializable {
    private String target;

    private String url;

    private TaskTypeEnum taskType;

    private Map<String, Object> params;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TaskTypeEnum getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskTypeEnum taskType) {
        this.taskType = taskType;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "TaskMessage{" +
                "target='" + target + '\'' +
                ", url='" + url + '\'' +
                ", taskType=" + taskType +
                ", params=" + params +
                '}';
    }
}
