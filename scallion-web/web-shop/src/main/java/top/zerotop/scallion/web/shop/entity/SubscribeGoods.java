package top.zerotop.scallion.web.shop.entity;

public class SubscribeGoods extends Goods {
    private String token;

    private String subscribe;

    private String description;

    private String detail;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
