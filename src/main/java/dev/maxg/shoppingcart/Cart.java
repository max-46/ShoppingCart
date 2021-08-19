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

    public boolean addProduct(Product product) {
        int numAvailable = product.getNumAvailable();
        if (numAvailable > 0) {
            products.add(product);
            product.setNumAvailable(numAvailable--);
            return true;
        }
        return false;
    }

    public void removeProduct(Product product) {
        int numAvailable = product.getNumAvailable();
        products.remove(product);
        product.setNumAvailable(numAvailable++);
    }

    public BigDecimal totalPrice() {
        int total = products.stream().map(Product::getPrice).reduce(0, (a, b) -> a + b);
        return new BigDecimal(total / 100).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public void printProductsAndInfo() {
        System.out.println("The products in your cart are:");
        products.forEach(p -> {
            System.out.println(p);
        });
        System.out.println("The total amount is £" + this.totalPrice());
    }

    public static void main(String[] args) {
        Cart c = new Cart();
        c.addProduct(new Product("iTunes Giftcard", 10000, 100));
        
        int[] dimensions = new int[]{100, 5, 30};
        c.addProduct(new TangibleProduct("Sony TV", 12000, 2000, 20, dimensions));
        
        Product awh = new TangibleProduct("Anker Wireless Headphones", 8000, 500, 40, new int[]{10, 10, 10});
        c.addProduct(awh);
        
        c.printProductsAndInfo();
        c.removeProduct(awh);
        c.printProductsAndInfo();
        
        Product hkm = new TangibleProduct("Hello Kitty Mug", 200, 0, 2000, new int[]{10, 10, 10});
        System.out.println("Num available: " + hkm.getNumAvailable());
        boolean res = c.addProduct(hkm);
        if (!res) {
            System.out.println("Could not add product " + hkm);
        }
        c.printProductsAndInfo();
    }
}
