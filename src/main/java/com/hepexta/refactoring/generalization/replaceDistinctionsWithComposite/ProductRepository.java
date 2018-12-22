package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs.CompositeSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * For the system on which this example code was based,
 * there is a need to support queries with OR, AND, and
 * NOT conditions, like this one:
 *
 * product.getColor() != targetColor ||
 * product.getPrice() < targetPrice
 *
 * The List-based selectBy(…) method cannot support such queries.
 * In addition, having just one selectBy(…) method is preferred
 * so clients can call it in a uniform way. Therefore, I decide
 * to refactor to the Composite pattern by implementing the following steps.
 * */
public class ProductRepository {
    private List products = new ArrayList();

    public Iterator iterator() {
        return products.iterator();
    }

    public List selectBy(Spec spec) {
        Spec[] specs = { spec };
        return selectBy(Arrays.asList(specs));
    }

    public List selectBy(List specs) {
        CompositeSpec spec = new CompositeSpec(specs);
        List foundProducts = new ArrayList();
        Iterator products = iterator();
        while (products.hasNext()) {
            Product product = (Product)products.next();
            if (spec.isSatisfies(product))
                foundProducts.add(product);
        }
        return foundProducts;
    }

    public void add(Product product) {
        products.add(product);
    }
}
