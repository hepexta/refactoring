package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter.spec;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;

public class ByPriceSpec extends Spec {
    private float price;

    public ByPriceSpec(float price) {
        this.price = price;
    }

    public boolean isSatisfiedBy(Product product) {
        return product.getAmount() == (price);
    }
}
