package com.wnn.bs.bean;

public class CartItem {
    private Book book;
    private int count;
    //通过计算得到
//    private double amount;

    public Book getBook() {
        return book;
    }

    public void setBook(final Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount( int count) {
        this.count = count;
    }

    public double getAmount() {
        double amount = book.getPrice()*getCount();
        return amount;
    }

  /*  public void setTotalAmount(final double totalAmount) {
        this.totalAmount = totalAmount;
    }*/


}
