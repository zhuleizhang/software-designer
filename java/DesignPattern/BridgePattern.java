package DesignPattern;

public class BridgePattern {
    public static void main(String[] args) {
        System.out.println("DesignPattern BridgePattern start");

        BridgeAbstractProduct product = new BridgeProductA();
        BridgeColor color = new BridgeRed();
        product.setName("Apple Watch");
        product.setColor(color);
        product.operation();
    }
}

abstract class BridgeAbstractProduct {

    protected BridgeColor color;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setColor(BridgeColor color) {
        this.color = color;
    }

    abstract void operation();
}

class BridgeProductA extends BridgeAbstractProduct {
    @Override
    void operation() {
        this.color.fill(this.getName());
    }
}

interface BridgeColor {
    void fill(String name);
}

class BridgeRed implements BridgeColor {
    @Override
    public void fill(String name) {
        System.out.println("Red fill " + name);
    }
}

class BridgeBlue implements BridgeColor {
    @Override
    public void fill(String name) {
        System.out.println("Blue fill " + name);
    }
}
