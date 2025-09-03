package DesignPattern;

public class Adapter {
    public static void main(String[] args) {
        Target target = new InnerAdapter();
        target.request();
    }
}

interface Target {
    public void request();
}

class InnerAdapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }

}

class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee specificRequest");
    }
}