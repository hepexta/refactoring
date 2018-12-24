package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter.spec;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;

public class NotSpec extends Spec {
    private Spec specToNegate;

    public NotSpec(Spec specToNegate) {
        this.specToNegate = specToNegate;
    }
    public boolean isSatisfiedBy(Product product) {
        return !specToNegate.isSatisfiedBy(product);
    }
}
