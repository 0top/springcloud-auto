package top.zerotop.scallion.task.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.task.auto.task.ScheduleService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/scheduleTask")
public class ScheduleTaskController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/list")
    private Response listScheduleTask() {

        try {
            String url = "http://scallion-data-customer/data/execSummaryTask?param=1";
            String result = CompletableFuture.supplyAsync(() -> {return restTemplate.getForObject(url, String.class);}).get();
            System.out.printf("调用数据汇总任务: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseUtil.ok(scheduleService.listTask());
    }

}
