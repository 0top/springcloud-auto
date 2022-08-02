package top.zerotop.scallion.web.example.service;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    public String invokeExample(String param) {
        return "调用接口, param: " + param;
    }
}
