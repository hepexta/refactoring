package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

import org.junit.Assert;
import org.junit.Test;

public class OrdersWriterTest {
    @Test
    public void testOneOrderWithTwoProducts() {
        String expectedResult =
                "<orders>" +
                    "<order id=’321’>" +
                        "<product id=’f1234’ color=’red’ size=’medium’>" +
                            "<price currency=’USD’>" +
                            "8.95" +
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
        Assert.assertEquals(expectedResult, writer.getContents());
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
