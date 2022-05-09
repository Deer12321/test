package main;

import entity.Book;
import entity.User;
import service.BookService;
import service.UserService;
import service.impl.impl.BookServiceImpl;
import service.impl.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//表现层
public class BookSystem {
    //创建Scanner对象
    private static Scanner scanner = new Scanner(System.in);
    //创建UserService
    private static UserService userService = new UserServiceImpl();
    //创建BookService
    private static BookService bookService = new BookServiceImpl();
    public static void main(String[] args) throws Exception {
        //进入登录页面
        login();
        //获取当前用户
        User currentUser = userService.getCurrentUser();
        while (true){
            //进入主页面
            String option = showMain();
            //根据不同选择,实现不同功能
            switch (option){
                case "1":
                    //显示图书列表
                    booklist();
                    break;
                case "2":
                    //查询图书
                    findBook();
                    break;
                case "3":
                    if(currentUser.getRole()==0){
                        //管理员
                        System.out.println("添加图书");
                        addbook();
                    }else if(currentUser.getRole()==1){
                        //普通用户
                        System.out.println("借阅图书");
                        jieyuetushu();
                    }
                    break;
                case "4":
                    if(currentUser.getRole()==0){
                        //管理员
                        System.out.println("修改图书");
                        xiugaibook();
                    }else if(currentUser.getRole()==1){
                        //普通用户
                        System.out.println("下载电子图书");
                        xaizai();
                    }
                    break;
                case "5":
                    System.out.println("退出系统");
                    System.exit(0);
                    break;
                default:
                    System.out.println("选择有误,请重新选择!");
                    break;
            }
        }
    }
    //下载电子图书
    public static void xaizai() throws Exception{
        System.out.println("=========下载图书=========");
        //掉用service层
        bookService.xiazai();
        Thread.sleep(50);
    }
    //修改图书
    public static void xiugaibook() throws Exception {
        System.out.println("=========修改图书==========");
        booklist();
        System.out.println("请输入要修改的图书id：");
        int id = scanner.nextInt();
        //调用service层
        bookService.xiugaibook(id);
        System.out.println("修改成功！");
    }
    //借阅图书
    public static void jieyuetushu() throws Exception {
        System.out.println("=======借阅图书=======");
        booklist();
        System.out.println("请输入要借阅的图书id：");
        int id = scanner.nextInt();
        //调用service层
        bookService.jieyuebook(id);

    }
    //添加图书
    public static void addbook() throws Exception {
        System.out.println("===========添加图书===============");
        System.out.println("请输入图书id：");
        int id = scanner.nextInt();
        System.out.println("请输入书名：");
        String shuming = scanner.next();
        System.out.println("请输入作者：");
        String author = scanner.next();
        System.out.println("请输入价格：");
        int jiage = scanner.nextInt();
        System.out.println("请输入库存：");
        int kucun = scanner.nextInt();
        System.out.println("请输入库存状态：");
        String zhuangtai = scanner.next();
        Book book = new Book(id, shuming, author, jiage, kucun, zhuangtai);
        //调用service层
        bookService.addbook(book);
        System.out.println("借阅成功！");
    }

    //查询图书
    public static void findBook(){
        System.out.println("=================查询图书====================");
        System.out.println("a 根据图书名查询  b 根据作者查询");
        String option = scanner.next();//获取用户选择
        //定义集合保存查询结果
        List<Book> books = null;
        //定义变量,封装到查询条件
        Book book = new Book();
        if(option.equalsIgnoreCase("a")){
            //如果选择a,根据图书名查询
            System.out.println("请输入图书名:");
            String name = scanner.next();//查询条件
            book.setName(name);
        }else if(option.equalsIgnoreCase("b")){
            //如果选择b,根据作者查询
            System.out.println("请输入作者:");
            String author = scanner.next();//查询条件
            book.setAuthor(author);
        }
        books = bookService.findByCondition(book);//调用service层
        //展示查询结果:
        System.out.println("编号\t图书名字\t图书作者\t图书价格\t图书库存\t状态");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    //显示所有图书
    public static void booklist(){
        //获取所有图书:调用service层
        List<Book> all = bookService.findAll();
        //显示所有图书
        System.out.println("=================图书列表====================");
        System.out.println("编号\t图书名字\t图书作者\t图书价格\t图书库存\t状态");
        for (Book book : all) {
            System.out.println(book);
        }

    }


    //主页
    public static String showMain(){
        System.out.println("=================欢迎进入图书管理系统主界面====================");
        System.out.println("1 图书列表");
        System.out.println("2 查询图书");
        //获取当前用户信息
        User currentUser = userService.getCurrentUser();
        if(currentUser.getRole()==0){
            //如果是管理员
            System.out.println("3 添加图书");
            System.out.println("4 修改图书");
        }else if(currentUser.getRole()==1){
            //如果是普通用户
            System.out.println("3 借阅图书");
            System.out.println("4 下载电子图书");
        }
        System.out.println("5 退出图书");
        System.out.println("请选择:");
        String option = scanner.next();
        return option;
    }

    //登录页面
    public static void login(){
        while (true){
            System.out.println("=================欢迎来到图书管理系统====================");
            System.out.println("请输入账号:");
            String username = scanner.next();//账号
            System.out.println("请输入密码:");
            String password = scanner.next();//密码
            //封装用户信息
            User user = new User(username, password);
            //实现登录功能
            boolean login = userService.login(user);
            //判断
            if(login){
                System.out.println("======登录成功!");
                return;//不用再登录
            }else{
                System.out.println("------登录失败,请重新登录!");
            }
        }
    }
}
