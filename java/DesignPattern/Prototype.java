package DesignPattern;

public class Prototype {
    public static void main(String[] args) {
        System.out.println("DesignPattern Prototype start");

        ProductSupportClone product = new ProductSupportClone("Apple Watch", 100);
        System.out.println(product.getName() + " " + product.getPrice());
        ProductSupportClone newProduct = (ProductSupportClone) product.Clone();
        System.out.println(newProduct.getName() + " " + newProduct.getPrice());
    }
}

interface InnerPrototype {
    public Object Clone();
}

class ProductSupportClone implements InnerPrototype {
    private String name;
    private double price;

    public ProductSupportClone() {
    }

    public ProductSupportClone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public Object Clone() {
        ProductSupportClone newProduct = new ProductSupportClone();
        newProduct.name = this.name;
        newProduct.price = this.price;

        return newProduct;
    }
}
