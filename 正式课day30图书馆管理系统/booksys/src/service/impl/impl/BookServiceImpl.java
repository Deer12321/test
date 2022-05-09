package service.impl.impl;

import dao.BookDao;
import dao.impl.impl.BookDaoImpl;
import entity.Book;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    //创建Dao层对象
    private BookDao bookDao = new BookDaoImpl();

    //获取所有图书列表
    @Override
    public List<Book> findAll() {
        //调用dao层
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByCondition(Book book) {
        //调用dao层
        return bookDao.findByCondition(book);
    }

    @Override
    public void addbook(Book book) throws Exception {
        //调用Dao层添加图书
        bookDao.addbook(book);
    }

    @Override
    public void jieyuebook(int id) throws Exception {
        bookDao.jieyuetushu(id);
    }

    @Override
    public void xiugaibook(int id) throws Exception {
        bookDao.xiugaibook(id);
    }

    @Override
    public void xiazai() throws Exception {
        bookDao.xiazai();
    }
}
