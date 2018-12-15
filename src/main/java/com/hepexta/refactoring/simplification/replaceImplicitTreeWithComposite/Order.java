package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Product> productMap = new ArrayList<>();

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductCount() {
        return productMap.size();
    }

    public Product getProduct(int index) {
        return productMap.get(index);
    }

    public void addProduct(Product product) {
        productMap.add(product);
    }
}
