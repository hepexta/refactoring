package com.hepexta.refactoring.simplification.compositmethod;

import com.hepexta.refactoring.simplification.compositmethod.image.Card;
import com.hepexta.refactoring.simplification.compositmethod.image.Explanation;
import com.hepexta.refactoring.simplification.compositmethod.image.GameUI;
import com.hepexta.refactoring.simplification.compositmethod.image.Graphics;
import org.junit.Assert;
import org.junit.Test;

public class ComplexObjectTest {

    @Test
    public void test_nonHighlight(){
        ComplexObject complexObject = new ComplexObject();
        complexObject.setCard(new Card("Problem"));
        complexObject.setExplanations(new Explanation(GameUI.create("Problem", "Solution", "Value")));

        Assert.assertEquals("Graphics{image=Problem, highlight=false}", complexObject.paintCard(Graphics.create()));
    }

    @Test
    public void test_highlight(){
        ComplexObject complexObject = new ComplexObject();
        complexObject.setCard(new Card("Problem"));
        complexObject.setExplanations(new Explanation(GameUI.create("Problem", "Solution", "Value")));
        complexObject.setHighlight(true);

        Assert.assertEquals("Graphics{image=Problem, highlight=true}", complexObject.paintCard(Graphics.create()));
    }
}
