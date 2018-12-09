package com.hepexta.refactoring.encapsuation.composit;

import com.hepexta.refactoring.encapsuation.composit.tags.Activity;
import com.hepexta.refactoring.encapsuation.composit.tags.Flavor;
import com.hepexta.refactoring.encapsuation.composit.tags.Requirement;

public class CatalogWriter {

    // Example of Composite-construction code encapsulated with Builder
    public String catalogXmlFor(Activity activity) {
        TagBuilder builder = new TagBuilder("activity");
        builder.addChild("flavors");
        for (int i=0; i < activity.getFlavorCount(); i++) {
            builder.addToParent("flavors", "flavor");
            Flavor flavor = activity.getFlavor(i);
            int requirementsCount = flavor.getRequirements().length;
            if (requirementsCount > 0) {
                builder.addChild("requirements");
                for (int r=0; r < requirementsCount; r++) {
                    Requirement requirement = flavor.getRequirements()[r];
                    builder.addToParent("requirements", "requirement");
                    builder.addValue(requirement.getRequirement());
                }
            }
        }
        return builder.toXml();
    }

}
