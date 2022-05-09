package service;

import entity.User;

public interface UserService {
    //登录
    boolean login(User user);
    //获取当前用户信息
    User getCurrentUser();
}
