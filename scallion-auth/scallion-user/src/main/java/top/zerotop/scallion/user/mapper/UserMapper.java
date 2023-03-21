package top.zerotop.scallion.user.mapper;

import top.zerotop.scallion.user.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> listAllUser();

    User selectByPrimary(int id);

    int saveUser(User user);

}
