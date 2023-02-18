package top.zerotop.common.rest;

public class ResponseUtil {
    public static Response ok() {
        return new Response<>(200, "", null);
    }

    public static Response ok(Object body) {
        return new Response<>(200, "", body);
    }

    public static Response error(Integer code, String msg, Object body) {
        return new Response<>(code, msg, body);
    }
}
