package top.zerotop.scallion.web.shop.enums;

public enum GoodsTypeEnum {
    Type_Subscribe("订阅"),
    Type_Report("报告");

    GoodsTypeEnum(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }
}
