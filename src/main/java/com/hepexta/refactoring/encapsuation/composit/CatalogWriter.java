package com.hepexta.refactoring.encapsuation.composit;

import com.hepexta.refactoring.encapsuation.composit.tags.Activity;
import com.hepexta.refactoring.encapsuation.composit.tags.Flavor;
import com.hepexta.refactoring.encapsuation.composit.tags.Requirement;

public class CatalogWriter {

    // Example of Composite-construction code
    public String catalogXmlFor(Activity activity) {
        TagNode activityTag = new TagNode("activity");
        TagNode flavorsTag = new TagNode("flavors");
        activityTag.add(flavorsTag);
        for (int i=0; i < activity.getFlavorCount(); i++) {
            TagNode flavorTag = new TagNode("flavor");

            flavorsTag.add(flavorTag);
            Flavor flavor = activity.getFlavor(i);
            int requirementsCount = flavor.getRequirements().length;
            if (requirementsCount > 0) {
                TagNode requirementsTag = new TagNode("requirements");
                flavorTag.add(requirementsTag);
                for (int r=0; r < requirementsCount; r++) {
                    Requirement requirement = flavor.getRequirements()[r];
                    TagNode requirementTag = new TagNode("requirement");
                    requirementTag.addValue(requirement.getRequirement());
                    requirementsTag.add(requirementTag);
                }
            }
        }
        return activityTag.toString();
    }

}
