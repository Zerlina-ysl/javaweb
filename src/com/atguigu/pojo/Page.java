package com.atguigu.pojo;

import java.util.List;

/**
 * 分页的模型对象
 * T是传入的参数类
 * @param <T>
 */
public class Page<T> {

    public static final Integer PAGESIZE=4;
    private Integer PageTo;
    //当前页码
    //总页码
    private Integer PageTotal;
    //总记录数
    private Integer pageTotalCount;
    //每页的记录数
    private Integer page_size = PAGESIZE;
    //每页的所有记录
    private List<T> items;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(){}

    public static Integer getPAGESIZE() {
        return PAGESIZE;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Page(Integer pageTo, Integer pageTotal, Integer pageTotalCount, Integer page_size, List<T> items) {
        PageTo = pageTo;
        PageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.page_size = page_size;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "PageTo=" + PageTo +
                ", PageTotal=" + PageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", page_size=" + page_size +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageTo() {
        return PageTo;
    }


    public Integer getPageTotal() {
        return PageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        PageTotal = pageTotal;
    }
    public void setPageTo(Integer pageTo) {
        if (pageTo> PageTotal) {

            PageTo = PageTotal;
        }
       else  if(pageTo<1){
            PageTo=1;
        }else{
       PageTo = pageTo;
    }}

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }
}
