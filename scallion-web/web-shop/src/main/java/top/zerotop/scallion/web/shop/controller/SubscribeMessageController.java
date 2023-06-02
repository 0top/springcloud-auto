package top.zerotop.scallion.web.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping(value = "/subscribe")
public class SubscribeMessageController {

    @GetMapping(value = "/list")
    private Response<String> listSentence() {
        return ResponseUtil.ok("获取订阅链接");
    }

}
