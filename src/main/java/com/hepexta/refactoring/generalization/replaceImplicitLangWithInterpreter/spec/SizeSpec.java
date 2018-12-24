package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter.spec;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;

public class SizeSpec extends Spec {
    private String size;

    public SizeSpec(String size) {
        this.size = size;
    }

    public boolean isSatisfiedBy(Product product) {
        return product.getSize().equals(size);
    }
}
