package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    public static void main(String[] args) {
        System.out.println("DesignPattern Builder start");

        Director director = new Director();
        AbstractBuilder builder1 = new Builder1();
        director.construct(builder1);
        BuilderProduct product1 = builder1.getResult();
        product1.show();

        AbstractBuilder builder2 = new Builder2();
        director.construct(builder2);
        BuilderProduct product2 = builder2.getResult();
        product2.show();
    }
}

class Director {
    public void construct(AbstractBuilder builder) {
        builder.buildPart();
    }
}

class BuilderProduct {
    List<String> parts = new ArrayList<String>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        for (String part : parts) {
            System.out.print(part + " ");
        }
        System.out.println();
    }
}

abstract class AbstractBuilder {
    public abstract void buildPart();

    public abstract BuilderProduct getResult();
}

class Builder1 extends AbstractBuilder {
    BuilderProduct product = new BuilderProduct();

    @Override
    public void buildPart() {
        product.add("partA");
        product.add("partB");
    }

    @Override
    public BuilderProduct getResult() {
        return product;
    }
}

class Builder2 extends AbstractBuilder {
    BuilderProduct product = new BuilderProduct();

    @Override
    public void buildPart() {
        product.add("partE");
        product.add("partF");
    }

    @Override
    public BuilderProduct getResult() {
        return product;
    }
}