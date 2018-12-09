package com.hepexta.refactoring.simplification.compositmethod.image;

public class Graphics {

    private Image image;
    private boolean highlight;

    public static Graphics create() {
        return new Graphics();
    }

    public void drawImage(Image image) {
        this.image = image;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    @Override
    public String toString() {
        return "Graphics{" +
                "image=" + image.getImage() +
                ", highlight=" + highlight +
                '}';
    }
}
