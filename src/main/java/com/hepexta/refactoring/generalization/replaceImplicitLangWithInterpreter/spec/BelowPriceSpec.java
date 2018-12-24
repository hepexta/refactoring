package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter.spec;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;

public class BelowPriceSpec extends Spec {
    private float price;

    public BelowPriceSpec(float price) {
        this.price = price;
    }

    public boolean isSatisfiedBy(Product product) {
        return product.getAmount() < (price);
    }
}
