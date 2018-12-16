package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository {
    private List products = new ArrayList();

    public Iterator iterator() {
        return products.iterator();
    }

    public List selectBy(Spec spec) {
        List foundProducts = new ArrayList();
        Iterator products = iterator();
        while (products.hasNext()) {
            Product product = (Product)products.next();
            if (spec.isSatisfiedBy(product))
                foundProducts.add(product);
        }
        return foundProducts;
    }

    public List selectBy(List specs) {
        List foundProducts = new ArrayList();
        Iterator products = iterator();
        while (products.hasNext()) {
            Product product = (Product)products.next();
            Iterator specifications = specs.iterator();
            boolean satisfiesAllSpecs = true;
            while (specifications.hasNext()) {
                Spec productSpec = ((Spec)specifications.next());
                satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
            }
            if (satisfiesAllSpecs)
                foundProducts.add(product);
        }
        return foundProducts;
    }

    public void add(Product product) {
        products.add(product);
    }
}
