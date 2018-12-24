package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.ProductRepository;
import com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter.spec.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductFinder {

    private ProductRepository repository;

    public ProductFinder(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    public List byColor(Color colorOfProductToFind) {
        ColorSpec spec = new ColorSpec(colorOfProductToFind);
        return selectBy(spec);
    }

    public List byPrice(float priceLimit) {
        ByPriceSpec spec = new ByPriceSpec(priceLimit);
        return selectBy(spec);
    }

    public List byColorSizeAndBelowPrice(Color color, String size, float price) {
        AndSpec andSpec = new AndSpec(new ColorSpec(color), new BelowPriceSpec(price), new SizeSpec(size));
        return selectBy(andSpec);
    }
    
    public List belowPriceAvoidingAColor(float price, Color color) {
        AndSpec andSpec = new AndSpec(new BelowPriceSpec(price), new NotSpec(new ColorSpec(color)));
        return selectBy(andSpec);
    }

    private List selectBy(Spec spec) {
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (spec.isSatisfiedBy(product))
                foundProducts.add(product);
        }
        return foundProducts;
    }
}
