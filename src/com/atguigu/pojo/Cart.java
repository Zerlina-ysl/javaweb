package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.*;

//使用session域直接在类中写方法 因此不使用泛型
public class Cart{


    private HashMap<Integer,CartItems> items = new LinkedHashMap<Integer,CartItems>();

    public Cart() {};

    @Override
    public String toString() {
        return "Cart{" +
                "totalPrice=" + getTotalPrice() +
                ", totalCount=" + getTotalCount() +
                ", items=" + items +
                '}';
    }

    public BigDecimal getTotalPrice() {
         BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItems> entry:items.entrySet()){
           totalPrice= totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    public Integer getTotalCount() {
         Integer totalCount = 0;
     for(Map.Entry<Integer,CartItems> entry:items.entrySet()){
         totalCount+= entry.getValue().getCount();     }
     return totalCount;
    }




    public HashMap<Integer, CartItems> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, CartItems> items) {
        this.items = items;
    }

    /**
     * 在购物车内添加项目
     * @param item
     */
    public void addItem(CartItems item){
        //验证项目是否存在 由集合改为哈希map
        CartItems item1 = items.get(item.getId());
        if(item1 == null){//不存在
            items.put(item.getId(),item);
        }else{//存在 数量增加 总金额增加
            item1.setCount(item1.getCount()+item.getCount());
            item1.setTotalPrice(item1.getTotalPrice().add(item.getTotalPrice()));
        }

    }

    /**
     * 删除购物车中的项目
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clearItem(){
        items.clear();//清空集合

}
public void updateItem(int id,int count){
    CartItems item = items.get(id);
    item.setCount(count);


}

}
