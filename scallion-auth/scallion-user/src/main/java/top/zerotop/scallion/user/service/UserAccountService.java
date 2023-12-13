package top.zerotop.scallion.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zerotop.scallion.user.domain.User;
import top.zerotop.scallion.user.domain.UserAccount;
import top.zerotop.scallion.user.mapper.UserAccountMapper;
import top.zerotop.scallion.user.mapper.UserMapper;

import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountMapper userAccountMapper;

    public List<UserAccount> listAllUserAccount() {
        return userAccountMapper.listAllUserAccount();
    }

    public UserAccount saveUserAccount(UserAccount userAccount) {
        int id = userAccountMapper.saveUserAccount(userAccount);
        return userAccountMapper.selectByPrimary(id);
    }
}
