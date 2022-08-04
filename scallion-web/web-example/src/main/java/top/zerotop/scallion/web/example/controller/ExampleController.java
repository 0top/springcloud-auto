package top.zerotop.scallion.web.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zerotop.scallion.web.example.service.ExampleService;

@RestController
@RequestMapping(value = "/example")
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    @GetMapping(value = "/str")
    private String invokeExample(@RequestParam String param) {
        return exampleService.invokeExample(param);
    }

    @GetMapping(value = "/nacos")
    private String invokeNacosExample() {
        return "invoke nacos web example";
    }
}
