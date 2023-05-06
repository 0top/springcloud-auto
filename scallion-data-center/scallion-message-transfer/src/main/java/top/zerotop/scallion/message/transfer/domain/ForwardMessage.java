package top.zerotop.scallion.message.transfer.domain;

import java.util.Map;

public class ForwardMessage {
    private String target;

    private String url;

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
                ", params=" + params +
                '}';
    }
}
