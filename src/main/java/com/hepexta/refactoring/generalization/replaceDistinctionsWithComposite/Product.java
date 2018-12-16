package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite;

import java.awt.*;

public class Product {

    private String id;
    private String name;
    private Color color;
    private float amount;
    private String size;

    public Product(String id, String name, Color color, float amount, String size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.amount = amount;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public float getAmount() {
        return amount;
    }

    public String getSize() {
        return size;
    }
}
