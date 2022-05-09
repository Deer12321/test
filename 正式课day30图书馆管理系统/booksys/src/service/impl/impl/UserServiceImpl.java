package service.impl.impl;

import dao.UserDao;
import dao.impl.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    //创建UserDao
    private UserDao userDao = new UserDaoImpl();
    //定义变量,保存当前用户信息
    private User currentUser ;
    //登录
    @Override
    public boolean login(User user) {
        //查询用户信息是否正确:调用dao层
        User u = userDao.findUserByUsernameAndPassword(user);
        //判断
        if(u!=null){
            //查询到了用户,说明账号密码正确,登录成功
            //保存当前用户信息
            currentUser = u;
            return true;
        }
        return false;//登录失败
    }

    //获取当前用户信息
    @Override
    public User getCurrentUser() {
        return currentUser;
    }
}
