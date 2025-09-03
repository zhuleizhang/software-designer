package DesignPattern;

public class AbstractFactory {
    public static void main(String[] args) {
        ProductFactory factory1 = new ProductFactory1();
        AbstractProductA productA = factory1.createProductA();
        productA.show();
        AbstractProductB productB = factory1.createProductB();
        productB.show();

        System.out.println("------------------");

        ProductFactory factory2 = new ProductFactory2();
        AbstractProductA productA2 = factory2.createProductA();
        productA2.show();
        AbstractProductB productB2 = factory2.createProductB();
        productB2.show();
    }
}

interface ProductFactory {
    public AbstractProductA createProductA();

    public AbstractProductB createProductB();
}

class ProductFactory1 implements ProductFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ProductFactory2 implements ProductFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

interface AbstractProductA {
    public void show();
}

class ProductA1 implements AbstractProductA {

    public void show() {
        System.out.println("ProductA1");
    }
}

class ProductA2 implements AbstractProductA {

    public void show() {
        System.out.println("ProductA2");
    }
}

interface AbstractProductB {
    public void show();
}

class ProductB1 implements AbstractProductB {
    @Override
    public void show() {
        System.out.println("ProductB1");
    }
}

class ProductB2 implements AbstractProductB {
    @Override
    public void show() {
        System.out.println("ProductB2");
    }
}