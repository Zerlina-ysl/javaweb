package com.atguigu.dao;

import com.atguigu.dao.impl.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    /**
     * 操作成功返回行数，失败返回-1
     * @param book
     * @return
     */
    public int addBook(Book book) {
        String sql = "insert into t_book(id,name,author,price,sales,stock,img_path  )values (?,?,?,?,?,?,?) ";
        return update(sql,book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgpath());

    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    public int updateBook(Book book) {
        String sql = "update  t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgpath(),book.getId());

    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book where id = ?";
        return queryForOne(sql,Book.class,id);
    }

    @Override
    public List<Book> queryForList() {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book";

      return   queryForList(sql,Book.class);

    }

    @Override
    public Integer querySingle() {
        String sql = "select count(*) from t_book";
        Number number = (Number)queryForSingleValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select id,name,author,price,sales,stock,img_path  from t_book limit ?,?";

        return queryForList(sql,Book.class,begin,pageSize);
    }

    @Override
    public Integer querySingleByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price  between ? and ?";
            Number number =(Number) queryForSingleValue(sql,min,max);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int min, int max, Integer begin, Integer pageSize) {
        String sql = "select id,name,author,price,sales,stock,img_path  from t_book where price between ? and ? limit ?,?";
        return queryForList(sql,Book.class,min,max,begin,pageSize);
    }
}
