package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

public class OrdersWriter {

    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer xml = new StringBuffer();
        writeOrderTo(xml);
        return xml.toString();
    }

    private void writeOrderTo(StringBuffer xml) {
        TagNode ordersTag = new TagNode("orders");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            TagNode orderTag = new TagNode("order");
            orderTag.addAttribute("id", String.valueOf(order.getOrderId()));
            writeProductsTo(orderTag, order);
            ordersTag.add(orderTag);
        }
        xml.append(ordersTag.toString());
    }

    private void writeProductsTo(TagNode node, Order order) {
        for (int j=0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            TagNode productTag = new TagNode("product");
            productTag.addAttribute("id", product.getId());
            productTag.addAttribute("color", colorFor(product));
            if (product.getSize() != null)
                productTag.addAttribute("size", sizeFor(product));
            writePriceTo(productTag, product);
            productTag.addValue(product.getName());
            node.add(productTag);
        }
    }

    private String sizeFor(Product product) {
        return product.getSize();
    }

    private String colorFor(Product product) {
        return product.getColor();
    }

    private void writePriceTo(TagNode productTag, Product product) {
        TagNode priceNode = new TagNode("price");
        priceNode.addAttribute("currency", currencyFor(product));
        priceNode.addValue(priceFor(product));
        productTag.add(priceNode);
    }

    private String priceFor(Product product) {
        return String.valueOf(product.getPrice().getPrice());
    }

    private String currencyFor(Product product) {
        return product.getPrice().getCurrency();
    }

}
