package com.hepexta.refactoring.simplification.replaceImplicitTreeWithComposite;

public class Product {
    private String name;
    private String size;
    private String id;
    private Price price;
    private String color;

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public static Builder newBuilder() {
        return new Product().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }
        public Builder setPrice(Price price) {
            Product.this.price = price;
            return this;
        }

        public Builder setColor(String color) {
            Product.this.color = color;
            return this;
        }

        public Builder setId(String id) {
            Product.this.id = id;
            return this;
        }

        public Builder setSize(String size) {
            Product.this.size = size;
            return this;
        }

        public Builder setName(String name) {
            Product.this.name = name;
            return this;
        }

        public Product build() {
            return Product.this;
        }
    }
}
