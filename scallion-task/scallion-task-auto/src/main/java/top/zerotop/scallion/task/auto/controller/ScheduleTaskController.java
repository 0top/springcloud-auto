package top.zerotop.scallion.task.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.task.auto.job.ScheduleService;

@RestController
@RequestMapping(value = "/scheduleTask")
public class ScheduleTaskController {
    @Autowired
    ScheduleService scheduleService;

//    @GetMapping(value = "/list")
//    private Response listScheduleTask() {
//        return ResponseUtil.ok(scheduleService.listTask());
//    }

}
