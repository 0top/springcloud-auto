package top.zerotop.scallion.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.user.domain.User;
import top.zerotop.scallion.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    private Response listUser() {
        return ResponseUtil.ok(userService.listAllUser());
    }

    @PostMapping(value = "/save")
    private Response saveUser(@RequestBody User user) {
        return ResponseUtil.ok(userService.saveUser(user));
    }
}
