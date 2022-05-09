package utils;

import java.io.*;

//工具类:一般是静态方法,方便调用
public class FileUtils {
    //获取user.properties文件的连接:输入流
    public static InputStream getUser(){
        //类加载器
        return FileUtils.class.getClassLoader().getResourceAsStream("user.properties");
    }

    //添加图书和booklist.txt建立连接（输出流）
    public static OutputStream addBooklist(){
        File file = new File("D:\\Java自学\\乐学\\作业\\正式课\\正式课day30图书馆管理系统\\booksys\\src\\booklist.txt");
        try {
            return new FileOutputStream(file);
        }catch (Exception e){
            System.out.println("---booklist.txt连接失败（输出流）--");
            e.printStackTrace();
        }
        return null;
    }

    //和booklist.txt建立连接(输入流)
    public static InputStream getBooklist(){
        File file = new File("D:\\Java自学\\乐学\\作业\\正式课\\正式课day30图书馆管理系统\\booksys\\src\\booklist.txt");
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("---booklist.txt连接失败(输入流)");
            e.printStackTrace();
        }
        return null;
    }
}
