package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.ProductRepository;

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
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (product.getColor().equals(colorOfProductToFind))
                foundProducts.add(product);
        }
        return foundProducts;
    }
    public List byPrice(float priceLimit) {
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (product.getAmount() == priceLimit)
                foundProducts.add(product);
        }
        return foundProducts;
    }

    public List byColorSizeAndBelowPrice(Color color, String size, float price) {
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (product.getColor() == color
                    && product.getSize() == size
                    && product.getAmount() < price)
                foundProducts.add(product);
        }
        return foundProducts;
    }
    public List belowPriceAvoidingAColor(float price, Color color) {
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();

            if (product.getAmount() < price && product.getColor() != color)
                foundProducts.add(product);
        }
        return foundProducts;
    }
}
