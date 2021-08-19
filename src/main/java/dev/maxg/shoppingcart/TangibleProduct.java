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
public class TangibleProduct extends Product {
    private int weight;
    private int[] dimensions;

    public TangibleProduct(String name, int price, int weight, int[] dimensions) throws IllegalArgumentException {
        super(name, price);
        this.weight = weight;
        if (dimensions.length != 3) {
            throw new IllegalArgumentException("dimensions must be [length, width, height]");
        }
        this.dimensions = dimensions;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }
    
    
    
}
