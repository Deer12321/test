package dao.impl.impl;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
import dao.BookDao;
import entity.Book;
import jdk.nashorn.internal.ir.CallNode;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDaoImpl implements BookDao {
    //获取所有图书
    @Override
    public List<Book> findAll() {
        // 获取连接:字节流
        InputStream booklist = FileUtils.getBooklist();
        //一行一行读
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(booklist));//字符流
        String line = "";//保存每次读取内容
        //创建List<Book>,保存查询出来的所有数据
        ArrayList<Book> books = new ArrayList<>();
        try{
            while ((line=bufferedReader.readLine())!=null){//读一行
                //解析数据封装到Book对象中
                //第一行:  1 javaSE lhj 22.2 20 下架
                String[] s = line.split(" ");//[1,javaSE,...]
                //封装到book对象中
                Book book = new Book(Integer.valueOf(s[0]), s[1], s[2], Double.valueOf(s[3]), Integer.valueOf(s[4]), s[5]);
                //保存到list集合中
                books.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    //条件查询
    @Override
    public List<Book> findByCondition(Book book) {//book:封装查询条件
        //获取所有的图书
        List<Book> all = findAll();
        //定义集合,保存所有查询数据
        ArrayList<Book> books = new ArrayList<>();
        //判断
        //遍历所有图书
        for(Book b: all){
            //根据图书名查询
            if(book.getName()!=null){
                if(b.getName().equals(book.getName())){
                    //有,保存起来
                    books.add(b);
                }
            }else if(book.getAuthor()!=null){
                //根据作者
                //判断遍历出来的书的名字和查询的书的名字是否一样
                //b.getAuthor():文件中的作者
                //book.getAuthor():要查询的作者
                if(b.getAuthor().equals(book.getAuthor())){
                    //有,保存起来
                    books.add(b);
                }
            }
        }
        return books;
    }

    @Override
    public void addbook(Book book) throws Exception {
        //获取所有图书
        List<Book> all = findAll();
        all.add(book);
        //建立连接，字节流
        OutputStream bookout = FileUtils.addBooklist();
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(bookout));
        String line = "";//保存book对象内容,一行一行写
        try{
            for (Book b : all) {
                line = b.getId()+" "+b.getName()+" "+b.getAuthor()+" "+b.getPrice()+" "+b.getStock()+" "+b.getState()+"\n";
                buf.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            buf.close();
        }
    }

    @Override
    public void jieyuetushu(int id) throws Exception {
        List<Book> all = findAll();
        for (Book book : all) {
            if(book.getId()==id){
                book.setStock(book.getStock()-1);
            }
        }
        OutputStream bookout = FileUtils.addBooklist();
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(bookout));
        String line = "";//保存book对象内容,一行一行写
        try{
            for (Book b : all) {
                line = b.getId()+" "+b.getName()+" "+b.getAuthor()+" "+b.getPrice()+" "+b.getStock()+" "+b.getState()+"\n";
                buf.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            buf.close();
        }
    }

    @Override
    public void xiugaibook(int id) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Book> all = findAll();
        for (Book book : all) {
            if(book.getId()==id){
                System.out.println("请输入修改后的图书名：");
                String name = sc.next();
                book.setName(name);
                System.out.println("请输入修改后的作者：");
                String author = sc.next();
                book.setAuthor(author);
                System.out.println("请输入修改后的价格：");
                Double jiage = sc.nextDouble();
                book.setPrice(jiage);
                System.out.println("请输入修改后的库存：");
                int kucun = sc.nextInt();
                book.setStock(kucun);
                System.out.println("请输入修改后的状态：");
                String zhuangtai = sc.next();
                book.setState(zhuangtai);
            }
        }
        OutputStream bookout = FileUtils.addBooklist();
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(bookout));
        String line = "";//保存book对象内容,一行一行写
        try{
            for (Book b : all) {
                line = b.getId()+" "+b.getName()+" "+b.getAuthor()+" "+b.getPrice()+" "+b.getStock()+" "+b.getState()+"\n";
                buf.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            buf.close();
        }
    }
    @Override
    public void xiazai() throws Exception{
       //建立连接，获取ebook文件里所有的文件
        File file = new File("D:\\Java自学\\乐学\\作业\\正式课\\正式课day30图书馆管理系统\\booksys\\src\\ebook");
        File[] files = file.listFiles();
        for (File f : files) {
             //创建字符输入流对象
            FileReader fileReader = new FileReader(f);
            //创建字符输入缓冲流
            BufferedReader buf = new BufferedReader(fileReader);
            String content = "";
            while((content=buf.readLine())!=null){
                System.out.println(f.getName());
            }
            buf.close();
        }
        System.out.println("请输入想要下载的图书名字，用逗号（,）隔开");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] xiazai = s.split(",");
         for (String x : xiazai) {
            new Thread(){
                @Override
                public void run() {
                    try{
                        String path = "D:\\Java自学\\乐学\\作业\\正式课\\正式课day30图书馆管理系统\\booksys\\src\\download";
                        System.out.println("线程"+x+"启动下载！");
                        File f = new File(file, x);
                        File fout = new File(path,x);
                        FileReader fileReader = new FileReader(f);
                        BufferedReader reader = new BufferedReader(fileReader);
                        FileWriter fileWriter = new FileWriter(fout);
                        BufferedWriter buf = new BufferedWriter(fileWriter);
                        String out = "";
                        while((out=reader.readLine())!=null){
                            buf.write(out);
                        }
                        buf.close();
                        reader.close();
                        System.out.println("线程"+x+"下载完成");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

}