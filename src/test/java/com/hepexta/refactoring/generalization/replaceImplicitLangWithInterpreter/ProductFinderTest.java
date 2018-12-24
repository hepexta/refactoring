package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.ProductRepository;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.ProductSize;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductFinderTest {
    private ProductFinder finder;

    private Product fireTruck =
            new Product("f1234", "Fire Truck",
                    Color.red, 8.95f, ProductSize.MEDIUM);

    private Product barbieClassic =
            new Product("b7654", "Barbie Classic",
                    Color.yellow, 15.95f, ProductSize.SMALL);

    private Product frisbee =
            new Product("f4321", "Frisbee",
                    Color.pink, 9.99f, ProductSize.LARGE);

    private Product baseball =
            new Product("b2343", "Baseball",
                    Color.white, 8.95f, ProductSize.NOT_APPLICABLE);

    private Product toyConvertible =
            new Product("p1112", "Toy Porsche Convertible",
                    Color.red, 230.00f, ProductSize.NOT_APPLICABLE);

    @Before
    public void setUp() {
        finder = new ProductFinder(createProductRepository());
    }

    private ProductRepository createProductRepository() {
        ProductRepository repository = new ProductRepository();
        repository.add(fireTruck);
        repository.add(barbieClassic);
        repository.add(frisbee);
        repository.add(baseball);
        repository.add(toyConvertible);
        return repository;
    }

    @Test
    public void testFindByColor() {
        List foundProducts = finder.byColor(Color.red);
        assertEquals("found 2 red products", 2, foundProducts.size());
        assertTrue("found fireTruck", foundProducts.contains(fireTruck));
        assertTrue( "found Toy Porsche Convertible", foundProducts.contains(toyConvertible));
    }

    @Test
    public void testFindByPrice() {
        List foundProducts = finder.byPrice(8.95f);
        assertEquals("found products that cost $8.95", 2, foundProducts.size());
        for (Iterator i = foundProducts.iterator(); i.hasNext();) {
            Product p = (Product) i.next();
            assertTrue(p.getAmount() == 8.95f);
        }
    }

    @Test
    public void testFindByColorSizeAndBelowPrice() {
        List foundProducts = finder.byColorSizeAndBelowPrice(Color.red, ProductSize.SMALL, 10.00f);
        assertEquals("found no small red products below $10.00", 0, foundProducts.size());

        foundProducts = finder.byColorSizeAndBelowPrice(Color.red, ProductSize.MEDIUM, 10.00f);
        assertEquals("found firetruck when looking for cheap medium red toys", fireTruck, foundProducts.get(0));
    }

    @Test
    public void testFindBelowPriceAvoidingAColor() {
        List foundProducts = finder.belowPriceAvoidingAColor(9.00f, Color.white);
        assertEquals( "found 1 non-white product < $9.00", 1, foundProducts.size());
        assertTrue("found fireTruck", foundProducts.contains(fireTruck));

        foundProducts = finder.belowPriceAvoidingAColor(9.00f, Color.red);
        assertEquals( "found 1 non-red product < $9.00", 1, foundProducts.size());
        assertTrue("found baseball", foundProducts.contains(baseball));
    }
}
