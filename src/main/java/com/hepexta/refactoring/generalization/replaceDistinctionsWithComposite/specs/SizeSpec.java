package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Spec;

public class SizeSpec implements Spec {
    private String size;

    public SizeSpec(String size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getSize().equals(size);
    }
}
