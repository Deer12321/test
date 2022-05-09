package dao;

import entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookDao {
    //获取所有图书
    List<Book> findAll();
    //条件查询
    List<Book> findByCondition(Book book);//book:封装查询条件
    //添加图书
    void addbook(Book book) throws IOException, Exception;
    //借阅图书
    void jieyuetushu(int id) throws IOException, Exception;
    //修改图书
    void xiugaibook(int id) throws Exception;
    //下载
    void xiazai() throws Exception;
}
