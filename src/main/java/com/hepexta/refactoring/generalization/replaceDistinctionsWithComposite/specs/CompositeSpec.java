package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Spec;

import java.util.Iterator;
import java.util.List;

public class CompositeSpec {
    private List specs;

    public CompositeSpec(List specs) {
        this.specs = specs;
    }

    public List getSpecs() {
        return specs;
    }

    public boolean isSatisfies(Product product) {
        boolean satisfiesAllSpecs = true;
        Iterator specifications = specs.iterator();
        while (specifications.hasNext()) {
            Spec productSpec = ((Spec)specifications.next());
            satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
        }
        return satisfiesAllSpecs;
    }
}
