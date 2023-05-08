package top.zerotop.scallion.message.transfer.domain;

import java.io.Serializable;
import java.util.Map;

public class ForwardMessage implements Serializable {
    private String target;

    private String url;

    private String taskType;

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

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
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
        return "ForwardMessage{" +
                "target='" + target + '\'' +
                ", url='" + url + '\'' +
                ", taskType='" + taskType + '\'' +
                ", params=" + params +
                '}';
    }
}
