package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Spec;

public class BelowPriceSpec implements Spec {
    private double price;

    public BelowPriceSpec(double price) {
        this.price = price;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getAmount() < price;
    }
}
