/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class Cart {

    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public BigDecimal totalPrice() {
        int total = products.stream().map(Product::getPrice).reduce(0, (a, b) -> a + b);
        return new BigDecimal(total / 100).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public void printProductsAndInfo() {
        System.out.println("Your products are:");
        products.forEach(p -> {
            System.out.println(p);
        });
        System.out.println("Your total is £" + this.totalPrice());
    }

    public static void main(String[] args) {
        Cart c = new Cart();
        c.addProduct(new Product("iTunes Giftcard", 10000));
        int[] dimensions = new int[]{100, 5, 30};
        c.addProduct(new TangibleProduct("Sony TV", 12000, 2000, dimensions));
        Product p = new TangibleProduct("Anker Wireless Headphones", 8000, 500, new int[]{10, 10, 10});
        c.addProduct(p);
        c.printProductsAndInfo();
        c.removeProduct(p);
        c.printProductsAndInfo();
    }
}
