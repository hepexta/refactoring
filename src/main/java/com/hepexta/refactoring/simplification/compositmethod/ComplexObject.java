package com.hepexta.refactoring.simplification.compositmethod;

import com.hepexta.refactoring.simplification.compositmethod.image.Card;
import com.hepexta.refactoring.simplification.compositmethod.image.Explanation;
import com.hepexta.refactoring.simplification.compositmethod.image.Graphics;
import com.hepexta.refactoring.simplification.compositmethod.image.Image;

public class ComplexObject {
    private Card card;
    private Explanation explanations;
    private boolean highlight;

    public String paintCard(Graphics g) {
        printCardImage(g);
        if (shouldHighlight())
            return paintCardHighlight(g);
        return paintCardText(g);
    }

    private void printCardImage(Graphics g) {
        g.drawImage(findImage());
    }

    private Image findImage() {
        Image image = null;
        if (card.getType().equals("Problem")) {
            image = explanations.getGameUI().problem;
        } else if (card.getType().equals("Solution")) {
            image = explanations.getGameUI().solution;
        } else if (card.getType().equals("Value")) {
            image = explanations.getGameUI().value;
        }
        return image;
    }

    private String paintCardText(Graphics g) {
        return g.toString();
    }

    private String paintCardHighlight(Graphics g) {
        g.setHighlight(true);
        return g.toString();
    }

    private boolean shouldHighlight() {
        return this.highlight;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setExplanations(Explanation explanations) {
        this.explanations = explanations;
    }

    public void setHighlight(boolean b) {
        this.highlight = b;
    }
}
