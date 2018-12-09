package com.hepexta.refactoring.encapsuation.composit;

import com.hepexta.refactoring.encapsuation.composit.tags.Activity;
import com.hepexta.refactoring.encapsuation.composit.tags.Flavor;
import com.hepexta.refactoring.encapsuation.composit.tags.Requirement;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CatalogWriterTest {

    @Test
    public void catalogXmlFor() {

        String expected = "<activity>" +
                "<flavors>" +
                    "<flavor>" +
                        "<requirements>" +
                            "<requirement>red</requirement>" +
                            "<requirement>big</requirement>" +
                        "</requirements>" +
                    "</flavor>" +
                    "<flavor>" +
                        "<requirements>" +
                            "<requirement>blue</requirement>" +
                            "<requirement>big</requirement>" +
                            "<requirement>no leafs</requirement>" +
                        "</requirements>" +
                    "</flavor>" +
                "</flavors>" +
            "</activity>";

        Activity activity = new Activity();
        Flavor flavor1 = prepareFlavor("red", "big");
        Flavor flavor2 = prepareFlavor("blue", "big", "no leafs");
        activity.setFlavours(Arrays.asList(flavor1, flavor2));

        String xml = new CatalogWriter().catalogXmlFor(activity);
        Assert.assertEquals(expected, xml);
    }

    private Flavor prepareFlavor(String...reqs) {
        Requirement[] requirements = new Requirement[reqs.length];
        for (int i=0; i<reqs.length; i++) {
            requirements[i] = new Requirement(reqs[i]);
        }
        return new Flavor(requirements);
    }

}
