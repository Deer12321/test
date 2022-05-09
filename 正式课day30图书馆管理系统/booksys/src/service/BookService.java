package service;

import entity.Book;

import java.util.List;

public interface BookService {
    //获取所有图书列表
    List<Book> findAll();
    //条件查询
    List<Book> findByCondition(Book book);
    //添加图书
    void addbook(Book book) throws Exception;
    //借阅图书
    void jieyuebook(int id) throws Exception;
    //修改图书
    void xiugaibook(int id) throws Exception;
    //下载图书
    void xiazai() throws Exception;
}
