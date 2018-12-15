package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Order> orders = new ArrayList<>();

    public Order getOrder(int i) {
        return orders.get(i);
    }

    public int getOrderCount() {
        return orders.size();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }
}
