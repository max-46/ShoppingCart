/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.shoppingcart;

import java.math.BigDecimal;

/**
 *
 * @author max
 */
public class Product {

    private static int idNum = 0;
    private final int id;
    private String name;
    private int price;
    private int numAvailable;

    public Product(String name, int price, int numAvailable) {
        this.id = idNum++;
        this.name = name;
        this.price = price;
        this.numAvailable = numAvailable;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

    @Override
    public String toString() {
        return "Product: " + "id=" + id + ", name=" + name + ", price=£"
                + new BigDecimal(price / 100).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

}
