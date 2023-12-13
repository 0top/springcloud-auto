package top.zerotop.scallion.userAccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.user.domain.UserAccount;
import top.zerotop.scallion.user.service.UserAccountService;

@RestController
@RequestMapping(value = "/userAccount")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping(value = "/list")
    private Response listUserAccount() {
        return ResponseUtil.ok(userAccountService.listAllUserAccount());
    }

    @PostMapping(value = "/save")
    private Response saveUserAccount(@RequestBody UserAccount userAccount) {
        return ResponseUtil.ok(userAccountService.saveUserAccount(userAccount));
    }
}
