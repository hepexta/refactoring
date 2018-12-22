package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Spec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeSpec implements Spec {
    private List<Spec> specs = new ArrayList<>();

    public void add(Spec spec) {
        specs.add(spec);
    }

    public boolean isSatisfiedBy(Product product) {
        boolean satisfiesAllSpecs = true;
        Iterator specifications = specs.iterator();
        while (specifications.hasNext()) {
            Spec productSpec = ((Spec)specifications.next());
            satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
        }
        return satisfiesAllSpecs;
    }
}
