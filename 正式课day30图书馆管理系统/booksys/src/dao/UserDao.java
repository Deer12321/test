package dao;

import entity.User;

public interface UserDao {
    //查询用户:根据账号密码查询
    User findUserByUsernameAndPassword(User user);

}
