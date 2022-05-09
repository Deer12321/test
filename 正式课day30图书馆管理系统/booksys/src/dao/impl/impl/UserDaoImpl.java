package dao.impl.impl;

import dao.UserDao;
import entity.User;
import utils.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    //根据账号和密码查询用户
    @Override
    public User findUserByUsernameAndPassword(User user) {
        //获取用户信息
        //(1)获取连接
        InputStream in = FileUtils.getUser();
        //(2)加载数据
        Properties properties = new Properties();
        try {
            properties.load(in);
            //(3)判断账号和密码是否正确
            if(properties.containsKey(user.getUsername())){//判断账号是否存在
                //(4)有这个用户,获取对应用户的密码
                String data = properties.getProperty(user.getUsername());//密码,角色
                String password = data.split(",")[0];//正确密码
                String role = data.split(",")[1];
                //(5)登录的密码和正确密码比较
                if(password.equals(user.getPassword())){
                   //查询到了
                    //封装用户信息
                    user.setRole(Integer.valueOf(role));
                    return user;//返回
                }
            }
        } catch (IOException e) {
            System.out.println("------加载用户信息失败!");
            e.printStackTrace();
        }
        return null;
    }
}
