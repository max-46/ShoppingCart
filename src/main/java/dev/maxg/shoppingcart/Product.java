/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.shoppingcart;

/**
 *
 * @author max
 */
public class Product {
    
    private static int idNum = 0;
    private int id;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.id = idNum++;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
    
    
    
    
}
