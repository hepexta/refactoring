package com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs.BelowPriceSpec;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs.ColorSpec;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs.CompositeSpec;
import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.specs.SizeSpec;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductRepositoryTest {
    private ProductRepository repository;

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
        repository = new ProductRepository();
        repository.add(fireTruck);
        repository.add(barbieClassic);
        repository.add(frisbee);
        repository.add(baseball);
        repository.add(toyConvertible);
    }

    @Test
    public void testFindByColor() {
        List foundProducts = repository.selectBy(new ColorSpec(Color.red));
        assertEquals( "red products", 2, foundProducts.size());
    }

    @Test
    public void testFindByColorSizeAndBelowPrice() {
        CompositeSpec specs = new CompositeSpec();
        specs.add(new ColorSpec(Color.red));
        specs.add(new SizeSpec(ProductSize.SMALL));
        specs.add(new BelowPriceSpec(10.00));
        List foundProducts = repository.selectBy(specs);
        assertEquals(
                "small red products below $10.00",
                0,
                foundProducts.size());
    }
}
