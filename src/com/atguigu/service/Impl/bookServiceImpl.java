package com.atguigu.service.Impl;

import com.atguigu.dao.BookDaoImpl;
import com.atguigu.dao.impl.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class bookServiceImpl implements BookService {
    BookDao bd = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bd.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
    bd.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
    bd.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bd.queryBookById(id);
    }

    @Override
    public List<Book> queryForList() {
        return bd.queryForList();
    }

    /**
     * 根据当前页码和每页的数据个数求得整个Page类以便web层调用
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<Book>();
        page.setPage_size(pageSize);
        Integer pageTotalCount = bd.querySingle();
        page.setPageTotalCount(pageTotalCount);
        //总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageTo(pageNo);
        //当前页的列表值
        //当前页数据的开始索引
        Integer begin=(page.getPageTo()-1)*pageSize;
        page.setItems(bd.queryForPageItems(begin,pageSize));

return page;

    }
    public Page<Book> indexByPrice(Integer pageNo, Integer pageSize,int min,int max){
            Page<Book> page = new Page<Book>();
            page.setPage_size(pageSize);
        Integer pageTotalCount = bd.querySingleByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);//添加方法 获取记录数
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
            page.setPageTo(pageNo);
        //当前页数据的开始索引
        Integer begin=(page.getPageTo()-1)*pageSize;
        page.setItems(bd.queryForPageItemsByPrice(min,max,begin,pageSize));

        return page;
    }
}
