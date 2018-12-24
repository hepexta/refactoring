package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter.spec;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;

public class AndSpec extends Spec {
    private Spec[] andSpecs;

    public AndSpec(Spec...specs) {
        this.andSpecs = specs;
    }

    public boolean isSatisfiedBy(Product product) {
        boolean result = true;
        for (Spec andSpec : andSpecs) {
            result &= andSpec.isSatisfiedBy(product);
        }
        return result;
    }
}
