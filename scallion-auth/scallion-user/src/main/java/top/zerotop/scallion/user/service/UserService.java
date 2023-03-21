package top.zerotop.scallion.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zerotop.scallion.user.domain.User;
import top.zerotop.scallion.user.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> listAllUser() {
        return userMapper.listAllUser();
    }

    public User saveUser(User user) {
        int id = userMapper.saveUser(user);
        return userMapper.selectByPrimary(id);
    }
}
