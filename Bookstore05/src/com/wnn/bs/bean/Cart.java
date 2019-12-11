package com.wnn.bs.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<String,CartItem> map = new HashMap<>();
//    private int totalCount;
//    private double totalAmount;

    public List<CartItem> getCartItems() {
        return new ArrayList<>(map.values());
    }

    //计算购物项总数量
    public int getTotalCount() {
        int count = 0;
        List<CartItem> cartItems = getCartItems();
        for (CartItem cartItem : cartItems) {
            int count1 = cartItem.getCount();
            count+=count1;
        }

        return count;
    }

    //计算购物项总多金额
    public double getTotalAmount() {
        double amount = 0;
        List<CartItem> cartItems = getCartItems();
        for (CartItem cartItem : cartItems) {
            double amount1 = cartItem.getAmount();
            amount+=amount1;
        }
        return amount;
    }

    //向购物车中添加购物项
    public void addBookToCart(Book book){
        //先根据bookid从购物车中查找图书
        CartItem cartItem = map.get(book.getId() + "");
        if(cartItem!=null){
            //找到，则增加数据，默认增加1本
            int count = cartItem.getCount();
            cartItem.setCount(++count);
        }else {
            //没找到，则是第1次增加图书，数量设置1
            cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setCount(1);
            map.put(book.getId()+"",cartItem);
        }
    }
    //删除购物项
    public void deleteCartItemBybookid(String bookid){
        map.remove(bookid);
    }
    //修改购物项数量
    public int totalCount(){
        List<CartItem> cartItems = getCartItems();
        int count = 0;
        for (CartItem cartItem : cartItems) {
            int count1 = cartItem.getCount();
            count+=count1;
        }
        return count;
    }
    //清空购物车
    public void clearCart(){
        map.clear();
    }

    //修改图书数量
    public void updateCountByBookid(String bookid,int count){
        CartItem cartItem = map.get(bookid);
        cartItem.setCount(count);
    }

}
