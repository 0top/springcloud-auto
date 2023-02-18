package top.zerotop.scallion.web.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.web.example.service.ExampleService;

@RestController
@RequestMapping(value = "/example")
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    @GetMapping(value = "/getstring")
    private Response invokeExample(@RequestParam String param) {
        return ResponseUtil.ok(exampleService.invokeExample(param));
    }

    @GetMapping(value = "/nacos")
    private Response invokeNacosExample() {
        return ResponseUtil.ok("invoke nacos web example");
    }
}
