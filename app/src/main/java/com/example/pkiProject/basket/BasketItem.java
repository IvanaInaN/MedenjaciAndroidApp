package com.example.pkiProject.basket;

import com.example.pkiProject.products.Product;

public class BasketItem {
    private Product product;
    private Integer count;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
