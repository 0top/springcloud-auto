package top.zerotop.scallion.user.mapper;

import top.zerotop.scallion.user.domain.UserAccount;

import java.util.List;

public interface UserAccountMapper {
    List<UserAccount> listAllUserAccount();

    UserAccount selectByPrimary(int id);

    int saveUserAccount(UserAccount userAccount);

}
