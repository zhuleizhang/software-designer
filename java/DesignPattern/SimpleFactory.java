package DesignPattern;

public class SimpleFactory {
    public static void main(String[] args) {
        Product productA = Factory.Create("A");
        productA.show();
        Product productB = Factory.Create("B");
        productB.show();
    }
}

class Factory {
    public static Product Create(String type) {
        Product product = null;

        switch (type) {
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;

            default:
                break;
        }

        return product;
    }

}

abstract class Product {
    public abstract void show();
}

class ProductA extends Product {
    @Override
    public void show() {
        System.out.println("ProductA");
    }
}

class ProductB extends Product {
    @Override
    public void show() {
        System.out.println("ProductB");
    }
}