package top.zerotop.scallion.message.transfer.receiver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.common.task.TaskMessage;
import top.zerotop.scallion.message.transfer.MessageForwardService;

@RestController
@RequestMapping(value = "/accept")
public class ReceiverController {
    @Autowired
    private MessageForwardService messageForwardService;

    @PostMapping(value = "/task")
    private Response<Boolean> execTask(@RequestBody TaskMessage taskMessage) {
        System.out.println(taskMessage.toString());
        messageForwardService.forward(taskMessage);
        return ResponseUtil.ok(true);
    }

}
