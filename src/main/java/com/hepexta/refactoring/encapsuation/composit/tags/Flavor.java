package com.hepexta.refactoring.encapsuation.composit.tags;

public class Flavor {

    private Requirement[] requirements;

    public Flavor(Requirement[] requirements) {
        this.requirements = requirements;
    }

    public Requirement[] getRequirements() {
        return requirements;
    }
}
