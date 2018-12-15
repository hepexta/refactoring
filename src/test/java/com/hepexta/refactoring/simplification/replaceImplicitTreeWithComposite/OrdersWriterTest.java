package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrdersWriterTest {

    private static final String SAMPLE_PRICE = "8.95";

    @Test
    public void testOneOrderWithTwoProducts() {
        String expectedResult =
                "<orders>" +
                    "<order id=’321’>" +
                        "<product id=’f1234’ color=’red’ size=’medium’>" +
                            "<price currency=’USD’>" +
                                SAMPLE_PRICE +
                            "</price>" +
                            "Fire Truck" +
                        "</product>" +
                        "<product id=’p1112’ color=’red’>" +
                            "<price currency=’USD’>" +
                            "230.0" +
                            "</price>" +
                            "Toy Porsche Convertible" +
                        "</product>" +
                    "</order>" +
                 "</orders>";
        Orders orders = new Orders();
        Order order = new Order(321);
        order.addProduct(prepareProduct("f1234", "red", "Fire Truck", new Price("USD", 8.95f), "medium"));
        order.addProduct(prepareProduct("p1112", "red", "Toy Porsche Convertible", new Price("USD", 230f), null));
        orders.placeOrder(order);
        OrdersWriter writer = new OrdersWriter(orders);
        assertEquals(expectedResult, writer.getContents());
    }

    @Test
    public void testSimpleTagWithOneAttributeAndValue() {
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency", "USD");
        priceTag.addValue(SAMPLE_PRICE);
        String expected = "<price currency=’USD’>" +
                            SAMPLE_PRICE +
                        "</price>";
        assertEquals("price XML", expected, priceTag.toString());
    }

    @Test
    public void testCompositeTagOneChild() {
        TagNode productTag = new TagNode("product");
        productTag.add(new TagNode("price"));
        String expected =
                "<product>" +
                    "<price>" +
                    "</price>" +
                "</product>";
        assertEquals("price XML", expected, productTag.toString());
    }

    @Test
    public void testAddingChildrenAndGrandchildren() {
        String expected =
                "<orders>" +
                    "<order>" +
                    "<product>" +
                    "</product>" +
                    "</order>" +
                "</orders>";

        TagNode ordersTag = new TagNode("orders");
        TagNode orderTag = new TagNode("order");
        TagNode productTag = new TagNode("product");
        ordersTag.add(orderTag);
        orderTag.add(productTag);
        assertEquals("price XML", expected, ordersTag.toString());
    }

    private Product prepareProduct(String id, String color, String name, Price price, String size) {
        return Product.newBuilder()
                .setColor(color)
                .setId(id)
                .setName(name)
                .setPrice(price)
                .setSize(size)
                .build();
    }
}
