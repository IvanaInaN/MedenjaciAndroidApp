package com.example.pkiProject.basket;

import java.util.ArrayList;
import java.util.List;

public class ProductsInBasket {
    private static final ProductsInBasket instance = new ProductsInBasket();

    //private constructor to avoid client applications to use constructor
    private ProductsInBasket(){}

    public static ProductsInBasket getInstance(){
        return instance;
    }

    public List<BasketItem> products = new ArrayList<>();
    public void addToBasket(BasketItem product){
        products.add(product);
    }

    public void removeAll(){
        products = new ArrayList<>();
    }

}
