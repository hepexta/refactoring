package com.hepexta.refactoring.generalization.replaceImplicitLangWithInterpreter.spec;

import com.hepexta.refactoring.generalization.replaceDistinctionsWithComposite.Product;

import java.awt.*;

public class ColorSpec extends Spec {
    private Color colorOfProductToFind;

    public ColorSpec(Color colorOfProductToFind) {
        this.colorOfProductToFind = colorOfProductToFind;
    }

    public Color getColorOfProductToFind() {
        return colorOfProductToFind;
    }

    public boolean isSatisfiedBy(Product product) {
        return product.getColor().equals(colorOfProductToFind);
    }
}
