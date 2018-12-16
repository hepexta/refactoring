package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Spec;

import java.awt.Color;

public class ColorSpec implements Spec {
    private Color color;

    public ColorSpec(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getColor().equals(color);
    }
}
