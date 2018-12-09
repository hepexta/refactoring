package com.hepexta.refactoring.encapsuation.composit.tags;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    private List<Flavor> flavours = new ArrayList();

    public void setFlavours(List<Flavor> flavours) {
        this.flavours = flavours;
    }

    public int getFlavorCount() {
        return flavours.size();
    }

    public Flavor getFlavor(int index) {
        return flavours.get(index);
    }
}
