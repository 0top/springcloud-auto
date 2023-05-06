package top.zerotop.scallion.message.transfer.receiver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.message.transfer.MessageForwardService;

import java.util.Map;

@RestController
@RequestMapping(value = "/accept")
public class ReceiverController {
    @Autowired
    private MessageForwardService messageForwardService;

    @PostMapping(value = "/task")
    private Response<Boolean> execTask(@RequestBody Map<String, Object> params) {
        params.forEach((k, v) -> {
            System.out.println(k + "  " + v);
        });
        messageForwardService.forward(params);
        return ResponseUtil.ok(true);
    }

}
